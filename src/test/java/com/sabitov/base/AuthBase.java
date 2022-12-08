package com.sabitov.base;

import com.sabitov.ApplicationManager;
import org.junit.Before;

public class AuthBase extends TestBase{

    @Before
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getLogInHelper().signInWithValidData();
    }
}
