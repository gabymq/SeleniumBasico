package org.titanium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String[] args){
        //Instanciar un objeto WebDriver = Interfaz
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        //System.getProperty("user.dir") = C:\Users\gilsa\IdeaProjects\SeleniumBasico
        //C:\Users\gilsa\IdeaProjects\SeleniumBasico\drivers\chromedriver.exe
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

        //Abrir el navegador
        driver = new ChromeDriver();

        //Navegar a la página
        driver.get(baseURL);

        //Obtener el título de la página
        actualResult = driver.getTitle(); //Welcome: Mercury Tours

        /*if(actualResult.equals(expectedResult)){
            System.out.println("Prueba Superada!");
        }else{
            System.err.println("Prueba Fallada");
        }*/

        //Imprimir el resultado en operador ternario
        System.out.println(actualResult.equals(expectedResult)?"Prueba Superada! " + actualResult:"Prueba Fallada");

        driver.close();
    }
}
