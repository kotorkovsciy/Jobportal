/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules.Responses.Vacancy;

/**
 *
 * @author kotorkovsciy
 */
public class VacancyResponseResponse {
    public Integer id;
    public String title;
    public String firstName;
    public String lastName;
    public Integer age;
    public Integer salary;
    public String phoneNumber;
    public String description;
    
    public VacancyResponseResponse(
            Integer id, 
            String title, 
            String firstName,
            String lastName,
            Integer age,
            Integer salary,
            String phoneNumber,
            String description
    ){
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }
}
