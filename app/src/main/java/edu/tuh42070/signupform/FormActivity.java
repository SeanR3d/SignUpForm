package edu.tuh42070.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.SignUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameView = findViewById(R.id.NameEditText);
                String name = nameView.getText().toString();
                if (checkEmptyField(name)){
                    nameView.setHint("Required Field!");
                    nameView.setHintTextColor(Color.RED);
                };

                EditText emailView = findViewById(R.id.EmailEditText);
                String email = emailView.getText().toString();

                EditText passwordView = findViewById(R.id.PasswordEditText);
                String password = passwordView.getText().toString();

                EditText confirmPasswordView = findViewById(R.id.ConfirmPasswordEditText);
                String confirmPassword = confirmPasswordView.getText().toString();


                // check empty fields
                // check passwords
                // display welcome message

            }
        });
    }

    private Boolean checkEmptyField(String fieldText){
        if (fieldText.length() == 0 || fieldText == null)
            return false;

        return true;
    }

    private Boolean confirmPasswords(String password, String confirmPassword){
        return false;
    }

}
