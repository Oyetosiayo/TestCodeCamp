import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1.open our chrome driver
        driver = new ChromeDriver();
        //2. Input your selenium Demo page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //Test1. Verify the user input the right URL and is on the webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Correct Web page");
        else
            //fail
            System.out.println("Wrong Web page");
        Thread.sleep(10000);
        //3.Maximize the driver
        driver.manage().window().maximize();
        //4.Click on sign up/log-in button to open the signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void negativeSignup() throws InterruptedException {
        //.Test 3. verify that user cannot sign up with username less than 3 characters
        //5. Input your username on your username field
        driver.findElement(By.id("user_username")).sendKeys("oyetosiayo1212");
        //6. Input your email address on your email field
        driver.findElement(By.id("user_email")).sendKeys("yecospa4654499@anlubi.com");
        //7. Input your password on your password field
        driver.findElement(By.id("user_password")).sendKeys("admin1");
        //.8.Click on the sign-up button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }


    @Test(priority = 2)
    public void clickUser1item() throws InterruptedException {
        //.9.Click on the user1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //. Test 3. verify that when user click on the sign up button, the user is directed to the sign up page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl))
            System.out.println("Correct web page");
        else
            System.out.println("Wrong web page");

        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void verifyItem() throws InterruptedException {

        //.Test 9. Search for an item(Learn xpath) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageTitleUrl = "/users/1";
        String actualPageTitleUrl = driver.getCurrentUrl();
        if (actualPageTitleUrl.contains(expectedPageTitleUrl))
            System.out.println("Correct User1Page");
        else
            System.out.println("Wrong User1Page");

        Thread.sleep(5000);
    }


    @AfterTest
    public void closeBrowser(){
        //.Quit the browser
        driver.quit();
    }
}
