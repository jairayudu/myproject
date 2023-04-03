package com.example.hospital;

import java.util.ArrayList;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DocList extends Activity implements OnClickListener {
	
	
	Button submit;
	private SQLiteHelper sqhospital;
	//private int spinner1,spinner2;
	
	
	String si,sk;
	ListView lv ;
	ArrayList<String[]> DATA = new ArrayList<String[]>();
	
	TextView ed1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doc_list);
		submit=(Button)findViewById(R.id.button1);
		submit.setOnClickListener(this);
		
		ed1=(TextView) findViewById(R.id.editText1);
		
		/*String name=ed1.getText().toString();
		
		Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();*/
		
		sqhospital = new SQLiteHelper(this);  
		
		
		 lv = (ListView) findViewById(R.id.listView1);
		 
		 
		 
		/*String[] s = new String[] { "ravi", "mohan", "lijith" };
		
final Spinner sp1 = (Spinner) findViewById(R.id.spinner1);	
	
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, s);
sp1.setAdapter(adapter);

sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		sk=sp1.getSelectedItem().toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	
	}
});



*/

	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		
		
		case R.id.button1:
			String sk=ed1.getText().toString();
			
			Toast.makeText(getApplicationContext(),sk,Toast.LENGTH_SHORT).show();
			
			String smf=sk;
			
			//Toast.makeText(this, smf, 10).show();	
			DATA=sqhospital.selectalldatabase2(smf);
		     if(!DATA.isEmpty())
		    	 lv.setAdapter(new MyCustomBaseAdapter3(this, DATA));
			break;
		}
		
		
		ArrayList<String[]> DATA = new ArrayList<String[]>();
		//ListView lv ;
		 // SQLHelper = new SQLiteHelper(this); 
		//lv=(ListView)findViewById(R.id.listView1);
		/*String smf=sk;
		DATA=SQLHelper.selectalldatabase1(smf);
		 if(!DATA.isEmpty())
	    	 lv.setAdapter(new MyCustomBaseAdapter(this, DATA));*/
		   lv.setOnItemClickListener(new OnItemClickListener() {
		    	 public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
		         {
		             // position parameter gives the index or position of ListView Item which is Clicked
		             TextView tv1=(TextView)v.findViewById(R.id.TextView01);
		             TextView tv=(TextView)v.findViewById(R.id.textView1);
		             TextView tv2=(TextView)v.findViewById(R.id.textView3);
		             TextView tv3=(TextView)v.findViewById(R.id.TextView02);
		             
		             
		             String ad=tv1.getText().toString();
		             String n=tv.getText().toString();
		            String ph= tv2.getText().toString();
		            String ph1= tv3.getText().toString();
		           
		         	
		            Intent i = new Intent(DocList.this, Hos_duty.class);
		         	
		         	i.putExtra("address", ad);
		         	i.putExtra("name", n);
		         	i.putExtra("phone", ph);
		        	i.putExtra("phone1", ph1);
		        	
		         
		         
		         	startActivity(i);
		         
		             
		           
		         }
			});
		
		
	}
	
	
	
	
	
}
