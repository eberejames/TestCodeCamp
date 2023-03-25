import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class KongaOrderingFlow {

/***
 * 1. Visit the URL https://www.konga.com/
 // Verify that the url leads to the right page
 * 2. Sign in to https://www.konga.com/ successfully
 //Verify that the user successfully signin with valid email address and password
 * 3. From the Categories, click on the "Computers and Accessories"
 //verify that the computers and accessories takes you to the right page
 * 4. Click on the Laptop SubCategory
 * 5. Click on the Apple MacBooks
 * 6. Add an item to the cart
 // verify that user is able to add an item to cart
 * 7. Select Address
 * 8. Continue to make payment
 * 9. Select a Card Payment Method
 // verify that the card payment method selected by user leads to the right page
 * 10. Input invalid card details
 //verify that user is unable to make payment with invalid card details
 * 11. Print Out the error message: Invalid card number
 * 12. Close the iFrame that displays the input card Modal
 * 13. Quit the browser.
 *
 */

//import web driver
    private WebDriver driver;

    @BeforeTest
    private void setup() {

        //locate chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

    }


    @Test (priority = 0)
    private void visiturl() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //1. Open chrome browser
        driver = new ChromeDriver(options);

        //2. Visit the URL https://www.konga.com/
        driver.get("https://www.konga.com/");

        //Test Case 1 - Verify that the url leads to the right page
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
        //Pass
            System.out.println("url leads to the right page");
        else
            //Fail
            System.out.println("url does not lead to the right page");

        // 3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test (priority = 1)
    private void signin() throws InterruptedException {
        //4. Click on the signin button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

        //5.Input email on the email address field
        driver.findElement(By.id("username")).sendKeys("damilolanzediegwu@gmail.com");

        //6. Input password on the password field
        driver.findElement(By.id("password")).sendKeys("Mom&dad1992");

        //7. Click on the signin button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

        //Test case 2 - Verify that the user successfully signin with valid email address and password
        String expectedXpath = "//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/h5";
        String actualXpath = String.valueOf(driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/h5")));
        if (actualXpath.contains(expectedXpath))
            //Pass
            System.out.println("user is able to sign in");
        else
            //Fail
            System.out.println("user is unable to sign in");

    }

    @Test (priority = 2)
    private void computerandaccessories() throws InterruptedException {
        //8. click on Computer and Accessories
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test case 3 - verify that the computers and accessories takes you to the right page
        if (driver.getCurrentUrl().contains("https://www.konga.com/category/accessories-computing-5227"))
            //pass
            System.out.println("computer and accessories able to access the right page");
        //fail
        System.out.println("computer and accessories unable to access the right page");

        //9. Click on the Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);

        //10. Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 3)
    private void addtocart() throws InterruptedException {
        //11. Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);

        //Test case 4 - verify that user is able to add an item to cart
        String expectedinfo = "//*[@id=\"app-content-wrapper\"]/div[1]";
        String actualinfo = String.valueOf(driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[1]")));
        if (actualinfo.contains(expectedinfo))
            //Pass
            System.out.println("able to add to cart");
        else
            //Fail
            System.out.println("unable to add to cart");

        //12. Click on cart icon
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(5000);

        //13. Click on checkout button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);

        //14. Select address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 4)
    private void cardpaymentmethod() throws InterruptedException {
        //15. Click on the card payment method button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);

        //16. Click on 'Pay Now' button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);

        //17. Click on continue to make payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);

        //18. Set the iFrame ID value to be = iFrame
        String iFrame = "kpg-frame-component";

        //19. Set the card payment button xpath to be = cardPaymentButton
        String cardPaymentBtn = "//*[@id=\"channel-template\"]/div[2]/div/div[2]/button";

        //20. Assign driver sleep to the string 'timeout'
        Duration timeout = Duration.ofSeconds(50);

        //21. Driver wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        //22. locate iframe
        WebElement modalIFrame = driver.findElement(By.id(iFrame));

        // 23.switch the driver to iframe that appears
        driver.switchTo().frame(modalIFrame);

        // 24. On the modal,click the card button
        WebElement CardOption  = driver.findElement(By.xpath(cardPaymentBtn));CardOption.click();
        Thread.sleep(5000);

        //Test case 5 - Verify that clicking on the 'Card" button takes user to the 'input card details' modal
        String expectedScreen = "/html/body/section/section/section/div[2]/div[3]/div/div/span[2]";
        String actualScreen = String.valueOf(driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/div/span[2]")));
        if (actualScreen.contains(expectedScreen))
            //Pass
            System.out.println("user is able to access thr input card details modal");
        else
            //Fail
            System.out.println("user is unable to access thr input card details modal");

    }


    @Test (priority = 5)
    private  void CardDetails() throws InterruptedException {

        //25. Type incorrect card number
        driver.findElement(By.id("card-number")).sendKeys("123456789");

        //26. Fill in the date field
        driver.findElement(By.id("expiry")).sendKeys("0423");

        //27. Fill in the cvv field
        driver.findElement(By.id("cvv")).sendKeys("123");

        Thread.sleep(5000);

        //28. Click on pay now button
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(3000);

        // 29. Print the error code that pops up
        String errorCode = driver.findElement(By.id("card-number_unhappy")).getText();
        System.out.println(errorCode);

    }

    @Test(priority = 7)
    private void closemodal() throws InterruptedException {
        // 30. Close i-Frame modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();

       //Test case 6 - confirm that user is directed back to the order page when the card detail iframe is closed
        if (driver.getCurrentUrl().contains("https://www.konga.com/checkout/complete-order"))
            //Pass
            System.out.println("user is successfully directed back to the order page");
        else
            //Fail
            System.out.println("user not directed back to the order page");

        Thread.sleep(7000);

    }

    @AfterTest
    private void quitbrowser() {
        //quit chrome browser
        driver.quit();
    }


}


