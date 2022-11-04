package org.testinium.network.base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    static WebDriver driver = null;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","Driver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(chromeOptions));
        getWebDriver().navigate().to("https://www.network.com.tr");
    }
    public static WebDriver getWebDriver(){
        return driver;
    }
    public static void setWebDriver(WebDriver driver){
         BaseTest.driver = driver;
    }

    public void shutDown(){
        getWebDriver().quit();
    }
}
