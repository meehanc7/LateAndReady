package ready.and.late.com.lateandready.helpers;

/**
 * Created by markf on 17/04/2016.
 */
public class LoginHelper {

    public void login(String username, String password, LoginResultInterface loginResultInterface) {
        if (username != null && password.length() >= 6) {
            loginResultInterface.loginSuccesful();
        }
        else if (username == null || password == null){
            loginResultInterface.loginFailed("Login Failed - Please try again");
        }

    }
}

