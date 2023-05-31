package com.example.loginsignup;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbManager extends SQLiteOpenHelper{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "usersdb";
    private static final String TABLE_Users = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_FNAME = "firstName";
    private static final String KEY_LNAME= "lastName";
    private static final String KEY_CONT= "contact";
    private static final String KEY_UNAME = "userName";
    private static final String KEY_PASS = "password";

    public DbManager(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_FNAME + " TEXT,"
                + KEY_LNAME + " TEXT,"
                + KEY_CONT + " TEXT,"
                + KEY_UNAME + " TEXT,"
                + KEY_PASS + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        // Create tables again
        onCreate(db);
    }

    void insertUser(User user){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_FNAME, user.firstName);
        cValues.put(KEY_LNAME, user.lasttName);
        cValues.put(KEY_CONT, user.contact);
        cValues.put(KEY_UNAME, user.userName);
        cValues.put(KEY_PASS, user.password);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users,null, cValues);
        db.close();
    }


    // Get User Details based on userid

    @SuppressLint("Range")
    public ArrayList<HashMap<String, String>> GetUserByUserName(String userName){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        //String query = "SELECT firstName, lastName, contact, userName, password FROM "+ TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_FNAME, KEY_LNAME, KEY_CONT, KEY_UNAME, KEY_PASS}, KEY_UNAME+ "=?",new String[]{String.valueOf(userName)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("firstName",cursor.getString(cursor.getColumnIndex(KEY_FNAME)));
            user.put("lastName",cursor.getString(cursor.getColumnIndex(KEY_LNAME)));
            user.put("contact",cursor.getString(cursor.getColumnIndex(KEY_CONT)));
            user.put("userName",cursor.getString(cursor.getColumnIndex(KEY_UNAME)));
            user.put("password",cursor.getString(cursor.getColumnIndex(KEY_PASS)));
            userList.add(user);
        }
        return  userList;
    }

}
