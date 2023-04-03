package com.example.hospital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Doc_appoint extends Activity {
	
	TextView t1,t2,t3,t4,t5,t6,t8;
	String s1,s2,s3,s4,s5,s6,s7,s8;
	Button b1,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doc_appoint);
		
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		t4=(TextView)findViewById(R.id.textView4);
		t5=(TextView)findViewById(R.id.textView5);
		t6=(TextView)findViewById(R.id.textView6);
		
		t8=(TextView)findViewById(R.id.textView8);
		Intent in=getIntent();
		s1=in.getStringExtra("address");
		s2=in.getStringExtra("name");
		s3=in.getStringExtra("phone");
		s4=in.getStringExtra("phone1");
		s5=in.getStringExtra("phone2");
		s6=in.getStringExtra("phone3");
		s7=in.getStringExtra("sk1");
		s8=in.getStringExtra("sk1");
		
		t1.setText(s1);
		t2.setText(s2);
		t3.setText(s3);
		t4.setText(s4);
		t5.setText(s7);
		t6.setText(s6);
		
		t5.setText(s8);
		b3=(Button)findViewById(R.id.button3);
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent In=new Intent(Doc_appoint.this,Hospital_page.class);
				startActivity(In);
			}
		});
		
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent In=new Intent(Doc_appoint.this,User_appoint.class);
				In.putExtra("address",s1);
				In.putExtra("sk1",s8);
				startActivity(In);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.det, menu);
		return true;
	}

}
