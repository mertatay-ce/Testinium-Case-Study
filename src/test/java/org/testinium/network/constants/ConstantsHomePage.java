package org.testinium.network.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ConstantsHomePage {
    public static final By SEARCH_AREA = By.id("search");
    public static final By MORE_SEE_BUTTON = By.xpath("//*[@id=\"pagedListContainer\"]/div[2]/div[2]/button");
    public static final By DISCOUNT_AREA = By.cssSelector("#product-133565 > div > div.product__content > div > div.product__discountPercent.-dualSmall.-end");
    public static final By FIRST_ITEM = By.id("product-133565");
    public static final By FIRST_ITEM_SIZE_LIST = By.cssSelector("#mainContent > div > div.container > div.row > div.col-12.col-lg-4 > div > div.product__sizes > div.product__content.-sizes > div > input");
    public static final By ADD_TO_BASKET_BUTTON = By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div/div[7]/button[2]");
    public static final By GO_TO_BASKET_BUTTON = By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[3]/a");

    public static final String SCRIPT = "window.scrollTo(0,document.body.scrollHeight-1300)";
    public static final String SCRIPT_2 = "window.scrollTo(document.body.scrollHeight-1300,0)\n" +
            "window.scrollTo(document.body.scrollHeight-1300,0)";
    public static final String URL = "https://www.network.com.tr";
    public static final String PAGE2_CEKET_URL = "https://www.network.com.tr/search?searchKey=ceket&page=2";

}
