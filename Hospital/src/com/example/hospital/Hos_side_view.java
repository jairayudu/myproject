package com.example.hospital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Hos_side_view extends Activity {
	
	TextView t1,t2,t3,t4,t5,t6;
	String a1=null;
	String a2=null;
	String a3=null;
	String a4=null;
	String a5=null;
	String a6=null;
	Button edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hos_side_view);
		
		edit=(Button)findViewById(R.id.button1);
		
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		t4=(TextView)findViewById(R.id.textView4);
		t5=(TextView)findViewById(R.id.textView5);
		t6=(TextView)findViewById(R.id.textView6);
		
		

		Intent i=getIntent();
		
	
		a1=i.getStringExtra("name");
		a2=i.getStringExtra("name1");
		a3=i.getStringExtra("name2");
		a4=i.getStringExtra("name3");
		a5=i.getStringExtra("name4");
		a6=i.getStringExtra("name5");
		
		
		t1.setText(a5);
		t2.setText(a6);
		t3.setText(a4);
		t4.setText(a2);
		t5.setText(a3);
		t6.setText(a1);
		
		
		edit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Hos_side_view.this,Hos_main.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hos_side_view, menu);
		return true;
	}

}