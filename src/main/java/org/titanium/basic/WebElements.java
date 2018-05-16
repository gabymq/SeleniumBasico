package org.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "http://live.guru99.com/index.php/checkout/cart";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //Click en el link TV
        WebElement lnkTV = driver.findElement(By.linkText("TV"));
        lnkTV.click();

        //Clic en boton ADD TO CART
        WebElement btnAddToCart = driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]"));
        btnAddToCart.click();

        WebElement lblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span"));

        if(lblSubtotal.getText().equals(expectedResult)){
            System.out.println("Prueba Exitosa! el resultado actual es " + lblSubtotal.getText() + " es igual a " + expectedResult);
        }else {
            System.err.println("Prueba Exitosa! el resultado actual es " + lblSubtotal.getText() + " NO es igual a " + expectedResult);
        }

        driver.close();
    }
}
