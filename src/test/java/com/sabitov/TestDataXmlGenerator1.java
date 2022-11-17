package com.sabitov;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataXmlGenerator1 {
    public static void main(String[] args) {
        File file = new File("src\\test\\java\\com\\sabitov\\test_data.xml");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            int repo = new Random().nextInt(20);
            fileWriter.write("<xml><repository><name>Test" + repo + "</name></repository></xml>");
            fileWriter.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
