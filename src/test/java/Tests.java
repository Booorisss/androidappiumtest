import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by borisgurtovyy on 6/19/17.
 */
public class Tests extends BaseTest{

    @Test
    public void testHappySignUp() {
        driver.findElementById("button_sign_up").click();
        driver.hideKeyboard();
        driver.findElementById("edittext_first_name").sendKeys("Matt");
        driver.findElementById("edittext_last_name").sendKeys("Carroll");
       // new Scroll().scrollToElement((MobileElement) driver.findElementByClassName("LinearLayout"), (MobileElement) driver.findElementById("edittext_address_line_1"), SwipeElementDirection.DOWN, 30);
        driver.findElementById("edittext_address_line_1").sendKeys("123 Fake Street");

        new Scroll().scrollHalfScreenUpOrDownNOContentView(SwipeElementDirection.UP);

        driver.findElementById("edittext_address_city").sendKeys("Palo Alto");
        driver.findElementById("edittext_address_state").sendKeys("CA");
        driver.findElementById("edittext_address_zip").sendKeys("94024");
        driver.findElementById("button_next").click();
        List<MobileElement> list = driver.findElementsById("android:id/text1");
        list.get(4).click();
        driver.findElementById("button_next").click();
        driver.findElementById("autocompletetextview_email").sendKeys("myuser");
        driver.findElementById("edittext_password").sendKeys("123456");
        driver.findElementById("button_next").click();
        waitForVisible((MobileElement) driver.findElementById("alertTitle"));
        Assert.assertTrue(driver.findElementById("alertTitle").getText().equals("Signup successful!"));
    }

}
