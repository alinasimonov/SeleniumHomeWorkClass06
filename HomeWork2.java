package class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HomeWork2 {
    //goto gmail.com click on help click on privacy
    //click on terms //switch the focus on terms page and get the title and print on screeen
    //then switch the focus back to the gmail page and print the title of the main page on screen
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://accounts.google.com/InteractiveLogin/signinchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=AYZoVhccm1J--6Om8klpXs2kpPtHNeCdcV2LHp5Ex-ooXYujLB3DaAuG0zGIYLU7TmHAEuq1lTmt5w&theme=glif&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        driver.manage().window().maximize();
        WebElement help= driver.findElement(By.xpath("//a[text()='Help']"));
        WebElement privacy= driver.findElement(By.xpath("//a[text()='Privacy']"));
        WebElement terms= driver.findElement(By.xpath("//a[text()='Terms']"));
        help.click();
        privacy.click();
        terms.click();
        String defaultHandle= driver.getWindowHandle();
        Set<String> allHandles=driver.getWindowHandles();
        for(String handle:allHandles){
            driver.switchTo().window(handle);

        String title=driver.getTitle();
        if(title.equalsIgnoreCase("Google Terms of Service – Privacy & Terms – Google")){
            break;
        }
    }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.switchTo().window(defaultHandle);
        System.out.println(driver.getTitle());
    }
}
