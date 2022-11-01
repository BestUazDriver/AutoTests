package com.sabitov;

import com.sabitov.base.TestBase;
import org.junit.Test;

public class DeleteRepositoryTest extends TestBase {

    @Test
    public void deleteRepositoryTestCase() throws Exception {
        getHomePage();
        signIn();
        deleteRepository();
    }
}
