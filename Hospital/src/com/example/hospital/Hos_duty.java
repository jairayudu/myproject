package com.example.hospital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Hos_duty extends Activity {
	EditText e1,e2,e3,e4,e5,e6,e7;
	TextView t1,t2,t3,t4;
	Button b1;
	SQLiteHelper sqhospital;
	
	String a,b,c,d;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hos_duty);
		sqhospital=new SQLiteHelper(this);
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		t4=(TextView)findViewById(R.id.textView4);
		e5=(EditText)findViewById(R.id.editText5);
		e6=(EditText)findViewById(R.id.editText6);
		e7=(EditText)findViewById(R.id.editText7);
		
		b1=(Button)findViewById(R.id.button1);
		
		
		Intent in=getIntent();
		
		a=in.getStringExtra("address");
		b=in.getStringExtra("name");
		c=in.getStringExtra("phone");
		d=in.getStringExtra("phone1");
		
		t1.setText(a);
		t2.setText(b);
		t3.setText(c);
		t4.setText(d);
		
b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String id=t1.getText().toString();
				String name=t2.getText().toString();
				String place=t3.getText().toString();
				String spec=t4.getText().toString();
				String time=e5.getText().toString();
				String dur=e6.getText().toString();
				String date=e7.getText().toString();
				String doc=t2.getText().toString();
				int r=sqhospital.insertData7(id,name,  place ,  spec,
						 time, dur, date, doc );
				Toast.makeText(getApplicationContext(), "registered successfully",Toast.LENGTH_SHORT).show();
				Intent In=new Intent(Hos_duty.this,Hos_main.class);
				startActivity(In);
			}
		});
		
				
		
		
	}
		


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hos_duty, menu);
		return true;
	}

}
