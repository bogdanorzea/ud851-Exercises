package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.waitlist.data.WaitlistContract.WaitlistEntry;

// COMPLETED (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // COMPLETED (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    static final String DATABASE_NAME = "waitlist.db";
    // COMPLETED (3) Create a static final int called DATABASE_VERSION and set it to 1
    static final int DATABASE_VERSION = 1;

    // COMPLETED (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // COMPLETED (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase db) {
        // COMPLETED (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        final String SEPARATOR = " ,";
        final String INTEGER_TYPE = " INTEGER";
        final String TEXT_TYPE = " TEXT";
        final String DATETIME_TYPE = "DATETIME";
        String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + WaitlistEntry.TABLE_NAME + " (" +
                WaitlistEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + " AUTOINCREMENT" + SEPARATOR +
                WaitlistEntry.COLUMN_GUEST_NAME + TEXT_TYPE + SEPARATOR +
                WaitlistEntry.COLUMN_PARTY_SIZE + INTEGER_TYPE + SEPARATOR +
                WaitlistEntry.COLUMN_TIMESTAMP + " " + DATETIME_TYPE + ");";

        // COMPLETED (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // COMPLETED (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // COMPLETED (9) Inside, execute a drop table query, and then call onCreate to re-create it
        String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + WaitlistEntry.TABLE_NAME + ";";
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }
}