package com.example.yemeksepetiveritabani;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Pizzalar extends Activity {
	
	ImageButton pbt1;
	ImageButton pbt2;
	ImageButton pbt3;
	EditText padet1;
	EditText padet2;
	EditText padet3;
	
	DataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pizzalar);
		
		loginDataBaseAdapter=new DataBaseAdapter(this);
	    loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		pbt1 = (ImageButton)findViewById(R.id.imageButtonP1);
		pbt2 = (ImageButton)findViewById(R.id.imageButtonP2);
		pbt3 = (ImageButton)findViewById(R.id.imageButtonP3);
		
		padet1 = (EditText)findViewById(R.id.editTextP1);
		padet2 = (EditText)findViewById(R.id.editTextP2);
		padet3 = (EditText)findViewById(R.id.editTextP3);
		
		pbt1.setOnClickListener(new OnClickListener() {
			
			 
			@Override
			public void onClick(View arg0) {
				
				if (padet1.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis +"\n"+ (padet1.getText()).toString() + " adet " + Sepetim.isimler[3].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[3])) * Integer.valueOf(padet1.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				
			}
			}
 
		});
		
		pbt2.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				if (padet2.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis + "\n"+(padet2.getText()).toString() + " adet " + Sepetim.isimler[4].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[4])) * Integer.valueOf(padet2.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				
			}
			}
 
		});
		
		pbt3.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				if (padet3.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis +"\n"+ (padet3.getText()).toString() + " adet " + Sepetim.isimler[5].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[5])) * Integer.valueOf(padet3.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				
			}
			}
 
		});

	}
	
public void anaMenu(View v) {
		
		Intent sy = new Intent(this, UyeGirisEkrani.class);
		startActivity(sy);
		
	}

public void Sepet(View v) {
	
	Intent sy3 = new Intent(this, Sepetim.class);
	startActivity(sy3);
	
}

public void cikis(View v){
	
	Intent sy = new Intent(this, YemekSepetiVeritabaniActivity.class);
	startActivity(sy);
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		getMenuInflater().inflate(R.menu.pizzalar, menu);
		return true;
	}

}
