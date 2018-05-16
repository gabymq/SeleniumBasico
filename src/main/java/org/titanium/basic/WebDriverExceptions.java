package org.titanium.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExceptions {
    static WebDriver driver;

    public static void main(String[] args){
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://live.guru99.com/index.php/checkout/cart";
        String expectedResult = "$615.00";
        String actualResult = "";

        try{
            driver = new ChromeDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();

            //Click en el link TV
            WebElement lnkTV = driver.findElement(By.linkText("TV"));
            lnkTV.click();

            //Clic en boton ADD TO CART
            WebElement btnAddToCart = driver.findElement(By.xpath("(//*[text()='Add to Ca'])[1]"));
            btnAddToCart.click();

        }catch(NoSuchElementException ne){
            System.err.println("No se encontró el WebElement: " + ne.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDrvier falló: " + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.close();
        }
    }
}
