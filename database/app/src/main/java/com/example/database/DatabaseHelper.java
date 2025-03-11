package com.example.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Studentdatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "student";
    private static final String COL_ID = "id";
    private static final String COL_name = "name";
    private static final String COL_age = "age";
    private static final String COL_mobile = "mobile";
    private static final String COL_roll = "roll";


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_name + " TEXT, " +
            COL_age + " INTEGER, " +
            COL_mobile + " TEXT, " +
            COL_roll + " INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertData(String name, int age, String mobile, int roll) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_name, name);
        values.put(COL_age, age);
        values.put(COL_mobile, mobile);
        values.put(COL_roll, roll);

        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    public void resetdatabase()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        onUpgrade(db,1,1);
        db.close();
    }

}