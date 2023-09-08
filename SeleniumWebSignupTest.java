import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




    public class SeleniumWebSignupTest {
        private WebDriver driver;


        @BeforeTest
        public void setup() throws InterruptedException {
            //locate where the chromedriver is
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            //1. Open your chrome browse
            driver = new ChromeDriver();
            //2. Input your Selenium Demo Page URL
            driver.get("https://selenium-blog.herokuapp.com");
            //Test1. Verify that user inputs the correct url and is on the right webpage
            if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
                //pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong webpage");
            Thread.sleep(5000);
            //3. Maximize the browser driver
            driver.manage().window().maximize();
            //4. Click on Signup button to open the Signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
        }








        @Test (priority = 0)
        public void positiveSignup() throws InterruptedException {


            //Test7. Verify that user is signed up when he/she inputs the right details
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Musa80");
            //6. Locate the email address field and Input an email address on the email field
            driver.findElement(By.id("user_email")).sendKeys("bio80@gmail.com");
            //7. Locate the password field and Input your password on the username field
            driver.findElement(By.id("user_password")).sendKeys("password");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }


        @Test (priority = 1)
        public void clickUserItem() throws InterruptedException {
            //9. Click on User item on the listpage
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            //Test2. Verify that when user clicks on the signup button, the user is directed to the signup page
            String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
            String actualUrl = driver.getCurrentUrl();
            if(actualUrl.contains(expectedUrl))
                //pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong webpage");
            Thread.sleep(5000);
        }


        @Test (priority = 2)
        public void verifyItem() throws InterruptedException {
//Test9. Search, for an item (Using Python with Selenium) and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
            String actualPageUrl = driver.getCurrentUrl();
            if (actualPageUrl.contains(expectedPageUrl))
                //pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong webpage");
            Thread.sleep(5000);
        }


        @Test (priority = 3)
        public void logoutSucessfully(){


            //11. Click on Logout
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            //Test10. Verify that when a user logout, he or she is directed to the home page
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if(expectedTitle.contains(actualTitle))
                //pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong webpage");
        }


        @Test (priority = 4)
        public void negativeSignup() throws InterruptedException {
            //Click on Signup button to open the Signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
            //Test3. Verify that user can not sign up with username less tha three characters
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Ma");
            //6. Locate the email address field and Input an email address on the email field
            driver.findElement(By.id("user_email")).sendKeys("bio996686@gmail.com");
            //7. Locate the password field and Input your password on the username field
            driver.findElement(By.id("user_password")).sendKeys("password");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }


        @Test (priority = 5)
        public void negativeSignupIvalidEmail() throws InterruptedException {
            //Test4. Verify user cannot signup with invalid email address
            //Click on Signup button to open the Signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
            //Test3. Verify that user can not sign up with username less tha three characters
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Ma");
            //6. Locate the email address field and Input an email address on the email field
            driver.findElement(By.id("user_email")).sendKeys("bio996686gmail.com");
            //7. Locate the password field and Input your password on the username field
            driver.findElement(By.id("user_password")).sendKeys("password");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }


        @Test (priority = 6)
        public void negativeSignupPasswordLessThanOneCharacter() throws InterruptedException {
            //Test5. Verify user cannot login with password less than or equal to one character
            //Click on Signup button to open the Signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
            //Test3. Verify that user can not sign up with username less tha three characters
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Ma");
            //6. Locate the email address field and Input an email address on the email field
            driver.findElement(By.id("user_email")).sendKeys("bio996686gmail.com");
            //7. Locate the password field and Input your password on the username field
            driver.findElement(By.id("user_password")).sendKeys("p");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }


        @Test (priority = 7)
        public void negativeSignupEitherFieldBlank() throws InterruptedException {
            //Test6.  Verify user cannot signup with either/all of the fields blank
            //Click on Signup button to open the Signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
            //Test3. Verify that user can not sign up with username less tha three characters
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Ma");
            //6. Locate the email address field and Input an email address on the email field
            driver.findElement(By.id("user_email")).sendKeys(" ");
            //7. Locate the password field and Input your password on the username field
            driver.findElement(By.id("user_password")).sendKeys("password");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }


        @Test (priority = 8)
        public void negativeSignupEitherFieldBlank() throws InterruptedException {
            //Test3.   Verify that user cannot signup with username less than 3 characters
            //Click on Signup button to open the Signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
            //Test3. Verify that user can not sign up with username less tha three characters
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Ma");
            //6. Locate the email address field and Input an email address on the email field
            driver.findElement(By.id("user_email")).sendKeys(" ");
            //7. Locate the password field and Input your password on the username field
            driver.findElement(By.id("user_password")).sendKeys("password");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }


        @AfterTest
        public void closeBrowser(){
            //Quit the browser
            driver.quit();


}

