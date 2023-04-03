package com.example.hospital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Doc_det extends Activity {
	EditText e1,e2,e3,e4,e5,e6;
	Button b1;
	SQLiteHelper sqhospital;
	
	String a,b,c,d,e,f;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doc_det);
		sqhospital=new SQLiteHelper(this);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		e5=(EditText)findViewById(R.id.editText5);
		e6=(EditText)findViewById(R.id.editText6);
		
		
		b1=(Button)findViewById(R.id.button1);
		
		
		Intent in=getIntent();
		
		a=in.getStringExtra("address");
		b=in.getStringExtra("name");
		c=in.getStringExtra("phone");
		d=in.getStringExtra("phone1");
		e=in.getStringExtra("phone2");
		f=in.getStringExtra("phone3");
		
		e1.setText(f);
		e2.setText(a);
		e3.setText(b);
		e4.setText(c);
		e5.setText(a);
		e6.setText(d);
		
/*b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String id=e1.getText().toString();
				String name=e2.getText().toString();
				String place=e3.getText().toString();
				String spec=e4.getText().toString();
				String time=e5.getText().toString();
				String dur=e6.getText().toString();
				String date=e7.getText().toString();
				String doc=e2.getText().toString();
				int r=sqhospital.insertData7(id,name,  place ,  spec,
						 time, dur, date, doc );
				Toast.makeText(getApplicationContext(), "registered successfully",Toast.LENGTH_SHORT).show();
				Intent In=new Intent(Dc.this,Hos_main.class);
				startActivity(In);
			}
		});*/
		
				
		
		
	}
		


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hos_duty, menu);
		return true;
	}

}