package org.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "http://live.guru99.com/index.php/checkout/cart";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //Click en el link TV
        driver.findElement(By.linkText("TV")).click();

        //Clic en boton ADD TO CART
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();

        actualResult = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span")).getText();

        if(actualResult.equals(expectedResult)){
            System.out.println("Prueba Exitosa! el resultado actual es " + actualResult + " es igual a " + expectedResult);
        }else {
            System.err.println("Prueba Exitosa! el resultado actual es " + actualResult + " NO es igual a " + expectedResult);
        }

        driver.close();
    }
}
