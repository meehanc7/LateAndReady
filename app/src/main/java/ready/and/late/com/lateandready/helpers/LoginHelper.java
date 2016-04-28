package ready.and.late.com.lateandready.helpers;

/**
 * Created by markf on 17/04/2016.
 */
public class LoginHelper {

    public void login(String email, String password, LoginResultInterface loginResultInterface) { // 3 parameters S,S, passing in the Interface
        if (email == null || email.length() == 0 || !email.contains("@")) { //error checking username
            loginResultInterface.loginFailed("Please enter a valid email"); // going to interface and will allow user go to next page
        }
        else if (password == null || password.length() == 0 || password.length() < 5){ // error checking on password
            loginResultInterface.loginFailed("Please enter a valid password"); // if interface login failed show error msg
        }
        else{
            loginResultInterface.loginSuccesful(); //else log in
        }


    }
}

