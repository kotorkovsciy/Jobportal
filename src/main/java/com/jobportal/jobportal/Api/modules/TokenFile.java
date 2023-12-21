/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal.Api.modules;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

/**
 *
 * @author kotorkovsciy
 */
public class TokenFile {

    private static final String FILE_NAME = "token.txt";

    private File file;

    public TokenFile() {
        this.file = new File(FILE_NAME);
    }

    public void writeToken(String token) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(token);
        fileWriter.close();
    }

    public String readToken() throws IOException {
        if (!file.exists()) {
            return null;
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String token = bufferedReader.readLine();
        bufferedReader.close();

        return token;
    }
}
