package com.example.ilvinas.stalozaidimuklubas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText etUsername = (EditText) findViewById(R.id.login_username);
        final EditText etPassword = (EditText) findViewById(R.id.login_password);
        final CheckBox cbRememberMe = (CheckBox) findViewById(R.id.cb_rememberme);
        final User user = new User(LoginActivity.this);

        etUsername.setError(null);
        etPassword.setError(null);

        cbRememberMe.setChecked(user.isRemembered());

        if(user.isRemembered()) {
            etUsername.setText(user.getUsernameForLogin(), TextView.BufferType.EDITABLE);
            etPassword.setText(user.getPasswordForLogin(), TextView.BufferType.EDITABLE);
        }else{
            etUsername.setText("", TextView.BufferType.EDITABLE);
            etPassword.setText("", TextView.BufferType.EDITABLE);
        }

        Button button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                DBHandler db = new DBHandler(LoginActivity.this);
                if (Validation.isValidCredentials(etUsername.getText().toString()) && Validation.isValidCredentials(etPassword.getText().toString())) {
                    List<User> possibles = db.getUsers(etUsername.getText().toString());
                    if (!possibles.isEmpty()) {
                        for (User temp:possibles) {
                            if (etPassword.getText().toString().equals(temp.getPasswordForRegister())) {
                                Toast.makeText(view.getContext(), "Sveiki, " + temp.getUsernameForRegister().toString() + "!", Toast.LENGTH_SHORT).show();
                                Intent Intent = new Intent(view.getContext(), MainActivity.class);
                                view.getContext().startActivity(Intent);
                            } else {
                                Toast.makeText(view.getContext(), getResources().getString(R.string.invalid_pass), Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(view.getContext(), getResources().getString(R.string.invalid_user), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(view.getContext(), getResources().getString(R.string.invalid_credentials), Toast.LENGTH_SHORT).show();
                }
                if(cbRememberMe.isChecked()){
                    user.setUsernameForLogin(etUsername.getText().toString());
                    user.setPasswordForLogin(etPassword.getText().toString());
                    user.setRememberMeKeyForLogin(true);
                }else{
                    user.setRememberMeKeyForLogin(false);
                }
            }
        });

        Button button_register = (Button) findViewById(R.id.button_register0);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), RegisterActivity.class);
                view.getContext().startActivity(Intent);}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
