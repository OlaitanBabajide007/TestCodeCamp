import io.github.bonigarcia.wdm.WebDriverManager;
import org.jaxen.function.IdFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class KongaSignupTest {

        //declaring the variable/driver in the private WebDriver class/instance
        private WebDriver driver;


        @BeforeTest
        public void launchSite() throws InterruptedException {
            //1.Instruct the WebDriverManager to handle the setup of the ChromeDriver
            WebDriverManager.chromedriver().setup();
            //2. Initialize a new instance of the ChromeDriver class
            driver = new ChromeDriver();
            //3. navigate the browser to the specified website/Url
            driver.get("https://www.konga.com");
            //4.verify that specified Url is correct and user is on the right Webpage
            if (driver.getCurrentUrl().contains("https://www.konga.com/"))
                //pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");
            Thread.sleep(4000);
            //5.Maximize the browser Webpage
            driver.manage().window().maximize();
            Thread.sleep(4000);
        }

        @Test(priority = 0)
        public void login() throws InterruptedException {
            //6.click the login/signup button
            driver.findElement(By.xpath("//div[1]/div/div/div[4]/a")).click();
            Thread.sleep(5000);
            //7.input the username
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Olaitan@malinator.com");
            //8.input the password
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Itzdonbarry@12345");
            Thread.sleep(5000);
            //9.click login button
            driver.findElement(By.xpath("//div[3]/button[@type='submit']")).click();
            Thread.sleep(4000);
            System.out.println("Successfully signed in to konga");
        }

        @Test(priority = 1)
        public void clickComputerAndAccessories() throws InterruptedException {
            //10.click computer and accessories
            driver.findElement(By.xpath("//div/a[@href='/category/accessories-computing-5227']")).click();
            Thread.sleep(4000);
            System.out.println("Clicked Computers And Accessories");
        }

        @Test(priority = 2)
        public void clickLaptops() throws InterruptedException {
            //11.click laptops
            driver.findElement(By.xpath("//li/a[@href='/category/accessories-computing-5227?menu=Computers and Accessories > Laptops']")).click();
            Thread.sleep(5000);
            System.out.println("Clicked Laptops");
        }

        @Test(priority = 3)
        public void clickAppleMacBooks() throws InterruptedException {
            //12.click Apple and MacBooks
            driver.findElement(By.xpath("//li/a[@href='/category/accessories-computing-5227?menu=Computers and Accessories > Laptops > Apple MacBooks']")).click();
            Thread.sleep(5000);
            System.out.println("Clicked on AppleMacBooks");
        }

        @Test(priority = 4)
        public void clickAddToCart() throws InterruptedException {
            //13.click add to cart button
            driver.findElement(By.xpath("//li[2]/div/div/div[2]/form[@action='/cart/overview']/div[3]")).click();
            Thread.sleep(5000);
            //14.click the cart button to see the added item
            driver.findElement(By.xpath("//div[@id='nav-bar-fix']/div/div/div/a[@href='/cart/overview']")).click();
            Thread.sleep(5000);
            //15.click the checkout button to proceed to payment page
            driver.findElement(By.xpath("//aside/div[3]/div/div[2]/button")).click();
            Thread.sleep(5000);
            System.out.println("Added a Mac Laptop to the cart");
        }

        @Test(priority = 5)
        public void proceedToPayment() throws InterruptedException {
            //16.proceed to click on the card payment
            driver.findElement(By.xpath("//input[@data-payment-method='kpaygateway']")).click();
            Thread.sleep(5000);
            //17.click the pay now button
            driver.findElement(By.xpath("//button[@name='placeOrder']")).click();
            Thread.sleep(5000);
            System.out.println("Clicked proceed To payment");
        }

        @Test(priority = 6)
        public void insertPaymentDetails() throws InterruptedException {
            //18.switch to the payment modal iframe
            driver.switchTo().frame("kpg-frame-component");
            //19.click on the card option for the payment
            driver.findElement(By.xpath("//button[@class='dashboard-card__button Card']")).click();
            Thread.sleep(5000);
            //20.insert an invalid card number on the card number field
            driver.findElement(By.xpath("//input[@id='card-number']")).sendKeys("3510164542390822");
            Thread.sleep(5000);
            //21.insert an invalid expiry date on the expiry date field
            driver.findElement(By.xpath("//input[@id='expiry']")).sendKeys("07/29");
            Thread.sleep(5000);
            //22.insert an invalid CVV number on the CVV field
            driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("404");
            Thread.sleep(5000);
            System.out.println("Enter invalid card details");
        }

        @Test(priority = 7)
        public void printError() throws InterruptedException {
            //identify the element that displays the error message
            WebElement errorMessage = driver.findElement(By.xpath("//label[@id='card-number_unhappy']"));
            //print the error to console by getting the text attribute
            System.out.println("The Error Message is: "+errorMessage.getText());
            Thread.sleep(5000);
        }

        @Test(priority = 8)
        public void closePaymentDetailsFrame() {
            //closed the payment modal iframe
            driver.switchTo().defaultContent();
            System.out.println("switch out of the iframe");
        }

        @AfterTest
        public void tearDown() {
            //shutdown the browser
            driver.quit();
            System.out.println("Close or shutdown the browser");
        }
}
