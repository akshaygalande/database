package admin.comlab.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by Admin on 22-03-2018.
 */

public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="Student";
    public static final String COL1="ID";
    public static final String COL2="NAME";



    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Student(ID Integer primary key AUTOINCREMENT , NAME Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insert(String name){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(COL2,name);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,c);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor show(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor c;
        c = sqLiteDatabase.rawQuery("SELECT * FROM Student",null);
        return c;
    }
    public boolean update(String id , String name){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(COL2,name);
        long result = sqLiteDatabase.update(TABLE_NAME,c,"ID = ?",new String[]{id});
        if(result==-1){
            return false;
        }
        else{
            return true;
        }

    }
    public void delete(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM Student where ID="+"'"+id+"'");
    }
}
