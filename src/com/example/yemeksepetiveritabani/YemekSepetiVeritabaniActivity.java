package com.example.yemeksepetiveritabani;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class YemekSepetiVeritabaniActivity extends Activity {

	DataBaseAdapter loginDataBaseAdapter;
	Button uyeGirisi,uyeOl;

	
	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yemek_sepeti_veritabani);
		
		loginDataBaseAdapter=new DataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		uyeGirisi = (Button)findViewById(R.id.buttonG1);	
		uyeOl = (Button)findViewById(R.id.buttonG3);
		
	}
	

public void uyeEkleme(View v) {
	
	Intent sy2 = new Intent(this, UyeEkleme.class);
	startActivity(sy2);
	
}

public void anaMenu(View v) {
	
	Intent sy4 = new Intent(this, UyeGirisEkrani.class);
	startActivity(sy4);
	
}

public void uyeGiris(View V)
{
     final Dialog dialog = new Dialog(YemekSepetiVeritabaniActivity.this);
     dialog.setContentView(R.layout.activity_uye_girisi);
     dialog.setTitle("Üye Giriþi");

     // get the Refferences of views
     final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUg1);
     final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextUg2);

     Button btnSignIn=(Button)dialog.findViewById(R.id.buttonUg);

     btnSignIn.setOnClickListener(new View.OnClickListener() {

         public void onClick(View v) {

             String userName=editTextUserName.getText().toString();
             String password=editTextPassword.getText().toString();
    
             String storedPassword=loginDataBaseAdapter.getSingleEntry(userName);
 
             if(password.equals(storedPassword))
             {
            	anaMenu(v);

             }
             else
             {
                 Toast.makeText(YemekSepetiVeritabaniActivity.this, "Kullanýcý adý veye parola hatalý.", Toast.LENGTH_LONG).show();
             }
 
         }
     });

     dialog.show();
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.yemek_sepeti_veritabani, menu);
		return true;
	}

}
