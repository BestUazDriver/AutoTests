package com.sabitov.tests;

import com.sabitov.base.TestBase;
import com.sabitov.data.CreateRepositoryData;
import com.sabitov.data.GroupData;
import org.junit.Assert;
import org.junit.Test;

public class CreateRepositoryTest extends TestBase {

    @Test
    public void createRepositoryTestCase() throws Exception {
        applicationManager.getNavigationHelper().getHomePage();
//        applicationManager.getLogInHelper().signIn();
        applicationManager.getGroupHelper().createRepository();
        System.out.println("LOL");
        GroupData groupData = applicationManager.getGroupHelper().GetCreatedGroupData();
        if (!groupData.getName().equals(CreateRepositoryData.name)){
            Assert.fail();
        }
        if (!groupData.getDescription().equals(CreateRepositoryData.description)){
            Assert.fail();
        }
        System.out.println("Passed");
    }
}
