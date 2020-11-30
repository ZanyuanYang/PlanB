package com.example.planb_backend.task;

import android.os.AsyncTask;
import android.util.Log;

import com.example.planb_backend.request.HttpRequest;
import com.example.planb_frontend.BuildConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class HttpRequestTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... strings) {

        if (BuildConfig.DEBUG && strings.length != 3) {
            throw new AssertionError("Failed to initialize request. Insufficient parameters.");
        }

        JSONObject msg = new JSONObject();
        try {
            msg.put("uid", strings[0]);
            msg.put("tid", strings[1]);
            msg.put("name", strings[2]);
            HttpRequest request = new HttpRequest();
            request.post("https://fast-lake-56310.herokuapp.com/send_notification", msg.toString());
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}