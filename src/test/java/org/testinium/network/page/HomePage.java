package org.testinium.network.page;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testinium.network.base.BasePage;
import org.testinium.network.utilities.Log4j2Manager;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import static org.testinium.network.constants.ConstantsHomePage.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage checkHomeUrl(){
        Log4j2Manager.info("Network URL'i kontrol ediliyor.");
        Assert.assertEquals(URL,"https://www.network.com.tr");
        Log4j2Manager.info("Network URL'i gelmektedir.");
        return this;
    }
    public HomePage writeSearchText(){
        Log4j2Manager.info("Arama kutusuna ceket yazdırıldı.");
        sendKeys(SEARCH_AREA,"ceket");
        return this;
    }

    public HomePage clickSearch(){
        Log4j2Manager.info("Ceket Aratılıyor.");
        sendKeys(SEARCH_AREA, Keys.ENTER);
        return this;
    }


    public HomePage scrollToPage2Button(){
        Log4j2Manager.info("Daha Fazla Ürün Göster Butonuna Gidiliyor.");
        executeScript(getJavascriptExecutor(),SCRIPT);
        return this;
    }


    public HomePage clickButton(){
        Log4j2Manager.info("Daha Fazla Ürün Göster Butonuna Tıklanıyor...");
        click(MORE_SEE_BUTTON);
        return this;
    }

    public HomePage checkSearchPageUrl(){
        Log4j2Manager.info("2.sayfa URL'i kontrol ediliyor...");
        Assert.assertEquals(PAGE2_CEKET_URL,"https://www.network.com.tr/search?searchKey=ceket&page=2");
        Log4j2Manager.info("2.sayfa URLine geçilmektedir.");
        return this;
    }

    public HomePage scrollToUpPage2(){
        Log4j2Manager.info("2.sayfada yukarı kaydırma işlemi gerçekleştiriliyor");
        executeScript(getJavascriptExecutor(),SCRIPT_2);
        return this;
    }

    public HomePage checkHaveDiscountAndHover(){
        Log4j2Manager.info("İndirimi olan ürünler bulunuyor");
        WebElement discount = findElement(DISCOUNT_AREA);
        Log4j2Manager.info("İndirimi olan ürünler listeye ekleniyor.");
        ArrayList<WebElement> products_with_size = new ArrayList<>();
        if (discount.isEnabled()){
            Log4j2Manager.info("İlk indirimli ürün seçiliyor.");
            hoverElement(FIRST_ITEM);
            Log4j2Manager.info("İlk indirimli ürün tıklanıyor.");
            click(FIRST_ITEM);
            Log4j2Manager.info("Ürünün beden değerleri kontrol ediliyor.");
            List<WebElement> size_list = findElements(FIRST_ITEM_SIZE_LIST);
            int count =0;
            for(WebElement size: size_list){
                System.out.println(size.getAttribute("disabled"));
                if (size.getAttribute("disabled") == null){
                    Log4j2Manager.info("Ürünün beden değerleri ekleniyor.(" + count +"/"+ size_list.size() +")");
                    products_with_size.add(size);
                }
                count++;
            }
            Log4j2Manager.info("Toplamda"+ products_with_size.size()+"tane ürünün bedeni bulunmakta.");
            Log4j2Manager.info("Rastgele bir beden seçiliyor.");
            WebElement random_choosed_size = products_with_size.get(new Random().nextInt(products_with_size.size()));
            //System.out.println(random_choosed_size.getAttribute("id").substring(5));
            System.out.println(random_choosed_size.toString().substring(83,220));;
            executeScript(getJavascriptExecutor(),"arguments[0].click();", random_choosed_size);
            if (random_choosed_size.isDisplayed()){
                Log4j2Manager.info(random_choosed_size.getAttribute("id").substring(5) + "beden seçildi.");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement btnAdd = findElement(ADD_TO_BASKET_BUTTON);
            executeScript(getJavascriptExecutor(),"arguments[0].click();",btnAdd);
            if (btnAdd.isDisplayed()){
                Log4j2Manager.info("Sepete ekleniyor.");
            }else{
                Log4j2Manager.error("Sepete eklenemedi. Kodunuzu kontrol edin!",new Throwable("Sepete eklenmeme hatası"));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
            WebElement btnGo = findElement(GO_TO_BASKET_BUTTON);
            executeScript(getJavascriptExecutor(),"arguments[0].click();",btnGo);
            if (btnAdd.isDisplayed()){
                System.out.println("selected");
            }else{
                Log4j2Manager.error("Sepete Gitme Başarısız!",new Throwable("Sepete gidememe hatası"));
            }*/



        }else{
            executeScript(getJavascriptExecutor(),"alert("+"Bu cekette indirim yoktur."+")");
        }
        return this;
    }

}
