package com.example.ilvinas.stalozaidimuklubas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int USER_LEVEL_DEFAULT = 1;

        final EditText etUsername = (EditText) findViewById(R.id.register_username);
        final EditText etPassword1 = (EditText) findViewById(R.id.register_password1);
        final EditText etPassword2 = (EditText) findViewById(R.id.register_password2);
        final EditText etMail = (EditText) findViewById(R.id.register_mail);

        etUsername.setError(null);
        etPassword1.setError(null);
        etPassword1.setError(null);
        etMail.setError(null);

        Button button_register = (Button) findViewById(R.id.button_register1);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean cancel = false;
                if (!Validation.isValidCredentials(etUsername.getText().toString())) {
                    cancel = true;
                    etUsername.requestFocus();
                    etUsername.setError(getResources().getString(R.string.prompt_credentials));
                } else if (!Validation.isValidCredentials(etPassword1.getText().toString())) {
                    cancel = true;
                    etPassword1.requestFocus();
                    etPassword1.setError(getResources().getString(R.string.prompt_credentials));
                } else if (!Validation.isValidCredentials(etPassword2.getText().toString())) {
                    cancel = true;
                    etPassword2.requestFocus();
                    etPassword2.setError(getResources().getString(R.string.prompt_credentials));
                }
                else if (!etPassword1.getText().toString().equals(etPassword2.getText().toString())) {
                    //Toast.makeText(view.getContext(), getResources().getString(R.string.invalid_password_mismatch), Toast.LENGTH_SHORT).show();
                    cancel = true;
                    etPassword2.requestFocus();
                    etPassword2.setError(getResources().getString(R.string.invalid_password_mismatch));
                } else if (!Validation.isValidMail(etMail.getText().toString())) {
                    //Toast.makeText(view.getContext(), getResources().getString(R.string.invalid_mail), Toast.LENGTH_SHORT).show();
                    cancel = true;
                    etMail.requestFocus();
                    etMail.setError(getResources().getString(R.string.invalid_mail));
                } else {
                    User user = new User(etUsername.getText().toString(), etPassword1.getText().toString(), etMail.getText().toString(), USER_LEVEL_DEFAULT);
                    DBHandler db = new DBHandler(RegisterActivity.this);
                    db.addUser(user);
                    Toast.makeText(view.getContext(), getResources().getString(R.string.registration_successfull), Toast.LENGTH_SHORT).show();
                    Intent Intent = new Intent(view.getContext(), LoginActivity.class);
                    view.getContext().startActivity(Intent);
                }
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_registercancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), LoginActivity.class);
                view.getContext().startActivity(Intent);}
        });
    }

}
