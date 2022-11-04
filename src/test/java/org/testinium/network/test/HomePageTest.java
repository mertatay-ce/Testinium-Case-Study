package org.testinium.network.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testinium.network.base.BaseTest;
import org.testinium.network.page.HomePage;
import org.testinium.network.utilities.Log4j2Manager;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    @Before
    public void before(){
        homePage = new HomePage(getWebDriver());
    }

    @Test
    public void test(){
        Log4j2Manager.info("Başlatılıyor.");
        homePage.checkHomeUrl().writeSearchText().clickSearch().scrollToPage2Button().clickButton().checkSearchPageUrl().scrollToUpPage2().checkHaveDiscountAndHover();
    }



    @After
    public void after(){
        //shutDown();
    }
}
