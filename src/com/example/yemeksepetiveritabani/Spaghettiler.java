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
import android.widget.TextView;
import android.widget.Toast;

public class Spaghettiler extends Activity {
	
	ImageButton sbt1;
	ImageButton sbt2;
	ImageButton sbt3;
	EditText sadet1;
	EditText sadet2;
	EditText sadet3;
	
	 DataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spaghettiler);
		
	    loginDataBaseAdapter=new DataBaseAdapter(this);
	    loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		sbt1 = (ImageButton)findViewById(R.id.imageButtonS1);
		sbt2 = (ImageButton)findViewById(R.id.imageButtonS2);
		sbt3 = (ImageButton)findViewById(R.id.imageButtonS3);
		
		sadet1 = (EditText)findViewById(R.id.editTextS1);
		sadet2 = (EditText)findViewById(R.id.editTextS2);
		sadet3 = (EditText)findViewById(R.id.editTextS3);
	    
	    sbt1.setOnClickListener(new OnClickListener() {
			 
			@Override
			
			public void onClick(View v) {
				
				if (sadet1.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis + "\n"+ (sadet1.getText()).toString() + " adet " + Sepetim.isimler[6].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[6])) * Integer.valueOf(sadet1.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				}
			}
 
		});
	    
	    sbt2.setOnClickListener(new OnClickListener() {
			 
			@Override
			
			public void onClick(View v) {
				
				if (sadet2.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis + "\n"+ (sadet2.getText()).toString() + " adet " + Sepetim.isimler[7].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[7])) * Integer.valueOf(sadet2.getText().toString()));
				
				Toast.makeText(getApplicationContext(),"Sepete eklendi.", Toast.LENGTH_SHORT).show();
				}
			}
 
		});
	    
	    sbt3.setOnClickListener(new OnClickListener() {
			 
			@Override
			
			public void onClick(View v) {
				
				if (sadet3.getText().toString().trim().equals("")==true){
					
					Toast.makeText(getApplicationContext(),"Ýstediðiniz ürünün adetini giriniz.", Toast.LENGTH_SHORT).show();
					
				}else{
				
				Sepetim.siparis = Sepetim.siparis + "\n"+ (sadet3.getText()).toString() + " adet " + Sepetim.isimler[8].toString();
				Sepetim.toplam=Sepetim.toplam + (Integer.valueOf(loginDataBaseAdapter.urunFiyati(Sepetim.isimler[8])) * Integer.valueOf(sadet3.getText().toString()));
				
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
	
		getMenuInflater().inflate(R.menu.spaghetti, menu);
		return true;
	}

}
