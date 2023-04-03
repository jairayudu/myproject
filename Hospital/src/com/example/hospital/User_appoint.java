package com.example.hospital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
 
public class User_appoint extends Activity {
	EditText e1,e2,e3,e4,e5,e6;
	TextView t4,t6;
	Button b1;
	RadioGroup rg;
	
	int pos;
	String s1,s8;
	
	int pos1;
	
	TextView t1;
	SQLiteHelper sqhospital;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_appoint);
        sqhospital=new SQLiteHelper(this);
        e1=(EditText)findViewById(R.id.editText1);
        t1=(TextView)findViewById(R.id.textView1);
       
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		t4=(TextView)findViewById(R.id.textView2);
		e5=(EditText)findViewById(R.id.editText5);
		t6=(TextView)findViewById(R.id.textView3);
		b1=(Button)findViewById(R.id.button1);
		Intent In=getIntent();
		s1=In.getStringExtra("address");
		t4.setText(s1);
		Intent In1=getIntent();
		s8=In1.getStringExtra("sk1");
		t6.setText(s8);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String name=e1.getText().toString();
				String gender=t1.getText().toString();
				String dob=e2.getText().toString();
				String prob=e3.getText().toString();
				String doc_name=t4.getText().toString();
				String doc_spec=t6.getText().toString();
				String app_date=e5.getText().toString();
				int r=sqhospital.insertData11(name, gender, dob, prob, doc_name,doc_spec, app_date);
				
				Toast.makeText(getApplicationContext(), "registered successfully",Toast.LENGTH_SHORT).show();
				Intent In1=new Intent(User_appoint.this,Hospital_page.class);
				startActivity(In1);
			}
		});
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        
        t1=(TextView)findViewById(R.id.textView1);
        
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			
			// Method 1 For Getting Index of RadioButton
			pos=rg.indexOfChild(findViewById(checkedId));

		    	
		    	//Method 2 For Getting Index of RadioButton
		   	pos1=rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));

		    	
		    	switch (pos)
		    	{
		    	case 0 :
				t1.setText("Male");
			    	break;
		    	case 1 :
		    		t1.setText("FeMale");
			    	break;
		    	case 2 :
		    		t1.setText("Others");
			    	break;
			default :
				//The default selection is RadioButton 1
				t1.setText("Male");
			    	break;
		    	}
		}
	});
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_appoint,menu);
        return true;
    }
}