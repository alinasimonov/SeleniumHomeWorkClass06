package class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://accounts.google.com/InteractiveLogin/signinchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=AYZoVhccm1J--6Om8klpXs2kpPtHNeCdcV2LHp5Ex-ooXYujLB3DaAuG0zGIYLU7TmHAEuq1lTmt5w&theme=glif&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        driver.manage().window().maximize();
        //click on help
        WebElement help= driver.findElement(By.xpath("//a[text()='Help']"));
        //click on privacy
        WebElement privacy= driver.findElement(By.xpath("//a[text()='Privacy']"));
        help.click();
        privacy.click();
        //Task1: get the window handle of the main page gmail.com and print it out on console
        //as our webdriver is currently focused on gmail page we can use driver.getwindowhandle() to get the handle of the current page is gmail.com
        String gmailHandle= driver.getWindowHandle();
        System.out.println(gmailHandle);
        //Task2
        //Switch the focus of your webdriver to the privacy window

        //get all the handles and find the desired one
        Set<String> allHandles=driver.getWindowHandles();
        //loop through all the handles and find the one that is desired
        for(String handle:allHandles){
            driver.switchTo().window(handle);
            //get the title of the window on which the focus is
            String title=driver.getTitle();
            //check if the title matches us desired title,if yes break the loop, if no repeat the process
            if(title.equalsIgnoreCase("Privacy Policy – Privacy & Terms – Google")){
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }
}
