package com.github.albalitz.save.persistence.export;

import android.os.Environment;
import android.util.Log;

import com.github.albalitz.save.R;
import com.github.albalitz.save.SaveApplication;
import com.github.albalitz.save.persistence.Link;
import com.github.albalitz.save.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by albalitz on 4/29/17.
 */
public class SavedLinksExporter {
    public static boolean export(ArrayList<Link> savedLinks) {
        File file = getExportStorageDir("save-link-export.json");

        if (savedLinks.isEmpty()) {
            Utils.showToast(SaveApplication.getAppContext(), "Nothing to export. Save something first. ;)");
        }

        JSONArray savedLinksJson = new JSONArray();
        for (Link link : savedLinks) {
            try {
                savedLinksJson.put(link.json());
            } catch (JSONException e) {
                Log.e("SavedLinksExporter", e.toString());
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(savedLinksJson.toString(4));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            Log.e("SavedLinksExporter", e.toString());
            return false;
        } catch (JSONException e) {
            Log.e("SavedLinksExporter", e.toString());
            return false;
        }

        Log.i("SavedLinksExporter", "Exported to " + file.getAbsolutePath());
        Utils.showToast(SaveApplication.getAppContext(), "Exported " + savedLinks.size() + " links to " + file.getPath());
        return true;
    }

    private static File getExportStorageDir(String filename) {
        File path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), SaveApplication.getAppContext().getString(R.string.app_name));
        File file = new File(path, filename);
        file.setWritable(true);

        Log.i("SavedLinksExporter", "Creating path: " + path.getAbsolutePath() + "; for file: " + filename);
        if (!path.mkdirs() && !path.exists()) {
            Log.e("SavedLinksExporter", "Couldn't create directory.");
        }
        return file;
    }
}
