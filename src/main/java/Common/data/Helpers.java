package Common.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class Helpers {

    public void drawBorder(AutomationDriver driver, String xpath){
        WebElement element_node = driver.findElement(By.xpath(xpath));
        driver.executeJavaScript("arguments[0].style.border='1px solid red'", element_node);
    }


    public void drawBorder(AutomationDriver driver, WebElement element_node){
        driver.executeJavaScript("arguments[0].style.border='1px solid red'", element_node);
    }


    public void drawBorder(AutomationDriver driver, String xpath, String color, int width) {
        WebElement element_node = driver.findElement(By.xpath(xpath));
        driver.executeJavaScript("arguments[0].style.border='"+ width + "px solid " + color + "'", element_node);
    }

    public void drawBorder(AutomationDriver driver, WebElement element_node, String color, int width) {
        driver.executeJavaScript("arguments[0].style.border='"+ width + "px solid " + color + "'", element_node);
    }
}
