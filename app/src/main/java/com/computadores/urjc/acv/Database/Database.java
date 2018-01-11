package com.computadores.urjc.acv.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Database extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ACV";

    // Table Names
    private static final String TABLE_USERS = "users";
    private static final String TABLE_ARTICULOS = "articulos";
    private static final String TABLE_CHAT = "chat";

    static final String ID="_id";
    static final String NAME="name";
    static final String EMAIL="email";
    static final String PASSWORD="password";
    static final String PHOTO="photo";

    static final String ID_ARTICULOS ="_id";
    static final String NAME_ARTICULOS ="name";
    static final String PRECIO ="email";
    static final String DESCRIPCION ="password";
    static final String PHOTO_ARTICULO ="photo";
    static final String ARTICULO_ID_USER ="id_user";
    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_ARTICULO = "CREATE TABLE "
            + TABLE_ARTICULOS + "(" + ID_ARTICULOS + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME_ARTICULOS
            + " TEXT NOT NULL," + PRECIO + " TEXT NOT NULL," + DESCRIPCION
            + " TEXT NOT NULL,"+PHOTO_ARTICULO + " TEXT NOT NULL," + ARTICULO_ID_USER
            + " TEXT NOT NULL" + ")";
   private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USERS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME
            + " TEXT NOT NULL," + PASSWORD + " TEXT NOT NULL," + EMAIL
            + " TEXT NOT NULL,"+PHOTO + ")";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_ARTICULO);
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICULOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAT);

        // create new tables
        onCreate(db);
    }

    // ------------------------ USERS table methods ----------------//
    public long insertUser(String name,String email,String password,String foto){
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(PHOTO,foto);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);

        SQLiteDatabase db = this.getReadableDatabase();
        return db.insert(TABLE_USERS,null,contentValues);
    }
    public boolean deleteUser(long id){
        return sqLiteDatabase.delete(TABLE_USERS,ID+"="+id,null)>0;
    }
    public Cursor getAllUsers(){
        return sqLiteDatabase.query(TABLE_USERS,new String[]{ID,NAME, EMAIL,PASSWORD,PHOTO},null,null,null,null,null);
    }
    public Cursor getUserByName(String name) {
        Cursor cursor=null;
    try{
        cursor = this.sqLiteDatabase.query(true,TABLE_USERS,new String[]{ID,NAME,EMAIL,PASSWORD,PHOTO}, NAME+ "=?", new String[] { name }, null, null, null,null );
        if(cursor!=null){
            cursor.moveToFirst();
        }
    }catch (Exception e){

    }

        return cursor;}
    public Cursor getUser(long rowID)throws SQLException{

        Cursor cursor=sqLiteDatabase.query(true,TABLE_USERS,new String[]{ID,NAME,EMAIL,PASSWORD,PHOTO},ID+"="+rowID,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;

    }
    public boolean updateUser(long rowId,String name,String email,String password,String foto){
        ContentValues args=new ContentValues();
        args.put(NAME,name);
        args.put(PHOTO,foto);
        args.put(EMAIL,email);
        args.put(PASSWORD,password);
        return sqLiteDatabase.update(TABLE_USERS,args,ID+"="+rowId,null)>0;
    }
    public Database open()throws SQLException
    {
        sqLiteDatabase=this.getReadableDatabase();
        return this;
    }




    //ARTICULOS

    public long insertArticulo(String name,String email,String password,String foto){
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME_ARTICULOS,name);
        contentValues.put(PHOTO,foto);
        contentValues.put(PRECIO,email);
        contentValues.put(PASSWORD,password);
        return sqLiteDatabase.insert(TABLE_ARTICULOS,null,contentValues);
    }
    public boolean delete(long id){
        return sqLiteDatabase.delete(TABLE_ARTICULOS, ID_ARTICULOS +"="+id,null)>0;
    }
    public Cursor getAllArticulos(){
        return sqLiteDatabase.query(TABLE_ARTICULOS,new String[]{ID_ARTICULOS, NAME_ARTICULOS, PRECIO,PASSWORD,PHOTO},null,null,null,null,null);
    }
    public Cursor getChatMessages(String name)throws SQLException{
        Cursor cursor;

        cursor = this.sqLiteDatabase.query(true,TABLE_ARTICULOS,new String[]{ID_ARTICULOS, NAME_ARTICULOS, PRECIO,PASSWORD,PHOTO}, "(" + NAME_ARTICULOS + " like '%" + name + "%' OR " + NAME_ARTICULOS + " like '%" + "j" + "%')", null, null, null, null,null );
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;}
    public Cursor getArticulo(long rowID)throws SQLException{

        Cursor cursor=sqLiteDatabase.query(true,TABLE_ARTICULOS,new String[]{ID_ARTICULOS, NAME_ARTICULOS, PRECIO,PASSWORD,PHOTO}, ID_ARTICULOS +"="+rowID,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;

    }
    public boolean updateArticulo(long rowId,String name,String email,String password,String foto){
        ContentValues args=new ContentValues();
        args.put(NAME_ARTICULOS,name);
        args.put(PHOTO,foto);
        args.put(PRECIO,email);
        args.put(PASSWORD,password);
        return sqLiteDatabase.update(TABLE_ARTICULOS,args, ID_ARTICULOS +"="+rowId,null)>0;
    }
    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    /**
     * get datetime
     * */
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
