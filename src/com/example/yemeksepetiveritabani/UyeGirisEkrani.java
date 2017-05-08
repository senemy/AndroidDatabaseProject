package com.example.yemeksepetiveritabani;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class UyeGirisEkrani extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uye_giris_ekrani);
	}
	
public void FastFood(View v) {
		
		Intent sy = new Intent(this, Fastfoodlar.class);
		startActivity(sy);
		
	}

public void Pizza(View v) {
	
	Intent sy1 = new Intent(this, Pizzalar.class);
	startActivity(sy1);
	
}

public void Spaghetti(View v) {
	
	Intent sy2 = new Intent(this, Spaghettiler.class);
	startActivity(sy2);
	
}

public void cikis(View v){
	
	Intent sy = new Intent(this, YemekSepetiVeritabaniActivity.class);
	startActivity(sy);
	
}

public void Sepet(View v) {
	
	Intent sy3 = new Intent(this, Sepetim.class);
	startActivity(sy3);
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uye_giris_ekrani, menu);
		return true;
	}

}
