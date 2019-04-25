package com.example.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    socketer s;

    private EditText userName, userPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI_inputs();
        s = new socketer();
        new openConnection().execute(s); //connecting to server on run
        //placeholder
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                        //testing.. will be updated
                    String username, password;
                    username = userName.getText().toString();
                    password = userPassword.getText().toString();

                    sendMessage("USERNAME: ");
                    sendMessage(username);
                    sendMessage("PASSWORD: ");
                    sendMessage(password);
                    
                }
            }
        });
    }

    private void setupUI_inputs() {
        userName = (EditText) findViewById(R.id.etUsername);
        userPassword = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.LoginButton);
    }

    private void loginValidation(String username, String password) {
        String input_username, input_password;

        input_username = username;
        input_password = password;


    }

    private boolean validation() {
        boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();

        if (name.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter all of the credentials!", Toast.LENGTH_SHORT);

        } else {
            result = true;
        }
        return result;
    }

    public void sendMessage(String message) {
        new longOperation().execute(message);
    }


    private class openConnection extends AsyncTask<socketer, Void, Void> {
        @Override
        protected Void doInBackground(socketer... b) {
            b[0].openConnect();
            return null;
        }
    }

    private class longOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... a) {
            try {
                s.sendMessage(a[0]);
            } catch (Exception e) {
                System.out.println(e);
            }
            return null;
        }
    }

}
