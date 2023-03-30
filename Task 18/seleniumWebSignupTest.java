
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class seleniumWebSignupTest {

    // import the selenium WebDriver
    private WebDriver driver;

    @Test
    public void start() {
        //locate where the chromedriver is
      System.setProperty("webdriver.chrome.driver", "resources/chromedriver");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        //1. open your chrome driver
        driver = new ChromeDriver(options);
        //2. input your selenium Demo Page Url (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");

        //Test 1 Verify the user input the right url and is on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
        //pass
        System.out.println("url leads to the right page");
        else
        //fail
        System.out.println("url does not lead to the right page");
    }



    @Test (priority = 1)
    public void signupbutton() throws InterruptedException {
        Thread.sleep(5000);
        //3. Maximize the browser
       driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test 2 verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("sign up buttons leads to signup page");
        else
            //fail
            System.out.println("sign up button does not lead to sign up page");
    }

    @Test (priority = 2)
     public void positivesignup() throws InterruptedException {
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("egehe567");
        //6. Locate the email address field and input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("eghegjhe@mailinator.com");
        //7. locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("admin1");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();

        //Test 3 verify that the user can signup successfully when they input valid details
        String expectedUrl = "https://selenium-blog.herokuapp.com/users.240";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("user successfully sign up");
        else
            //fail
            System.out.println("user unable to sign up successfully");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
     public void meaghan() throws InterruptedException {
        //9. Click on meaghan item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]")).click();
        Thread.sleep(5000);


        //Test 4 verify that meaghan item is present
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("meaghan item is present");
        else
            //fail
            System.out.println("meaghan item is not present");

    }


    @Test (priority = 4)
    public void item() throws InterruptedException {
        //10. Search for an item (using Python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(2000);

        //Test 5 verify that the item search for is present
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("item is present");
        else
            //fail
            System.out.println("item is not present");

    }


    @Test (priority = 5)
    public  void logout() throws InterruptedException {
        //11. Click on logout
        driver.findElement(By.xpath("//html/body/nav/div/div[2]/ul/li[3]/a")).click();

        //Test 6 verify that user is directed back to the home page when they log out
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("user is directed back to the home page");
        else
            //fail
            System.out.println("user is not direct back to home page");
        Thread.sleep(2000);


    }

    @Test (priority = 6)
    public void incompleteusername() throws InterruptedException {
        //12 Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        //13 Input your 2 character username on the username field
        driver.findElement(By.id("user_username")).sendKeys("eb");
        //14 Input an invalid email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //15 locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("1");
        //16 Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);

        //Test 7 verify the user cannot sign up with 2 character username
        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("user cannot sign up with 2 character username");
        else
            //fail
            System.out.println("user can sign up with 2 character username");


        //Test 8 verify that user cannot sign up with invalid email
        String ExpectedUrl = "https://selenium-blog.herokuapp.com/users";
        String ActualUrl = driver.getCurrentUrl();
        if (ActualUrl.contains(ExpectedUrl))
            //pass
            System.out.println("user cannot sign up with invalid email");
        else
            //fail
            System.out.println("user can sign up with invalid email");

        //Test 9 verify that user cannot sign up with an empty field
        String expectedURl = "https://selenium-blog.herokuapp.com/users";
        String actualURl = driver.getCurrentUrl();
        if (actualURl.contains(expectedURl))
            //pass
            System.out.println("user cannot sign up with empty field");
        else
            //fail
            System.out.println("user can sign up with empty field");

    }
    @Test (priority = 7)
    public void negativelogin() throws InterruptedException {
        //17 go back to home page
        driver.findElement(By.xpath("//*[@id=\"logo\"]")).click();
        Thread.sleep(2000);
        //18 click on login button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
        Thread.sleep(2000);
        //19 input valid email
        driver.findElement(By.xpath("//*[@id=\"session_email\"]")).sendKeys("anastasia@gmail.com");
        //20 input only 1 character in password field
        driver.findElement(By.xpath("//*[@id=\"session_password\"]")).sendKeys("1");
        //21 click the login button
        driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/input")).click();
        Thread.sleep(2000);


        //Test 10 verify the user cannot login with 1 character password
        String expectedId = "flash_danger";
        String actualId = String.valueOf(driver.findElement(By.id("flash_danger")));
        if (actualId.contains(expectedId))
            //pass
            System.out.println("user cannot login with 1 character password");
        else
            //fail
            System.out.println("user can login with 1 character password");

    }

    @AfterTest
        public void closeBrowser() {
        //Quit the browser
            //driver.quit();

    }


}


