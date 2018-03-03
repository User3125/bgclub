package com.example.ilvinas.stalozaidimuklubas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "db3";
    private static final String TABLE_USERS = "users";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MAIL = "mail";
    private static final String KEY_PASS = "pass";
    private static final String KEY_LEVEL = "level";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_MAIL + " TEXT," + KEY_PASS + " TEXT," + KEY_LEVEL + " INTEGER)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LEVEL, user.getLevelForRegister());
        values.put(KEY_NAME, user.getUsernameForRegister());
        values.put(KEY_PASS, user.getPasswordForRegister());
        values.put(KEY_MAIL, user.getEmailForRegister());
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_USERS,
                new String[]{KEY_ID, KEY_LEVEL, KEY_NAME, KEY_PASS, KEY_MAIL},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        User user = new User(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
        return user;
    }

    public List<User> getUsers(String name) {
        List<User> users = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE name LIKE '" + name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {User user = new User();
                user.setIdForRegister(cursor.getInt(0));
                user.setUsernameForRegister(cursor.getString(1));
                user.setEmailForRegister(cursor.getString(2));
                user.setPasswordForRegister(cursor.getString(3));
                user.setLevelForRegister(cursor.getInt(4));
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {User user = new User();
                user.setIdForRegister(cursor.getInt(0));
                user.setUsernameForRegister(cursor.getString(1));
                user.setEmailForRegister(cursor.getString(2));
                user.setPasswordForRegister(cursor.getString(3));
                user.setLevelForRegister(cursor.getInt(4));
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }
}