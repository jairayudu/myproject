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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class User_view extends Activity implements OnClickListener, OnItemSelectedListener {
	
	
	Button submit;
	String Text;
	private SQLiteHelper SQLHelper;
	//private int spinner1,spinner2;
	
	Spinner sp;
	Spinner spinnerColorChange;
	
	String []dept = new String[] { "surgeon","dental","chemical","nuro","child","ENT","heart specialist","eye specialist" };

	
	
	String si;
	static String sk;
	ListView lv ;
	ArrayList<String[]> DATA = new ArrayList<String[]>();
	
	EditText ed1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_view);
		submit=(Button)findViewById(R.id.button1);
		submit.setOnClickListener(this);
		
		ed1=(EditText) findViewById(R.id.editText1);
		spinnerColorChange = (Spinner)findViewById(R.id.spinner1);
		
		/*String name=ed1.getText().toString();
		 * 
		 * 
		
		Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();*/
		
		sp=(Spinner)findViewById(R.id.spinner2);
		sp.setOnItemSelectedListener(this);  
		
		
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
				 this,R.layout.custom_textview_to_spinner,dept );
				 
				 spinnerArrayAdapter.setDropDownViewResource(R.layout.custom_textview_to_spinner);
		
		  /*ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.custom_textview_to_spinner,dept);  
	        aa.setDropDownViewResource(android.R.layout.custom_textview_to_spinner); */
	        spinnerColorChange.setAdapter(spinnerArrayAdapter);
	        //Setting the ArrayAdapter data on the Spinner  
	        sp.setAdapter(spinnerArrayAdapter);  
	 
		
		
		SQLHelper = new SQLiteHelper(this);  
		
		
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
	
	 public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {  
		 
		 Text = sp.getSelectedItem().toString();
	        Toast.makeText(getApplicationContext(),Text ,Toast.LENGTH_LONG).show();  
	    }  
	
	    public void onNothingSelected(AdapterView<?> arg0) {  
	        // TODO Auto-generated method stub  
	          
	    }  


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		
		
		case R.id.button1:
			String sk=sp.getSelectedItem().toString();
			
			Toast.makeText(getApplicationContext(),sk,Toast.LENGTH_SHORT).show();
			
			String smf2=sk;
			
			//Toast.makeText(this, smf, 10).show();	
			DATA=SQLHelper.selectalldatabase5(smf2);
		     if(!DATA.isEmpty())
		    	 lv.setAdapter(new MyCustomBaseAdapter2(this, DATA));
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
		             TextView tv1=(TextView)v.findViewById(R.id.textView1);
		             TextView tv=(TextView)v.findViewById(R.id.textView2);
		             TextView tv2=(TextView)v.findViewById(R.id.textView3);
		             TextView tv3=(TextView)v.findViewById(R.id.TextView01);
		             TextView tv4=(TextView)v.findViewById(R.id.TextView02);
		             TextView tv5=(TextView)v.findViewById(R.id.TextView03);
		             TextView tv6=(TextView)v.findViewById(R.id.TextView04);
		           
		             
		             
		             String ad=tv1.getText().toString();
		             String n=tv.getText().toString();
		            String ph= tv2.getText().toString();
		            String ph1= tv3.getText().toString();
		            String ph2= tv4.getText().toString();
		            String ph3= tv5.getText().toString();
		            String ph4= tv6.getText().toString();
		            String sk=sp.getSelectedItem().toString();
		         	
//		            Intent i = new Intent(Doctor_view.this, Doc_det.class);
		        Intent i=new Intent(User_view.this,Doc_appoint.class); 	
		         	i.putExtra("address", ad);
		         	i.putExtra("name", n);
		         	i.putExtra("phone", ph);
		        	i.putExtra("phone1", ph1);
		        	i.putExtra("phone2", ph2);
		        	i.putExtra("phone3", ph3);
		        	i.putExtra("phone4", ph4);
		        	i.putExtra("sk1", sk);
		        	//i.putExtra("Text",Text);
		        	
		         
		         	startActivity(i);
		         
		             
		           
		         }
			});
		
		
	}
	
	
	
	
	
}

