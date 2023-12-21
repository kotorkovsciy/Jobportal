/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules;

import com.jobportal.jobportal.Api.modules.Responses.Auth.LoginResponse;
import com.jobportal.jobportal.Api.modules.Requests.Auth.LoginRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import com.jobportal.jobportal.Api.Urls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kotorkovsciy
 */
public class Auth {
    public static LoginResponse login(LoginRequest credentials) throws IOException, JSONException, HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(Urls.loginUrl);

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("username", credentials.username));
        params.add(new BasicNameValuePair("password", credentials.password));

        HttpEntity requestParams = new UrlEncodedFormEntity(params);
        request.setEntity(requestParams);
        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONObject response = HttpUtils.getContent(httpResponse);

        httpClient.close();

        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }

        return new LoginResponse(response.getString("auth_token"));
    }

    public static void logout(String token) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(Urls.logoutUrl);

        HttpUtils.setToken(request, token);

        httpClient.execute(request);

        httpClient.close();
    }
}
