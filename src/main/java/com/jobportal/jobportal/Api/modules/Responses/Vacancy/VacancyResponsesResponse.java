/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules.Responses.Vacancy;

/**
 *
 * @author kotorkovsciy
 */
public class VacancyResponsesResponse {
    public Integer id;
    public String title;
    public String createdAt;
    public VacancyResponsesResponse(Integer id, String title, String createdAt){
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }
}
