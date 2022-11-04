package org.testinium.network.base;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.xml.datatype.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver = null;
    WebDriverWait wait = null;
    JavascriptExecutor javascriptExecutor = null;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver,60);
        this.javascriptExecutor = (JavascriptExecutor) webDriver;
    }

    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
    }

    public void sendKeys(By by, Keys button){
        findElement(by).sendKeys(button);
    }


    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }



    public void hoverElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void hoverElementandClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).click().build().perform();
    }

    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor;
    }

    public void executeScript(JavascriptExecutor executor,String script){
        executor.executeScript(script);
    }

    public void executeScript(JavascriptExecutor executor,String script,WebElement element){
        executor.executeScript(script, element);
    }
    

}
