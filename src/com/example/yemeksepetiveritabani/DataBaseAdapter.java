package com.example.yemeksepetiveritabani;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.widget.Toast;
 
public class DataBaseAdapter 
{
        static final String DATABASE_NAME = "YemekSepeti";
        static final int DATABASE_VERSION = 1;
        public static final int NAME_COLUMN = 1;

        static final String uyeler = "create table uyelerim (USERNAME  text,PASSWORD text); ";
        static final String siparisler = "create table siparislerim (SIPARIS text,TOPLAM text,TARIH text); ";
        static final String urunler = "create table urunlerim (URUN text,FIYAT text); ";
 
        public static  SQLiteDatabase db;
        private final Context context;
        private DataBaseHelper dbHelper;
        
        public  DataBaseAdapter(Context _context) 
        {
            context = _context;
            dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public  DataBaseAdapter open() throws SQLException 
        {
            db = dbHelper.getWritableDatabase();
            return this;
        }
        public void close() 
        {
            db.close();
        }
 
        public  SQLiteDatabase getDatabaseInstance()
        {
            return db;
        }

 
        public void insertEntry(String userName,String password)
        {
           ContentValues newValues = new ContentValues();           
        
            newValues.put("USERNAME", userName);
            newValues.put("PASSWORD",password);
 
            db.insert("uyelerim", null, newValues);
            Toast.makeText(context, "Üye oldunuz.\nLütfen giriþ yapýnýz.", Toast.LENGTH_LONG).show();
        }
        
        public String getSingleEntry(String userName)
        {
        	
           Cursor cursor=db.query("uyelerim", null, " USERNAME=?",new String[]{userName}, null,null,null);
           if(cursor.getCount()<1) 
           {
               cursor.close();
               return "NOT EXIST";
           }
           cursor.moveToFirst();
           String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
           cursor.close();
           return password;       
        }
        
        public String urunFiyati(String urun)
        {
        	
           Cursor cursor=db.query("urunlerim", null, " URUN=?",new String[]{urun}, null,null,null);
           cursor.moveToFirst();
           String fiyat= cursor.getString(cursor.getColumnIndex("FIYAT"));
           cursor.close();
           return fiyat;       
        }
       
        public void getSiparis(String siparis, String toplam){
  	      
        	Date now = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");   		
    	    String strTime = sdf.format(now);
        	     	
        	ContentValues newValues3 = new ContentValues();

            newValues3.put("SIPARIS",siparis);
            newValues3.put("TOPLAM",toplam + " TL");
            newValues3.put("TARIH", strTime);

            try {
            	
            db.insert("siparislerim",null,newValues3);
            
            }catch(Exception ex){
            	
            Toast.makeText(context, "Baþarýsýz iþlem.", Toast.LENGTH_LONG).show();
            
            }
        }
}