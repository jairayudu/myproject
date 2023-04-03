package com.example.hospital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pat_login extends Activity {
	EditText e1,e2;
	Button b1,b2,b3;
	SQLiteHelper sqhospital;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pat_login);
		sqhospital=new SQLiteHelper(this);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name=e1.getText().toString();
				String password=e2.getText().toString();
				String g=sqhospital.loginData4(name, password);
				if(g.equals("ok")){
					Toast.makeText(getApplicationContext(), "login successfully",Toast.LENGTH_SHORT).show();
				Intent In=new Intent(Pat_login.this,User_view.class);
				startActivity(In);
			}
				else{
					Toast.makeText(getApplicationContext(), "login failed",Toast.LENGTH_SHORT).show();	
				}
					}
		});
		b2=(Button)findViewById(R.id.button2);
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent In=new Intent(Pat_login.this,Pat_register.class);
				startActivity(In);
			}
		});
		b3=(Button)findViewById(R.id.button3);
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent In=new Intent(Pat_login.this,Hospital_page.class);
				startActivity(In);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.doc_login, menu);
		return true;
	}

}

