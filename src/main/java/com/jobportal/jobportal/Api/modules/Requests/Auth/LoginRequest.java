/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules.Requests.Auth;

/**
 *
 * @author kotorkovsciy
 */
public class LoginRequest {
    public String username;
    public String password;

    public LoginRequest(String username, String password){
        this.username = username;
        this.password = password;
    }
}
