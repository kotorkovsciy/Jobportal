/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules.Responses.Vacancy;

/**
 *
 * @author kotorkovsciy
 */
public class AmountResponsesResponse {
    public Integer id;
    public String title;
    public Integer amountResponses;

    public AmountResponsesResponse(Integer id, String title, Integer amountResponses){
        this.id = id;
        this.title = title;
        this.amountResponses = amountResponses;
    }
}
