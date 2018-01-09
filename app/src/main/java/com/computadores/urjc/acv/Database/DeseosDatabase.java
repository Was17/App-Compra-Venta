package com.computadores.urjc.acv.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by was12 on 22/12/2017.
 */

public class DeseosDatabase {
    static final String DATABASE_CREATE="create table users (_id integer primary key autoincrement,name text not null,email text not null,password text not null,photo int not null);";
    static final String ID="_id";
    static final String NAME="name";
    static final String EMAIL="email";
    static final String PASSWORD="password";
    static final String PHOTO="photo";
    static final String TAG="DBAdapter";
    static final String DATABASE_NAME="MiDB";
    static final String TABLE_NAME="Users";
    static final int DATABASE_VERSION=1;
    final Context context;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;

    public DeseosDatabase(Context context) {
        this.context = context;
        databaseHelper=new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            }catch (SQLException e){

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Users");
            onCreate(db);
        }
    }

    public DeseosDatabase open()throws SQLException
    {
        sqLiteDatabase=databaseHelper.getWritableDatabase();
        return this;
    }
    public  void  close(){
        databaseHelper.close();
    }
    public long insert(String name,int escudo){
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(PHOTO,escudo);
        return sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }
    public boolean delete(long id){
        return sqLiteDatabase.delete(TABLE_NAME,ID+"="+id,null)>0;
    }
    public Cursor getAll(){
        return sqLiteDatabase.query(TABLE_NAME,new String[]{ID,NAME,PHOTO},null,null,null,null,null);
    }
    public Cursor get(long rowID)throws SQLException{

        Cursor cursor=sqLiteDatabase.query(true,TABLE_NAME,new String[]{ID,NAME,PHOTO},ID+"="+rowID,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;

    }
    public boolean update(long rowId,String name,String escudo){
        ContentValues args=new ContentValues();
        args.put(NAME,name);
        args.put(PHOTO,escudo);
        return sqLiteDatabase.update(TABLE_NAME,args,ID+"="+rowId,null)>0;
    }
}
