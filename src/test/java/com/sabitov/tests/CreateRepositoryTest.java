package com.sabitov.tests;

import com.sabitov.base.TestBase;
import org.junit.Test;

public class CreateRepositoryTest extends TestBase {

    @Test
    public void createRepositoryTestCase() throws Exception {
        applicationManager.getNavigationHelper().getHomePage();
        applicationManager.getLogInHelper().signIn();
        applicationManager.getGroupHelper().createRepository();
    }
}
