package test.iverson.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void main() throws Exception {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String projectpath = System.getProperty("user.dir") ;
        System.setProperty("webdriver.chrome.driver", projectpath + "\\res\\ChromeDriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try{
            //driver.manage().window().setPosition(new Point(-1000,1));
            driver.manage().window().maximize();
            driver.get("http://www.baidu.com");


            //Assert.assertEquals("百度，你就知道",driver.getTitle());

            driver.findElement(By.id("kw")).sendKeys("test");
            //driver.findElement(By.id("su")).click();
            //Assert.assertEquals("test",driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a")).getText());
            driver.findElement(By.xpath("//*[@id=\"1\"]/h3/b")).click();
        } catch (Exception e) {
            System.out.print (e);
            File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(projectpath + "/screenshot/e" + sdf.format(date) + ".png"));
            System.out.println("capature completed");
            return;
        } finally {
            //driver.quit();
        }

    }
}
