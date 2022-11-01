package com.sabitov.tests;

import com.sabitov.base.TestBase;
import org.junit.Test;

public class SignInTest extends TestBase {

    @Test
    public void signInTestCase() throws Exception {
        applicationManager.getNavigationHelper().getHomePage();
        applicationManager.getLogInHelper().signIn();
    }
}