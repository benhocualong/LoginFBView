package com.harusora.longcn.loginfbview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> {
            if (v.getId() == R.id.loginButton) {
                EditText username = findViewById(R.id.usernameTextField);
                EditText password = findViewById(R.id.passwordTextField);
                String message;
                if (username.getText().toString().trim().isBlank() || password.getText().toString().trim().isBlank()) {
                    message = "Please fill data !";
                } else if (ADMIN_USERNAME.equals(username.getText().toString()) && ADMIN_PASSWORD.equals(password.getText().toString())) {
                    message = "Login successfully!";
                } else {
                    message = "Login fail!";
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }


}