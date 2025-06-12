package com.appdev.group3.ecollect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 2);
    }



    @Override
    public void onCreate(SQLiteDatabase DB) {
        Log.d("DB_DEBUG", "Creating table Announcements");
        DB.execSQL("CREATE TABLE IF NOT EXISTS Announcements (message TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("DROP TABLE IF EXISTS Announcements");
        onCreate(DB);
    }

    public Boolean insertuserdata(String msg) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("message", msg);

        try {
            long result = DB.insert("Announcements", null, contentValues);
            if (result == -1) {
                Log.e("DB_ERROR", "Insert failed for message: " + msg);
                return false;
            } else {
                Log.d("DB_SUCCESS", "Insert succeeded for message: " + msg);
                return true;
            }
        } catch (Exception e) {
            Log.e("DB_ERROR", "Exception during insert: " + e.getMessage());
            return false;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Announcements", null);
        return cursor;
    }

    public Boolean deleteuserdata(String msg) {
        SQLiteDatabase DB = this.getWritableDatabase();
        long result = DB.delete("Announcements", "message=?", new String[]{msg});
        return result != -1;
    }
}