package com.sabitov.tests;

import com.sabitov.base.AuthBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(value = Parameterized.class)
public class DeleteRepositoryTest extends AuthBase {

    private String name;

    public DeleteRepositoryTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parseName(){
        List<String> names = new ArrayList<>();

        try {
            String s;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\test\\java\\com\\sabitov\\test_data.xml"));
            while ((s = bufferedReader.readLine()) != null) {
                s = s.replace("<xml>", "");
                s = s.replace("</xml>", "");
                s = s.replace("<repository>", "");
                s = s.replace("</repository>", "");
                s = s.replace("<name>", "");
                s = s.replace("</name>", "");
                System.out.println(s);
                names.add(s);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        Object[][] data = new Object[][]{names.toArray()};
        return Arrays.asList(data);
    }

    @Test
    public void deleteRepositoryTestCase() throws Exception {
        applicationManager.getGroupHelper().deleteRepository(name);
    }
}
