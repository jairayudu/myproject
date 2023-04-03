package com.example.hospital;


import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Hos_user_view extends Activity {
	

	 private SQLiteHelper SQLHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hos_user_view);
		
		 ArrayList<String[]> DATA = new ArrayList<String[]>();
	        ListView lv ;
	        SQLHelper = new SQLiteHelper(this);
	        lv=(ListView)findViewById(R.id.listView1);

	        DATA=SQLHelper.selectalldatabase();
	        if(!DATA.isEmpty())
	            lv.setAdapter(new MyCustomBaseAdapter(this, DATA));
	      lv.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
	            {
	                // position parameter gives the index or position of ListView Item which is Clicked
	       
	            	 TextView tv=(TextView)v.findViewById(R.id.textView5);
		                TextView tv1=(TextView)v.findViewById(R.id.textView2);
		                TextView tv2=(TextView)v.findViewById(R.id.textView3);
		                TextView tv3=(TextView)v.findViewById(R.id.textView4);
		               TextView tv4=(TextView)v.findViewById(R.id.textView1);
		                TextView tv5=(TextView)v.findViewById(R.id.textView6);

		             
		                String n=tv.getText().toString();
		                String n1=tv1.getText().toString();
		                String n2=tv2.getText().toString();
		                String n3=tv3.getText().toString();
		               String n4=tv4.getText().toString();
		                String n5=tv5.getText().toString();
		               

		                Intent i = new Intent(Hos_user_view.this,Hos_side_view.class);

		              
		                i.putExtra("name", n);
		                i.putExtra("name1", n1);
		                i.putExtra("name2", n2);
		                i.putExtra("name3", n3);
		                i.putExtra("name4", n4);
		                i.putExtra("name5", n5);

		                startActivity(i);

	            }
	        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hos_user_view, menu);
		return true;
	}

}
