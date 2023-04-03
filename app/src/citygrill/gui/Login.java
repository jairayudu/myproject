package citygrill.gui;






import com.order.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
	private SQLiteHelper SQLHelper;
	EditText nameET,emailET,passwordET;
	Button login,register,delete;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SQLHelper = new SQLiteHelper(this);  
		emailET=(EditText)findViewById(R.id.editText1);
        passwordET=(EditText)findViewById(R.id.editText2);
	//Button login;
	
        login=(Button)findViewById(R.id.button1);
        login.setOnClickListener(this);
        register=(Button)findViewById(R.id.button2);
        register.setOnClickListener(this);
        delete=(Button)findViewById(R.id.button3);
        delete.setOnClickListener(this);
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
			String h=null;
			String g=null;
			
			 h=emailET.getText().toString();
			 g=passwordET.getText().toString();
			 
			 
			 
			if(h.equals(""))
			{
				Toast.makeText(this, "Enter Your EmailID ", 10).show();	
			}
			else if(g.equals(""))
			{
				Toast.makeText(this, "Enter Your Password", 10).show();	
			}
			
			else
			
			{
			 
			 
				String sss=SQLHelper.loginData1(h,g);
				
				if(sss.equals("fail"))
				{
					Toast.makeText(this, sss, 10).show();
				}else
				{
					
					Intent i = new Intent(Login.this,
							MainActivity.class);
					startActivity(i);
					
				}
			
			}
			break;
		case R.id.button2:
			Intent i = new Intent(Login.this,
					RegisterActivity.class);
			startActivity(i);
		break;
		case R.id.button3:
			//SQLHelper.deleteAll();
			
			break;
		
		}
		}
		}
