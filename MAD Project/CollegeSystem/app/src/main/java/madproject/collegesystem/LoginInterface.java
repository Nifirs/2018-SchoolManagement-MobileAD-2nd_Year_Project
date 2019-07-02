package madproject.collegesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginInterface extends AppCompatActivity {

    DBhelper db;



            private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");


    private EditText textInputUsername;
    private EditText textInputPassword;
    private Button btnregister;


   // private static Button submitlogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_interface);

        db = new DBhelper(this);


        textInputUsername = findViewById(R.id.e1);
        textInputPassword = findViewById(R.id.e2);

        OnClickButtonListener();


        Button reset1=(Button)findViewById(R.id.reset);

        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textInputUsername.setText("");
                textInputPassword.setText("");


            }
        });


    }

    private boolean validateUsername() {
        String usernameInput = textInputUsername.getText().toString().trim();

        if (usernameInput.isEmpty()) {
           textInputUsername.setError("Field can't be empty");
            //Toast.makeText(this, "Field can't be empty", Toast.LENGTH_LONG).show();

            return false;
        } else if (usernameInput.length() > 30) {
           textInputUsername.setError("Username too long");
            //Toast.makeText(this, "Username too long", Toast.LENGTH_LONG).show();


            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");

          //  Toast.makeText(this, "Field can't be empty", Toast.LENGTH_LONG).show();


            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
           textInputPassword.setError("Password should be included with AlphaNumeric Upper Lower cases and a special character!");

           // Toast.makeText(this, "Password too weak", Toast.LENGTH_LONG).show();


            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }


//    public void OnClickButtonListener() {
//
//        submitlogin = (Button) findViewById(R.id.login);
//
//        if((validatePassword())&& (validateUsername()))
//
//        {
//            submitlogin.setOnClickListener(
//                    new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                            Intent intent = new Intent(LoginInterface.this,Home.class);
//                            startActivity(intent);
//
//                        }
//
//
//                    });
//
//
//        }
//
//        else {
//
//            Toast.makeText(this, "Invalid E-mail or Password", Toast.LENGTH_LONG).show();
//
//
//
//        }
//
//
//
//    }



    public void confirmInput(View v) {

        String usernameInput = textInputUsername.getText().toString();
        String passwordInput = textInputPassword.getText().toString();


        if (!validateUsername() | !validatePassword()  )
        {


        String input = "Username: " + textInputUsername.getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getText().toString();
        input +="\n Invalid Username or Password!";

        Toast.makeText(this, input, Toast.LENGTH_LONG).show();


    }


        else



            if(db.unamepasswordCheck(usernameInput, passwordInput))


                {

                    Toast.makeText(this, "validated!!", Toast.LENGTH_LONG).show();


                         Intent intent = new Intent(LoginInterface.this, Home.class);
                           startActivity(intent);


                }

      else
          {

                Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_LONG).show();
                textInputUsername.setText("");
                textInputPassword.setText("");


          }



    }

        public void OnClickButtonListener() {

            btnregister = (Button) findViewById(R.id.register);


            btnregister.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(LoginInterface.this, register.class);
                            startActivity(intent);

                        }


                    });


        }



}
