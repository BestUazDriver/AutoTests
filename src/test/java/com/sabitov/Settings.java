package com.sabitov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Settings {
    public static String path = "src/test/java/com/sabitov/Settings.xml";

    public Settings() {
    }

    public static String getUsername(){
        String username = null;
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null){
                line = line.replaceAll("<", "#");
                line = line.replaceAll(">", "#");
                String[] split = line.split("#");
                if (split[1].equals("username")){
                    username = split[2];
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return username;
    }

    public static String getPassword(){
        String password = null;
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null){
                line = line.replaceAll("<", "#");
                line = line.replaceAll(">", "#");
                String[] split = line.split("#");
                if (split[1].equals("password")){
                    password = split[2];
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return password;
    }
}
