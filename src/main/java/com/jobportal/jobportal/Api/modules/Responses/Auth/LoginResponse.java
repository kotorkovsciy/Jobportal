/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules.Responses.Auth;

/**
 *
 * @author kotorkovsciy
 */
public class LoginResponse {
    public String authToken;

    public LoginResponse(String authToken){
        this.authToken = authToken;
    }
}
