package ready.and.late.com.lateandready.helpers;

/**
 * Created by markf on 17/04/2016.
 */
public class LoginHelper {

    public void login(String username, String password, LoginResultInterface loginResultInterface) { // 3 parameters S,S,I
        if (username != null && password.length() >= 6) { //error checking username
            loginResultInterface.loginSuccesful(); // going to interface and will allow user go to next page
        }
        else if (username == null || password == null){ //simple error checking
            loginResultInterface.loginFailed("Login Failed - Please try again"); // if interface login failed = T, show error msg
        }

    }
}

