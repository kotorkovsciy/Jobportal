/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules;

/**
 *
 * @author kotorkovsciy
 */
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpUtils {
    private static String httpResponseToString(CloseableHttpResponse httpResponse) throws IOException, JSONException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        httpResponse.getEntity().getContent()
                )
        );

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        return response.toString();
    }
    public static JSONObject getContent(CloseableHttpResponse httpResponse) throws IOException, JSONException {
        String response = httpResponseToString(httpResponse);

        return new JSONObject(response);
    }

    public static JSONArray getArrayContent(CloseableHttpResponse httpResponse) throws IOException, JSONException {
        String response = httpResponseToString(httpResponse);

        return new JSONArray(response);
    }

    public static void setToken(HttpPost httpPost, String token){
        httpPost.addHeader("Authorization", "Token " + token);
    }

    public static void setToken(HttpGet httpGet, String token){
        httpGet.addHeader("Authorization", "Token " + token);
    }

    public static void setToken(HttpPut httpPut, String token){
        httpPut.addHeader("Authorization", "Token " + token);
    }
}