package org.titanium.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejemplo2 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.manage().window().maximize();
        WebDriverWait waitVar = new WebDriverWait(driver, 10);

        try{
            driver.switchTo().frame("iframeResult");
            WebElement btnTry = driver.findElement(By.xpath("//button[.='Try it']"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
            btnTry.click();
            Thread.sleep(1500);

            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert altWindow = driver.switchTo().alert();
            String alertText = altWindow.getText();
            System.out.println(alertText);
            altWindow.sendKeys("Gilberto S");
            altWindow.accept();

            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Gilberto")?finalText:"Prueba Fallida!");

           /* if(finalText.contains("Gilberto")){
                System.out.println(finalText);
            }else{
                System.out.println("Prueba Fallida!");
            }*/

        }catch (NoSuchElementException ne){
            System.err.println("No se encontró el WebElement: " + ne.getMessage());
        }catch (NoSuchFrameException fe){
            System.err.println("No se encontró el frame: " + fe.getMessage());
        }catch (NoAlertPresentException ae){
            System.err.println("No se encontró la alerta: " + ae.getMessage());
        }catch(TimeoutException te){
            System.err.println("Tiempo de espera exedido: " + te.getMessage());
        }catch (WebDriverException we){
            System.err.println("Webdriver falló: " + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.quit();
        }
    }
}
