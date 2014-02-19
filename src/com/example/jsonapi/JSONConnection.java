package com.example.jsonapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONConnection {

    public JSONConnection(){}

    public JSONObject connect(String address) throws IOException {

        URL url = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.connect();

        OutputStreamWriter request = new OutputStreamWriter(connection.getOutputStream());
        request.flush();
        request.close();

        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        com.example.jsonapi.JSONTokener jsonTokener = new com.example.jsonapi.JSONTokener(reader);
        JSONObject jsonObject = new JSONObject(jsonTokener);
        isr.close();
        reader.close();
        return jsonObject;

    }
}
