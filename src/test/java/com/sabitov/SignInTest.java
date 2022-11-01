package com.sabitov;

import com.sabitov.base.TestBase;
import org.junit.Test;

public class SignInTest extends TestBase {



    @Test
    public void signInTestCase() throws Exception {
        getHomePage();
        //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        signIn();
    }
}