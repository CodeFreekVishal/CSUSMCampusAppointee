package com.example.jal.database;

import android.content.Context;
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
        db.execSQL("create table details" + "(id integer primary key, fullname text, emailid text, password text, department text, contact text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("TaskDbAdapter", "Upgrading database from" + oldVersion +  "to" + newVersion + ",which will destroy all data...");
        db.execSQL("DROP TABLE IF EXISTS"+table_name);
        onCreate(db);
    }


}
