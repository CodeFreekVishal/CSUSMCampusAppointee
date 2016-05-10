package com.example.jal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Vishal on 09-05-2016.
 */
public class SignupDatabaseAdapter extends SQLiteOpenHelper {

    public static final String database_name = "signup.db";
    public static final int database_version = 1;

    public static final String table_name = "details";

    public static final String col_id = "id";
    public static final String col_fullname = "fullname";
    public static final String col_email = "emailid";
    public static final String col_password = "password";
    public static final String col_deparment = "department";
    public static final String col_contact = "contact";



    public SignupDatabaseAdapter(Context context){
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table details" + "(id integer primary key auto_increment, fullname text, emailid text, password text, department text, contact text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("TaskDbAdapter", "Upgrading database from" + oldVersion +  "to" + newVersion + ",which will destroy all data...");
        db.execSQL("DROP TABLE IF EXISTS"+table_name);
        onCreate(db);
    }

    public boolean insertRecords(String fullname, String emailid, String password, String department, String contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_fullname, fullname);
        contentValues.put(col_email, emailid);
        contentValues.put(col_password, password);
        contentValues.put(col_deparment, department);
        contentValues.put(col_contact, contact);

        db.insert(table_name, null,  contentValues);
        return true;
    }


    public boolean updateRecords(Integer id, String fullname, String emailid, String password, String department, String contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_fullname, fullname);
        contentValues.put(col_email, emailid);
        contentValues.put(col_password, password);
        contentValues.put(col_deparment, department);
        contentValues.put(col_contact, contact);

        db.update(table_name, contentValues, col_id+"=?",new String[] { Integer.toString(id) });
        return true;
    }

    public Cursor getRecord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + table_name + " WHERE " +
                col_id + "=?", new String[] { Integer.toString(id) } );
        return res;
    }

    public Cursor getAllRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + table_name, null );
        return res;
    }


    public Integer deleteRecord(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_name,
                col_id + " = ? ",
                new String[] { Integer.toString(id) });
    }


}
