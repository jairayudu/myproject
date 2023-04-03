package com.example.hospital;

import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class New_doctor extends Activity implements 
AdapterView.OnItemSelectedListener {
	EditText e1,e2,e3,e4,e5,e6,e8;
	Button b1,b3;
	TextView e7;
	Spinner spin;
	int i;
	
		String[] country = { "surgeon", "dental", "ENT", "eye_specialist", "nuro","nepro","skin","baby"  };
	SQLiteHelper sqhospital;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_doctor);
		
		Spinner spin = (Spinner) findViewById(R.id.spinner1);
		spin.setOnItemSelectedListener((OnItemSelectedListener) this);
		ArrayAdapter<Object> aa = new ArrayAdapter<Object>(this,android.R.layout.simple_spinner_item,country);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(aa);		
	
					 
		sqhospital=new SQLiteHelper(this);
		
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		e5=(EditText)findViewById(R.id.editText5);
		e6=(EditText)findViewById(R.id.editText6);
		e7=(TextView)findViewById(R.id.editText7);
		//e8=(EditText)findViewById(R.id.editText8);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String id=e6.getText().toString();
				String name=e2.getText().toString();
				String mail=e7.getText().toString();
				String mob=e4.getText().toString();
				String place=e5.getText().toString();
				String qual=e1.getText().toString();
				String dq = country[i];
				//String spec=e8.getText().toString();
				int r=sqhospital.insertData1(id,name,mail,mob,place,qual,dq);
				Toast.makeText(getApplicationContext(), "registered successfully",Toast.LENGTH_SHORT).show();
				Intent In=new Intent(New_doctor.this,Hos_main.class);
				startActivity(In);
			}
		});
		b3=(Button)findViewById(R.id.button3);
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent In=new Intent(New_doctor.this,Hospital_page.class);
				startActivity(In);
			}
		});	
			}
			
 


		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_doctor, menu);
		return true;
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
		Toast.makeText(getApplicationContext(),country[position] ,Toast.LENGTH_LONG).show();
		i = position;
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub	
		Toast.makeText(getApplicationContext(),"count" ,Toast.LENGTH_LONG).show();
	}
}
 
 