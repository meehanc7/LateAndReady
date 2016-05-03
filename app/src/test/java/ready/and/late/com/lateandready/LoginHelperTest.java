package ready.and.late.com.lateandready;

import org.junit.Test;

import ready.and.late.com.lateandready.helpers.LoginHelper;
import ready.and.late.com.lateandready.helpers.LoginResultInterface;

import static org.junit.Assert.*;


/**
 * Created by OEM on 03-May-16.
 */
public class LoginHelperTest {


    @Test
    public void testLoginHelperWrongUsernamePassword() throws Exception {
        LoginHelper loginHelper = new LoginHelper();


        loginHelper.login("hello", "what", new LoginResultInterface() {
            @Override
            public void loginSuccesful() {

                fail();
            }

            @Override
            public void loginFailed(String errormessage) {
                assertTrue(true);

            }
        });

    }



    @Test
    public void testLoginHelperCorrectUsernamePassword() throws Exception {
        LoginHelper loginHelper = new LoginHelper();


        loginHelper.login("conor.meehan21@gmail.com", "rightpassword", new LoginResultInterface() {
            @Override
            public void loginSuccesful() {

                assertTrue(true);
            }

            @Override
            public void loginFailed(String errormessage) {

                fail();

            }
        });

    }
}
