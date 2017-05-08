package com.example.yemeksepetiveritabani;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Fastfoodlar extends Activity {
	
	ImageButton ffbt1;
	ImageButton ffbt2;
	ImageButton ffbt3;
	EditText ffadet1;
	EditText ffadet2;
	EditText ffadet3;
	
	 DataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fastfoodlar);
		
		ffbt1 = (ImageButton)findViewById(R.id.imageButtonFF1);
		ffbt2 = (ImageButton)findViewById(R.id.imageButtonFF2);
		ffbt3 = (ImageButton)findViewById(R.id.imageButtonFF3);
		
		ffadet1 = (EditText)findViewById(R.id.editTextFF1);
		ffadet2 = (EditText)findViewById(R.id.editTextFF2);
		ffadet3 = (EditText)findViewById(R.id.editTextFF3);
		
		loginDataBaseAdapter=new DataBaseAdapter(this);
	    loginDataBaseAdapter=loginDataBaseAdapter.open();
	    
	    
	    ffbt1.setOnClickListener(new OnClickListener() {
			 
			@Override
			
			public void onClick(View v) {
				
				if (ffadet1.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis + "\n"+ (ffadet1.getText()).toString() + " adet " + Sepetim.isimler[0].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[0])) * Integer.valueOf(ffadet1.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				}
			}
 
		});
	    
	    ffbt2.setOnClickListener(new OnClickListener() {
			 
			@Override
			
			public void onClick(View v) {
				
				if (ffadet2.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis + "\n"+ (ffadet2.getText()).toString() + " adet " + Sepetim.isimler[1].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[1])) * Integer.valueOf(ffadet2.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				}
			}
 
		});
	    
	    ffbt3.setOnClickListener(new OnClickListener() {
			 
			@Override
			
			public void onClick(View v) {
				
				if (ffadet3.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis + "\n"+ (ffadet3.getText()).toString() + " adet " + Sepetim.isimler[2].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[2])) * Integer.valueOf(ffadet3.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				}
			}
 
		});
		
	}
	
public void cikis(View v){
		
		Intent sy = new Intent(this, YemekSepetiVeritabaniActivity.class);
		startActivity(sy);
		
	}
	
	
	public void anaMenu(View v) {
		
		Intent sy3 = new Intent(this, UyeGirisEkrani.class);
		startActivity(sy3);
		
	}

	public void Sepet(View v) {
		
		Intent sy3 = new Intent(this, Sepetim.class);
		startActivity(sy3);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		getMenuInflater().inflate(R.menu.fastfoodlar, menu);
		return true;
	}

}
