package edu.tuh42070.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.SignUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check that there is no empty fields and that passwords match
                if(checkNoEmptyFields() && confirmPasswords()){
                    // successful signup -- display welcome message
                    EditText nameEditText = findViewById(R.id.NameEditText);
                    String name = nameEditText.getText().toString();
                    Toast.makeText(getApplicationContext(),
                            "Account created, welcome " + name + "!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private Boolean checkNoEmptyFields(){
        /**
         * Checks if any of the input fields where left by the user. If so, a message is displayed
         * to alert the user of the required field.
         */

        Boolean hasEmpty = false;

        // Name
        EditText nameEditText = findViewById(R.id.NameEditText);
        String name = nameEditText.getText().toString();
        if (isEmptyField(name)){
            nameEditText.setHint("Required Field!");
            nameEditText.setHintTextColor(Color.RED);
            Log.d("FormActivity", "NameEditText: User left empty field");
            hasEmpty = true;
        }

        // Email
        EditText emailEditText = findViewById(R.id.EmailEditText);
        String email = emailEditText.getText().toString();
        if (isEmptyField(email)){
            emailEditText.setHint("Required Field!");
            emailEditText.setHintTextColor(Color.RED);
            Log.d("FormActivity", "EmailEditText: User left empty field");
            hasEmpty = true;
        }

        // Password
        EditText passwordEditText = findViewById(R.id.PasswordEditText);
        String password = passwordEditText.getText().toString();
        if (isEmptyField(password)){
            passwordEditText.setHint("Required Field!");
            passwordEditText.setHintTextColor(Color.RED);
            Log.d("FormActivity", "PasswordEditText: User left empty field");
            hasEmpty = true;
        }

        // ConfirmPassword
        EditText confirmPasswordEditText = findViewById(R.id.ConfirmPasswordEditText);
        String confirmPassword = confirmPasswordEditText.getText().toString();
        if (isEmptyField(confirmPassword)){
            confirmPasswordEditText.setHint("Required Field!");
            confirmPasswordEditText.setHintTextColor(Color.RED);
            Log.d("FormActivity", "ConfirmPasswordEditText: User left empty field");
            hasEmpty = true;
        }

        return !hasEmpty;
    }

    private Boolean isEmptyField(String fieldText){
        if (fieldText.length() == 0 || fieldText == null)
            return true;

        return false;
    }

    private Boolean confirmPasswords(){
        /**
         * Checks that both password fields contain the same password.
         * Returns true if they match, false otherwise.
         */

        // PasswordEditText
        EditText passwordEditText = findViewById(R.id.PasswordEditText);
        String password = passwordEditText.getText().toString();

        // ConfirmPasswordEditText
        EditText confirmPasswordEditText = findViewById(R.id.ConfirmPasswordEditText);
        String confirmPassword = confirmPasswordEditText.getText().toString();

        if(!password.equals(confirmPassword)){
            Log.d("FormActivity", "Passwords did not match");
            Toast.makeText(getApplicationContext(),
                    "Passwords must be the same!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
