package com.example.jal.csusmcampusappointee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Vishal on 15-05-2016.
 */
public class DbAdapter extends SQLiteOpenHelper {

    public static final String database_name = "persons.db";
    public static final int database_version = 1;

    public static final String table_name = "person";

    public static final String col_id = "id";
    public static final String col_fullname = "fullname";
    public static final String col_email = "emailid";
    public static final String col_password = "password";
    public static final String col_deparment = "department";
    public static final String col_contact = "contact";

   // public Context context;

    public SQLiteDatabase db;

    public String dbpath;

    public DbAdapter(Context context){
        super(context, database_name, null, database_version);
      //  this.context = context;
       // this.database_name = database_name;
      //  this.dbpath = this.context.getDatabasePath(database_name).getAbsolutePath();
      //  Log.e("Path 1", dbpath);
    }


   /* public DbAdapter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +table_name+ " ( "+ col_id +" integer auto_increment primary key, " +col_fullname+ " text, " +col_email+ " text, " +col_password+ " text, " +col_deparment+ " text, " +col_contact+ " text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("TaskDbAdapter", "Upgrading database from" + oldVersion +  "to" + newVersion + ",which will destroy all data...");
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);

        if(newVersion>oldVersion){
            }
            //copyDatabase();

    }

    public void insertRecords(String fullname, String emailid, String password, String department, String contact){
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_fullname, fullname);
        contentValues.put(col_email, emailid);
        contentValues.put(col_password, password);
        contentValues.put(col_deparment, department);
        contentValues.put(col_contact, contact);

        db.insert(table_name, null,  contentValues);

    }

    public String login(String emailid, String password){
        Cursor cursor = db.rawQuery("SELECT * FROM " +table_name+ " WHERE " +col_email+ " =? AND "+col_password+" =?",new String[]{emailid, password});
        if(cursor.getCount()<1){
            return "no";
        }
        else{
            return "yes";
        }
    }


    public DbAdapter open() throws SQLiteException {
        db = this.getWritableDatabase();
        return this;
    }

    public void close(){
        db.close();
    }

    public Cursor getAllRecords() {
        db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + table_name, null );
      //  Toast.makeText(this, String.valueOf(res.getCount()), Toast.LENGTH_LONG).show();
        System.out.println("..." + res.getCount());
        return res;
    }

}
