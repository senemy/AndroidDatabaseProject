package com.example.yemeksepetiveritabani;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class UyeEkleme extends Activity
{
    EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    Button btnCreateAccount;
 
    DataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ekleme);
 
        loginDataBaseAdapter=new DataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        editTextUserName=(EditText)findViewById(R.id.editTextUe1);
        editTextPassword=(EditText)findViewById(R.id.editTextUe2);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextUe3);
 
        btnCreateAccount=(Button)findViewById(R.id.buttonUyeOl);
        
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
 
        public void onClick(View v) {
            // TODO Auto-generated method stub
 
            String userName=editTextUserName.getText().toString();
            String password=editTextPassword.getText().toString();
            String confirmPassword=editTextConfirmPassword.getText().toString();
 
            if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
            {
                    Toast.makeText(getApplicationContext(), "Boþ alan býrakmayýnýz.", Toast.LENGTH_LONG).show();
                    return;
            }
     
            if(!password.equals(confirmPassword))
            {
                Toast.makeText(getApplicationContext(), "Hatalý parola tekrarý.", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
              
                loginDataBaseAdapter.insertEntry(userName, password);
                
            }
        }
    });
}
    
    public void geriGit(View v) {
    	
    	Intent sy3 = new Intent(this, YemekSepetiVeritabaniActivity.class);
    	startActivity(sy3);
    	
    }
    
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
 
        loginDataBaseAdapter.close();
    }
}