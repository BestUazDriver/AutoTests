package com.sabitov;

import com.sabitov.data.CreateRepositoryData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CreateRepositoryData createRepositoryData = new CreateRepositoryData();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\test\\java\\com\\sabitov\\test_data.xml"));
            String s = bufferedReader.readLine();
            s=s.replace("<xml>", "");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
