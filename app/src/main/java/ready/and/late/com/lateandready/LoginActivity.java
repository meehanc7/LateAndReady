package ready.and.late.com.lateandready;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ready.and.late.com.lateandready.helpers.LoginHelper;
import ready.and.late.com.lateandready.helpers.LoginResultInterface;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailEditText = (EditText) findViewById(R.id.edittext_login_email);
        passwordEditText = (EditText) findViewById(R.id.edittext_login_password);
        final LoginHelper loginHelper = new LoginHelper();

        Button advanceToSearch = (Button) findViewById(R.id.buttonLogin);
        advanceToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = String.valueOf(emailEditText.getText());
                String passwordText = String.valueOf(passwordEditText.getText());

                loginHelper.login(emailText, passwordText, new LoginResultInterface() { //login helper class, login method, parameters, creating new interface
                    @Override
                    public void loginSuccesful() {
                        Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void loginFailed(String errormessage) {
                        showToast(errormessage);
                    }
                });
            }
        });
    }
/*
    private boolean isEmailValid(String emailText) {
        if (emailText == null || emailText.length() <= 5) {
            Toast.makeText(this, "Please enter correct email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isPasswordValid(String passwordText) {
        if (passwordText == null || passwordText.length() <= 5) {
            Toast.makeText(this, "Please enter a valid password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
*/

    private void showToast(String errorMessage){
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

}
