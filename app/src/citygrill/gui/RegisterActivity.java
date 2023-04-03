package citygrill.gui;





import com.order.R;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity  extends Activity  implements OnClickListener{

	
	private SQLiteHelper SQLHelper;
	Button insert,delete;
	EditText nameET,emailET,passwordET,addressET;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registeractivity);
		
		 SQLHelper = new SQLiteHelper(this);    
	        nameET=(EditText)findViewById(R.id.editText1);
	        emailET=(EditText)findViewById(R.id.editText2);
	        passwordET=(EditText)findViewById(R.id.editText3);
	        addressET=(EditText)findViewById(R.id.editText4);
	        insert=(Button)findViewById(R.id.button1);
	        insert.setOnClickListener(this);
	        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.button1:
			
			 String w=emailET.getText().toString();
			 String j=nameET.getText().toString();
			 String k=passwordET.getText().toString();
			 String m=addressET.getText().toString();
			if(w.equals(""))
			{
				Toast.makeText(this, "Enter email id", 10).show();	
			}
			else if(j.equals(""))
			{
				Toast.makeText(this, "Enter name", 10).show();	
			}
			else if(k.equals(""))
			{
				Toast.makeText(this, "Enter Password", 10).show();		
			}
			else if(w.equals(""))
			{
				Toast.makeText(this, "Enter address", 10).show();		
			}
			else
			
			{
			
			
		if(SQLHelper.insertData(nameET.getText().toString(),passwordET.getText().toString(),addressET.getText().toString(),emailET.getText().toString())<0){
			
			Toast.makeText(this, "Failed Insert data", 10).show();
		}else{
			Intent i = new Intent(RegisterActivity.this,
					Login.class);
			startActivity(i);
		Toast.makeText(this, "Successfully Inserted", 10).show();
		}
		}
		break;
		
		
	}
	}
}
