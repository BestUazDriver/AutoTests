package com.sabitov;

import com.sabitov.base.TestBase;
import org.junit.Test;

public class CreateRepositoryTest extends TestBase {

    @Test
    public void createRepositoryTestCase() throws Exception {
        getHomePage();
        signIn();
        createRepository();
    }
}
