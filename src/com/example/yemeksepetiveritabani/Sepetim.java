package com.example.yemeksepetiveritabani;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sepetim extends Activity {
	
	DataBaseAdapter loginDataBaseAdapter;
	
	public static EditText sepet;
	public static EditText hesap;
	
	public static String siparis="";
	public static int toplam = 0;
	
	public static String [] isimler = { "Chicken Tendergrill","Steak House", "Chicken Burger",
										"Pizza Konyalim", "Pizza Italiano","Pizza Bol Malzeme", 
										"Spaghetti Bolognese","Spaghetti Carbonara", "Spaghetti Napolitan"};
	
	public static int [] fiyatlar = {10, 12, 8, 15, 16, 18,10, 8, 8};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sepetim);
		
		loginDataBaseAdapter=new DataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		sepet =(EditText) findViewById(R.id.editTextSiparis);
		hesap =(EditText) findViewById(R.id.editText2);
		
		sepet.setText(siparis);	
		hesap.setText(String.valueOf(toplam));
	}
	
	public void siparisVer(View v){		
		
		String toplam2 = hesap.getText().toString();
		
		loginDataBaseAdapter.getSiparis(siparis, toplam2);
		
		Toast.makeText(getApplicationContext(),"Sipariþ verildi.", Toast.LENGTH_SHORT).show();
		
		sepet.setText("");
		hesap.setText("");
		
	}
	
	public void vazgec(View v){
		
		sepet.setText("");
		hesap.setText("");
		
	}
	
	public void cikis(View v){
		
		Intent sy = new Intent(this, YemekSepetiVeritabaniActivity.class);
		startActivity(sy);
		
	}
	
public void anaMenu(View v) {
		
		Intent sy = new Intent(this, UyeGirisEkrani.class);
		startActivity(sy);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.sepetim, menu);
		return true;
	}

}
