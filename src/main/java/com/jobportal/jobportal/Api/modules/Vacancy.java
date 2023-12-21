/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules;

import com.jobportal.jobportal.Api.Urls;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;

import com.jobportal.jobportal.Api.modules.Responses.Vacancy.AmountResponsesResponse;
import com.jobportal.jobportal.Api.modules.Requests.Vacancy.VacancyResponsesRequests;
import com.jobportal.jobportal.Api.modules.Responses.Vacancy.VacancyResponsesResponse;
import com.jobportal.jobportal.Api.modules.Responses.Vacancy.VacancyResponseResponse;
import com.jobportal.jobportal.Api.modules.Requests.Vacancy.VacancyResponseRequests;
/**
 *
 * @author kotorkovsciy
 */
public class Vacancy {
    public static List<AmountResponsesResponse> getAmountResponses(String token)  throws IOException, JSONException, HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(Urls.amount_responsesUrl);
        
        HttpUtils.setToken(request, token);
        
        CloseableHttpResponse httpResponse = httpClient.execute(request);
        
        JSONArray response = HttpUtils.getArrayContent(httpResponse);
        
        httpClient.close();
        
        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }
        
        List<AmountResponsesResponse> amountResponses = new ArrayList<AmountResponsesResponse>();
        
        for (int i = 0; i < response.length(); i++){
            JSONObject res = new JSONObject(response.get(i).toString());
                amountResponses.add(new AmountResponsesResponse(
                             res.getInt("id"),
                             res.getString("title"),
                             res.getInt("amount_responses")
                       )
                );
        }
        
        return amountResponses;
    }
    
    public static List<VacancyResponsesResponse> getResponses(VacancyResponsesRequests data, String token) throws IOException, JSONException, HttpException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        URI uri = new URIBuilder(Urls.responsesUrl)
                    .addParameter("id", String.valueOf(data.id))
                    .build();

        HttpGet request = new HttpGet(uri);
        
        HttpUtils.setToken(request, token);
        
        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONArray response = HttpUtils.getArrayContent(httpResponse);

        httpClient.close();
        
        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }
        
        List<VacancyResponsesResponse> vacancyResponses = new ArrayList<VacancyResponsesResponse>();
        
        for (int i = 0; i < response.length(); i++){
            JSONObject res = new JSONObject(response.get(i).toString());
                vacancyResponses.add(new VacancyResponsesResponse(
                             res.getInt("id"),
                             res.getString("title"),
                             res.getString("created_at")
                       )
                );
        }
        
        return vacancyResponses;
    }
    
    public static VacancyResponseResponse getResponse(VacancyResponseRequests data, String token) throws IOException, JSONException, HttpException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        URI uri = new URIBuilder(Urls.responseUrl)
                    .addParameter("id", String.valueOf(data.id))
                    .build();
        
        HttpGet request = new HttpGet(uri);
        
        HttpUtils.setToken(request, token);
        
        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONObject response = HttpUtils.getContent(httpResponse);

        httpClient.close();
        
        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }
        
        return new VacancyResponseResponse(
                    response.getInt("id"),
                    response.getJSONObject("resume").getString("title"),
                    response.getJSONObject("resume").getString("first_name"),
                    response.getJSONObject("resume").getString("last_name"),
                    response.getJSONObject("resume").getInt("age"),
                    response.getJSONObject("resume").getInt("salary"),
                    response.getJSONObject("resume").getString("phone_number"),
                    response.getJSONObject("resume").getString("description")
        );
    }
}
