package com.buildmyapp.android.Network;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class NetworkAdapter {

    final static int TIMEOUT = 5000;


    public static String httpRequest(String urlString, String requestType, JSONObject object, Map<String, String> headerProps) throws IOException {

        String result = "";
        InputStream stream = null;
        HttpURLConnection connection = null;


        try {
            URL apiUrl = new URL(urlString);
            connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setReadTimeout(TIMEOUT);
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestMethod(requestType);

            if (headerProps != null) {
                for (Map.Entry<String, String> entry : headerProps.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            connection.setDoInput(true);

            if ((requestType.equals("POST") || requestType.equals("PUT")) && object != null) {
                connection.setRequestProperty("Content-Type","application/json");
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(object.toString().getBytes());
                outputStream.close();
            } else {
                connection.connect();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                result = Integer.toString(responseCode);
                throw new IOException("HTTP error code: " + responseCode);
            }

            stream = connection.getInputStream();
            if (stream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();
                String line = reader.readLine();
                while (line != null) {
                    builder.append(line);
                    line = reader.readLine();
                }
                result = builder.toString();

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (stream != null) {

                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return result;
    }

}
