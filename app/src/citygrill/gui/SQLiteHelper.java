package citygrill.gui;



import java.util.ArrayList;
import java.util.Calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper {
public static ArrayList<String[]> DATA = new ArrayList<String[]>();
private static final String DATABASE_NAME = "restaurant1.db";
private static final int DATABASE_VERSION = 3;
private static final String STUDENT_TABLE = "restauranttable";



private Context context;
private SQLiteDatabase db = null;


OpenHelper openHelper;

public SQLiteHelper(Context context) {
this.context = context;

if (db != null)
if (db.isOpen())
db.close();

openHelper = new OpenHelper(this.context);
this.db = openHelper.getWritableDatabase();
}

public void close() {
if (openHelper != null) {
openHelper.close();
}
}

public int insertData(String name, String email,String address,String password) {
int entryId = 0;
ContentValues values = new ContentValues();
values.put("name", name);
values.put("email", email);

values.put("address", address);
values.put("password", password);

entryId = (int) this.db.insert(STUDENT_TABLE, null, values);
return entryId;
}
/*
public void deleteAll() {
deleteTable(STUDENT_TABLE);
}
public void deleteTable(String tn) {
this.db.delete(tn, null, null);
}


*/

static class OpenHelper extends SQLiteOpenHelper {

OpenHelper(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}

@Override
public void onCreate(SQLiteDatabase db) {

db.execSQL("CREATE TABLE " + STUDENT_TABLE + "("
+ "id INTEGER PRIMARY KEY, " + "name TEXT, "
+ "password TEXT, "+"address TEXT, " + "email TEXT)");



}


@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
Log.w("Catch DB",
"Upgrading database, this will drop tables and recreate.");
db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);


onCreate(db);
}
}





public String loginData1(String h, String g) {
	// TODO Auto-generated method stub
	Cursor c1 = null;
	DATA.clear();
	String[] columns = new String[] {  "name" };
	
	c1 = db.query(STUDENT_TABLE, columns,"name=? AND password=?", new String[] {h,g}, null,null,null);
	if (c1.moveToNext()) {
	
	String n=c1.getString(0);
	return "true";
	}
	else
	{
		return "fail";
	}
	
}

public String insertData1(String dob, String j, String m,String ate1) {
	// TODO Auto-generated method stub
	int entryId = 0;
	ContentValues values = new ContentValues();
	values.put("datee", dob);
	values.put("expensed", j);

	values.put("amount", m);
	values.put("monthyear", ate1);
	
	return "success";
}

public String insertData2(String dob1, String j1, String m1) {
	// TODO Auto-generated method stub
	int entryId = 0;
	ContentValues values = new ContentValues();
	values.put("monthyear", dob1);
	values.put("incomeamt", j1);

	values.put("budgetamt", m1);
	
	return "success";
}

public String selectincome(String dob) {
	// TODO Auto-generated method stub
	Cursor c1 = null;
	String n=null;
	DATA.clear();
	String[] columns = new String[] {  "incomeamt" };
	

	if (c1.moveToNext()) {
	
	 n=c1.getString(0);
	
	}
	return n;
	
	
}

public String expenseincome(String dob) {
	// TODO Auto-generated method stub
	Cursor c1 = null;
	String n2=null;
	DATA.clear();
	String[] columns = new String[] {  "incomeamt" };
	
	
	if (c1.moveToNext()) {
	
	 n2=c1.getString(0);
	
	}
	return n2;
}



public String selectbal() {
	// TODO Auto-generated method stub
	Integer mYear;
	 Integer mMonth;
	   Integer mDay;
	final Calendar c2 = Calendar.getInstance();
   mYear = c2.get(Calendar.YEAR);
   mMonth = c2.get(Calendar.MONTH);
   mDay = c2.get(Calendar.DAY_OF_MONTH);
   int a=mMonth+1;
   int b=mDay;
   int c1=mYear;
   String month=Integer.toString(a);
  // String date=Integer.toString(b);
   String year=Integer.toString(c1);
    String dob2=month+"-"+year;
    Cursor c21 = null;
	String n2=null;
	DATA.clear();
	String[] columns = new String[] {  "SUM(amount)" };
	// c21 = db.query(false, "select sum(amount) from income where monthyear='"+dob2+"';", null, n2, null, n2, n2, n2, n2);
	
	while (c21.moveToNext()) {
	
	 n2=c21.getString(0);
	 
	
	}
	System.out.print(n2);
	return n2;
}

public ArrayList<String[]> selectalldatabase(String smf) {
	// TODO Auto-generated method stub
	
		Cursor c = null;
		DATA.clear();
		String[] columns = new String[] { "id","datee", "expensed", "amount" };
	
		if (c.moveToFirst()) {
		do {
		if (c.getColumnCount() == 4) {
		String[] str = new String[3];
		str[0] = c.getString(1);
		str[1] = c.getString(2);
		str[2] = c.getString(3);
		DATA.add(str);
		}
		} while (c.moveToNext());
		}

		if (c != null && !c.isClosed()) {
		c.close();
		}

		return DATA;
		}






}
