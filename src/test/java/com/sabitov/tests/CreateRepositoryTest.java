package com.sabitov.tests;

import com.sabitov.base.TestBase;
import com.sabitov.data.GroupData;
import org.junit.Assert;
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
public class CreateRepositoryTest extends TestBase {

    private String names;

    public CreateRepositoryTest(String names) {
        this.names = names;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parse() {
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
                names.add(s);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        Object[][] data = new Object[][]{names.toArray()};
        return Arrays.asList(data);
    }

    @Test
    public void createRepositoryTestCase() throws Exception {
            applicationManager.getNavigationHelper().getHomePage();
            applicationManager.getGroupHelper().createRepository(names);
            GroupData groupData = applicationManager.getGroupHelper().GetCreatedGroupData(names);
            if (!groupData.getName().equals(names)) {
                Assert.fail();
            }
            System.out.println("Passed");

    }
}
