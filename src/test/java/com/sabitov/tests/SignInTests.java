package com.sabitov.tests;


import com.sabitov.base.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class SignInTests extends TestBase {

    @Test
    public void SignInWithValidData(){
        if(applicationManager.getLogInHelper().isSignedIn()){
            applicationManager.getLogInHelper().logout();
        }
        applicationManager.getNavigationHelper().getHomePage();
        applicationManager.getLogInHelper().signInWithValidData();
        if(!applicationManager.getLogInHelper().isSignedIn()){
            Assert.fail();
        }
    }

    @Test
    public void SignInWithInvalidData(){
        if(applicationManager.getLogInHelper().isSignedIn()){
            applicationManager.getLogInHelper().logout();
        }
        applicationManager.getNavigationHelper().getHomePage();
        applicationManager.getLogInHelper().signInWithInvalidData();
        if(applicationManager.getLogInHelper().isSignedIn()){
            Assert.fail();
        }
    }
}
