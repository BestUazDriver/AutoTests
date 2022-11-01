package com.sabitov.tests;

import com.sabitov.base.TestBase;
import org.junit.Test;

public class DeleteRepositoryTest extends TestBase {

    @Test
    public void deleteRepositoryTestCase() throws Exception {
        applicationManager.getNavigationHelper().getHomePage();
        applicationManager.getLogInHelper().signIn();
        applicationManager.getGroupHelper().deleteRepository();
    }
}
