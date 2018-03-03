package com.example.ilvinas.stalozaidimuklubas;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Žilvinas on 2018-02-02.
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private int level;
    private static final String PREFERENCES_FILE_NAME = "com.example.ilvinas.stalozaidimuklubas";
    private static final String ID_KEY = "id";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String LEVEL_KEY = "level";
    private static final String REMEMBER_ME_KEY = "rememberMe";

    private SharedPreferences sharedPreferences;

    //skirtas register activity registruojant nauja vartotoja
    public User(String username, String password, String email, int level) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.level = level;
    }
    public User(int id, String username, String password, String email, int level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.level = level;
    }
    public User() {
    }
    //konstruktorius skirtas login langui
    public User(Context context){
        this.sharedPreferences = context.getSharedPreferences
                (User.PREFERENCES_FILE_NAME,Context.MODE_PRIVATE);
    }

    //geteriai seteriai skirti login activity prisijungimo langui
    public int getIdForLogin() {
        return this.sharedPreferences.getInt(ID_KEY, 0);
    }
    public void setIdForLogin(int id) {
        this.sharedPreferences.edit().putInt(ID_KEY, id).commit();
    }
    public String getUsernameForLogin() {
        return this.sharedPreferences.getString(USERNAME_KEY,"");
    }
    public void setUsernameForLogin(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY, username).commit();
    }
    public String getPasswordForLogin() {
        return this.sharedPreferences.getString(PASSWORD_KEY,"");
    }
    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY, password).commit();
    }
    public int getLevelForLogin() {
        return this.sharedPreferences.getInt(LEVEL_KEY, 0);
    }
    public void setLevelForLogin(int level) {
        this.sharedPreferences.edit().putInt(LEVEL_KEY, level).commit();
    }
    public boolean isRemembered(){
        return this.sharedPreferences.getBoolean(REMEMBER_ME_KEY,false);
    }
    public void setRememberMeKeyForLogin(boolean rememberMe){
        this.sharedPreferences.edit().putBoolean(REMEMBER_ME_KEY, rememberMe).commit();
    }
    //sitie geteriai seteriai skirti register activity langui
    public int getIdForRegister() { return id; }
    public void setIdForRegister(int id) { this.id = id; }
    public String getUsernameForRegister() {
        return username;
    }
    public void setUsernameForRegister(String username) {
        this.username = username;
    }
    public String getPasswordForRegister() {
        return password;
    }
    public void setPasswordForRegister(String password) {
        this.password = password;
    }
    public String getEmailForRegister() {
        return email;
    }
    public void setEmailForRegister(String email) {
        this.email = email;
    }
    public int getLevelForRegister() { return level; }
    public void setLevelForRegister(int level) {
        this.level = level;
    }

    public String printout() {
        return "User{" + "id=" + id + '\'' + "userlevel='" + level + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + '}';
    }
}
