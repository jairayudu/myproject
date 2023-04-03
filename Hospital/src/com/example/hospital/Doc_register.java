package com.example.hospital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Doc_register extends Activity {
	EditText e1,e2,e3,e4,e5;
	Button b1;
	
	SQLiteHelper sqhospital;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doc_register);
		sqhospital=new SQLiteHelper(this);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		e5=(EditText)findViewById(R.id.editText5);
		
		
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String name=e1.getText().toString();
				String password=e2.getText().toString();
				String email=e3.getText().toString();
				String mobile=e4.getText().toString();
				String date=e5.getText().toString();
			
				
				
				
				
				int r=sqhospital.insertData3(name,password,email,mobile,date);
				Toast.makeText(getApplicationContext(), "registered successfully",Toast.LENGTH_SHORT).show();
				Intent In=new Intent(Doc_register.this,Doc_login.class);
				startActivity(In);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.doc_register, menu);
		return true;
	}

}
