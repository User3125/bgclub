package com.example.ilvinas.stalozaidimuklubas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BGDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "db2";
    private static final String TABLE_GAMES = "games";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CAT01 = "cat01";
    private static final String KEY_CAT02 = "cat02";
    private static final String KEY_CAT03 = "cat03";
    private static final String KEY_CAT04 = "cat04";
    private static final String KEY_CAT05 = "cat05";
    private static final String KEY_CAT06 = "cat06";
    private static final String KEY_CAT07 = "cat07";
    private static final String KEY_CAT08 = "cat08";
    private static final String KEY_CAT09 = "cat09";
    private static final String KEY_CAT10 = "cat10";
    private static final String KEY_CAT11 = "cat11";
    private static final String KEY_CAT12 = "cat12";
    private static final String KEY_CAT13 = "cat13";
    private static final String KEY_CAT14 = "cat14";
    private static final String KEY_CAT15 = "cat15";
    private static final String KEY_YEAR = "year";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PUBLISHER = "publisher";
    private static final String KEY_OWNER = "owner";
    private static final String KEY_HOLDER = "holder";

    public BGDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GAMES_TABLE = "CREATE TABLE " + TABLE_GAMES + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_TITLE + " TEXT, " + KEY_CAT01 + " BOOLEAN, " + KEY_CAT02 + " BOOLEAN, " + KEY_CAT03 + " BOOLEAN, " + KEY_CAT04 + " BOOLEAN, " + KEY_CAT05 + " BOOLEAN, " + KEY_CAT06 + " BOOLEAN, " + KEY_CAT07 + " BOOLEAN, " + KEY_CAT08 + " BOOLEAN, " + KEY_CAT09 + " BOOLEAN, " + KEY_CAT10 + " BOOLEAN, " + KEY_CAT11 + " BOOLEAN, " + KEY_CAT12 + " BOOLEAN, " + KEY_CAT13 + " BOOLEAN, " + KEY_CAT14 + " BOOLEAN, " + KEY_CAT15 + " BOOLEAN, " + KEY_YEAR + " INTEGER, " + KEY_AUTHOR + " TEXT, " + KEY_PUBLISHER + " TEXT, " + KEY_OWNER + " TEXT, " + KEY_HOLDER + " TEXT)";
        db.execSQL(CREATE_GAMES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAMES);
        onCreate(db);
    }

    void addGame(Zaidimas game) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, game.getTitle());
        values.put(KEY_CAT01, game.isCat01());
        values.put(KEY_CAT02, game.isCat02());
        values.put(KEY_CAT03, game.isCat03());
        values.put(KEY_CAT04, game.isCat04());
        values.put(KEY_CAT05, game.isCat05());
        values.put(KEY_CAT06, game.isCat06());
        values.put(KEY_CAT07, game.isCat07());
        values.put(KEY_CAT08, game.isCat08());
        values.put(KEY_CAT09, game.isCat09());
        values.put(KEY_CAT10, game.isCat10());
        values.put(KEY_CAT11, game.isCat11());
        values.put(KEY_CAT12, game.isCat12());
        values.put(KEY_CAT13, game.isCat13());
        values.put(KEY_CAT14, game.isCat14());
        values.put(KEY_CAT15, game.isCat15());
        values.put(KEY_YEAR, game.getYear());
        values.put(KEY_AUTHOR, game.getAuthor());
        values.put(KEY_PUBLISHER, game.getPublisher());
        values.put(KEY_OWNER, game.getOwner());
        values.put(KEY_HOLDER, game.getHolder());
        db.insert(TABLE_GAMES, null, values);
        db.close();
    }

    void updateGame(Zaidimas game) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, game.getId());
        values.put(KEY_TITLE, game.getTitle());
        values.put(KEY_CAT01, game.isCat01());
        values.put(KEY_CAT02, game.isCat02());
        values.put(KEY_CAT03, game.isCat03());
        values.put(KEY_CAT04, game.isCat04());
        values.put(KEY_CAT05, game.isCat05());
        values.put(KEY_CAT06, game.isCat06());
        values.put(KEY_CAT07, game.isCat07());
        values.put(KEY_CAT08, game.isCat08());
        values.put(KEY_CAT09, game.isCat09());
        values.put(KEY_CAT10, game.isCat10());
        values.put(KEY_CAT11, game.isCat11());
        values.put(KEY_CAT12, game.isCat12());
        values.put(KEY_CAT13, game.isCat13());
        values.put(KEY_CAT14, game.isCat14());
        values.put(KEY_CAT15, game.isCat15());
        values.put(KEY_YEAR, game.getYear());
        values.put(KEY_AUTHOR, game.getAuthor());
        values.put(KEY_PUBLISHER, game.getPublisher());
        values.put(KEY_OWNER, game.getOwner());
        values.put(KEY_HOLDER, game.getHolder());
        db.update(TABLE_GAMES, values, KEY_ID + " = " + game.getId(), null);
        db.close();
    }

    void deleteGame(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GAMES, KEY_ID + " = " + id, null);
    }

    Zaidimas getGame(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_GAMES,
                new String[]{KEY_ID, KEY_TITLE, KEY_CAT01, KEY_CAT02, KEY_CAT03, KEY_CAT04, KEY_CAT05, KEY_CAT06, KEY_CAT07, KEY_CAT08, KEY_CAT09, KEY_CAT10, KEY_CAT11, KEY_CAT12, KEY_CAT13, KEY_CAT14, KEY_CAT15, KEY_YEAR, KEY_AUTHOR, KEY_PUBLISHER, KEY_OWNER, KEY_HOLDER},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Zaidimas game = new Zaidimas(cursor.getInt(0), cursor.getString(1), (cursor.getInt(2))==1, (cursor.getInt(3))==1, (cursor.getInt(4))==1, (cursor.getInt(5))==1, (cursor.getInt(6))==1, (cursor.getInt(7))==1, (cursor.getInt(8))==1, (cursor.getInt(9))==1, (cursor.getInt(10))==1, (cursor.getInt(11))==1, (cursor.getInt(12))==1, (cursor.getInt(13))==1, (cursor.getInt(14))==1, (cursor.getInt(15))==1, (cursor.getInt(16))==1, cursor.getInt(17), cursor.getString(18), cursor.getString(19), cursor.getString(20), cursor.getString(21));
        return game;
    }

    public List<Zaidimas> getGames(String title) {
        List<Zaidimas> games = new ArrayList<Zaidimas>();
        String selectQuery = "SELECT  * FROM " + TABLE_GAMES + " WHERE title LIKE '%" + title + "%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {Zaidimas game = new Zaidimas();
                game.setId(cursor.getInt(0));
                game.setTitle(cursor.getString(1));
                game.setCat01((cursor.getInt(2))==1);
                game.setCat02((cursor.getInt(3))==1);
                game.setCat03((cursor.getInt(4))==1);
                game.setCat04((cursor.getInt(5))==1);
                game.setCat05((cursor.getInt(6))==1);
                game.setCat06((cursor.getInt(7))==1);
                game.setCat07((cursor.getInt(8))==1);
                game.setCat08((cursor.getInt(9))==1);
                game.setCat09((cursor.getInt(10))==1);
                game.setCat10((cursor.getInt(11))==1);
                game.setCat11((cursor.getInt(12))==1);
                game.setCat12((cursor.getInt(13))==1);
                game.setCat13((cursor.getInt(14))==1);
                game.setCat14((cursor.getInt(15))==1);
                game.setCat15((cursor.getInt(16))==1);
                game.setYear(cursor.getInt(17));
                game.setAuthor(cursor.getString(18));
                game.setPublisher(cursor.getString(19));
                game.setOwner(cursor.getString(20));
                game.setHolder(cursor.getString(21));
                games.add(game);
            } while (cursor.moveToNext());
        }
        return games;
    }

    public List<Zaidimas> getAllGames() {
        List<Zaidimas> games = new ArrayList<Zaidimas>();
        String selectQuery = "SELECT  * FROM " + TABLE_GAMES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {Zaidimas game = new Zaidimas();
                game.setId(cursor.getInt(0));
                game.setTitle(cursor.getString(1));
                game.setCat01((cursor.getInt(2))==1);
                game.setCat02((cursor.getInt(3))==1);
                game.setCat03((cursor.getInt(4))==1);
                game.setCat04((cursor.getInt(5))==1);
                game.setCat05((cursor.getInt(6))==1);
                game.setCat06((cursor.getInt(7))==1);
                game.setCat07((cursor.getInt(8))==1);
                game.setCat08((cursor.getInt(9))==1);
                game.setCat09((cursor.getInt(10))==1);
                game.setCat10((cursor.getInt(11))==1);
                game.setCat11((cursor.getInt(12))==1);
                game.setCat12((cursor.getInt(13))==1);
                game.setCat13((cursor.getInt(14))==1);
                game.setCat14((cursor.getInt(15))==1);
                game.setCat15((cursor.getInt(16))==1);
                game.setYear(cursor.getInt(17));
                game.setAuthor(cursor.getString(18));
                game.setPublisher(cursor.getString(19));
                game.setOwner(cursor.getString(20));
                game.setHolder(cursor.getString(21));
                games.add(game);
            } while (cursor.moveToNext());
        }
        return games;
    }
}
