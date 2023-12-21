/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api;

/**
 *
 * @author kotorkovsciy
 */
public class Urls {
    private static final String URL = "https://jobportal.alwaysdata.net/api";
    
    private static final String URLAUTH = URL + "/auth";
    public static String loginUrl = URLAUTH + "/token/login/";
    public static String logoutUrl = URLAUTH + "/token/logout/";
    
    public static String amount_responsesUrl = URL + "/get_amount_responses/";
    public static String responseUrl = URL + "/get_response/";
    public static String responsesUrl = URL + "/get_responses/";
}
