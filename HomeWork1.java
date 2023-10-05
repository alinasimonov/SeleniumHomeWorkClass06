package class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWork1 {
    //goto  http://35.175.58.98/handle-iframe.php //click the checkbox //then select the  babycat //then enter topic name
    //all of this must be done in the same order
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://35.175.58.98/handle-iframe.php");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        driver.switchTo().defaultContent();
        WebElement frame=driver.findElement(By.xpath("//iframe[@name='dropdown-iframe']"));
        driver.switchTo().frame(frame);
        WebElement animals=driver.findElement(By.xpath("//select[@id='animals']"));
        Select sel=new Select(animals);
        sel.selectByVisibleText("Baby Cat");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        WebElement topic=driver.findElement(By.xpath("//input[@name='Topic']"));
        topic.sendKeys("HomeWork Done");

    }
}

