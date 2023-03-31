package email;

import org.checkEmail.Main;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AppTest {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"1sername@domain.com"},
                {"username.@domain.com"},
                {"user name@domain.com"},
                {"користувач@domain.com"},
                {"!username@domain.com"},
                {"usernamedomain.com"},
                {"username&domain.com"},
                {"username@domain_com"},
                {"username@domain.i"},
                {"username&domain"},
                {""}
        };
    }
    @Test(dataProvider ="data-provider")
    public void testEmailFalse(String text) {
        Assert.assertFalse(Main.checkEmail(text));
    }
    @DataProvider(name = "data-provider-true")
    public Object[][] dpMethod1(){
        return new Object[][] {
                {"username@domain.com"},
                {"user.name@domain.com"},
                {"user1name@domain.com"},
                {"Username@domain.com"},
                {"user.name.my@domain.com"},
                {"username@domain1.com"},
                {"username@domain.com.ua"}
        };
    }
    @Test(dataProvider ="data-provider-true")
    public void testEmailTrue(String text) {
        Assert.assertTrue(Main.checkEmail(text));
    }
}
