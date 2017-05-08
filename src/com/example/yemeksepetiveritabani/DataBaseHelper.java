package com.example.yemeksepetiveritabani;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class DataBaseHelper extends SQLiteOpenHelper
{
	
    public DataBaseHelper(Context context, String name,CursorFactory factory, int version) 
    {
               
    	super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase _db) 
    {
    	
            _db.execSQL(DataBaseAdapter.uyeler);
            _db.execSQL(DataBaseAdapter.siparisler);
            _db.execSQL(DataBaseAdapter.urunler);

    }

    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) 
    {
           
    	_db.execSQL("DROP TABLE IF EXIST uyelerim");
        _db.execSQL("DROP TABLE IF EXIST siparislerim");
        _db.execSQL("DROP TABLE IF EXIST urunlerim");
        onCreate(_db);
    	

    }
 
}