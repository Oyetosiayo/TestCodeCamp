import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebdriverTest {

    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver=new ChromeDriver();

        //2. Input your konga Demo page URL (https://konga.com)
        driver.get("https://konga.com");
        Thread.sleep(5000);
        //Test1. Verify the user input the right URL and is on the webpage
        if(driver.getCurrentUrl().contains("https://konga.com"))
            //Pass
            System.out.println("Correct Web page");
        else
            //fail
            System.out.println("Wrong Web page");
        Thread.sleep(10000);
        //3.Maximize the driver
        driver.manage().window().maximize();
        //4.Click on sign up button to open the signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

        Thread.sleep(5000);
    }

    //Signup
    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException {
        //click on sign-up page
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[3]/div/a")).click();
        //.Test 6. verify that user cannot sign-up with all of the field blank
        //5. Input your firstname on your username field
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Oyewale");
        Thread.sleep(5000);
        //5. Input your lasttname on your username field
        driver.findElement(By.id("lastname")).sendKeys("Carlos");
        Thread.sleep(10000);
        //6. Input your email address on your email field
        driver.findElement(By.id("email")).sendKeys("Oyezago@yahoo.com");
        Thread.sleep(10000);
        //7. Input your password on your phone-number field
        //driver.findElement(By.id("phone")).sendKeys("08123456788");
        //Thread.sleep(10000);
        //8. Input your password on your password field
        driver.findElement(By.id("password")).sendKeys("admin1");
        Thread.sleep(10000);
        //.9.Click on the create an account button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[1]/form/div[6]/button")).click();
        Thread.sleep(5000);
        //10. Input your code on your pin field
        driver.findElement(By.id("pin")).sendKeys("1234");
        Thread.sleep(10000);
        //10. Input your code on your pin field
        driver.findElement(By.id("pin")).sendKeys("1234");
        Thread.sleep(10000);
        //11. click on the submit code link
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div/div/form/div[2]/button")).click();
        Thread.sleep(10000);
    }




    @Test (priority = 1)
    public void negativeLogin() throws InterruptedException {
        //.Test 6. verify that user cannot login with all of the field blank
        //5. Input your username on your username field
        driver.findElement(By.id("username")).sendKeys("08164020824");
        Thread.sleep(10000);
        //6. Input your email address on your email field
        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(10000);
        //7. Input your password on your password field
        driver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(10000);
        //.8.Click on the sign-up button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }



    @Test (priority = 1)
    public void negativeLogin1() throws InterruptedException {
        //.Test 4. verify that user cannot login with invalid email address
        //4.Click on log in button to open the log in page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Input your email on your email field
        driver.findElement(By.id("username")).sendKeys("oy");
        //6. Input your email address on your email field
        driver.findElement(By.id("username")).sendKeys("ye@anlubi.com");
        //7. Input your password on your password field
        driver.findElement(By.id("password")).sendKeys("admin3");
        //.8.Click on the Log-in button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void negativeLogin2() throws InterruptedException {
        //.Test 5. verify that user cannot login with password less than or equal to one character
        //4.Click on log in button to open the log in page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //5. Input your email on your email field
        driver.findElement(By.id("username")).sendKeys("oy");
        //6. Input your email address on your email field
        driver.findElement(By.id("username")).sendKeys("ye@anlubi.com");
        //7. Input your password on your password field
        driver.findElement(By.id("password")).sendKeys("a");
        //.8.Click on the Log-in button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void positiveSignup() throws InterruptedException {
        //.Test 7. verify user is successfully sign up when valid details are inputted
        //5. Input your username on your username field
        driver.findElement(By.id("username")).sendKeys("Oyezago@yahoo.com\"");
        //6. Input your email address on your email field
        driver.findElement(By.id("username")).sendKeys("09076567892");
        //7. Input your password on your password field
        driver.findElement(By.id("password")).sendKeys("admin1");
        //.8.Click on the sign-up button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test
    public void logoutSuccesfully(){
        //. Click on Logout
        //.Test 10. Verify that when the user logout, he/she is directed back to the home page
          driver.findElement(By.xpath("//*[@id=\\\\\\\"bs-example-navbar-collapse-1\\\\\\\"]/ul/li[3]/a\\")).click();
                String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            System.out.println("Correct User1Page");
        else
            System.out.println("Wrong User1Page");

    }

    @AfterTest
    public void closeBrowser() {
        //.Quit the browser
        driver.quit();

    }
}
