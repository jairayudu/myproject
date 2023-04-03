package com.example.hospital;

import java.util.ArrayList;
import java.util.List;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper {

	public static ArrayList<String[]> DATA = new ArrayList<String[]>();
	private static final String DATABASE_NAME = "friendmapper.db";
	private static final int DATABASE_VERSION = 1;
	private static final String STUDENT_TABLE = "friend";
	private static final String STUDENT_TABLE8 = "msgtable";
	private static final String STUDENT_TABLE2 = "friend2";
	private static final String STUDENT_TABLE3 = "friend3";
	private static final String STUDENT_TABLE4 = "friend4";
	private static final String STUDENT_TABLE5 = "fazu";
	private static final String STUDENT_TABLE6 = "hospital";
	private static final String STUDENT_TABLE1 = "doctor";
	private static final String STUDENT_TABLE9 = "user";
	private static final String STUDENT_TABLE11 = "doc1";
	private static final String STUDENT_TABLE7 = "duty1";
	private static final String STUDENT_TABLE10 = "user_view";
	private static final String STUDENT_TABLE13 = "hos_user";
	
	
	
	
	private Context context;
	private SQLiteDatabase db = null;
	OpenHelper openHelper;

	String name = null;
	String un = null;
	String pw = null;
	String em = null;
	String mn = null;

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

	public int insertData(String name, String password, String email, String mobile,
			String date) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("password", password);
		values.put("email", email);
		values.put("mobile", mobile);
		values.put("date", date);

		entryId = (int) this.db.insert(STUDENT_TABLE, null, values);
		return entryId;
	}
	public int insertData1(String id, String name, String mail, String mob,
			String place,String qual,String spec) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("name", name);
		values.put("mail", mail);
		values.put("mob",mob);
		values.put("place", place);
		values.put("qual",qual);
		values.put("spec",spec);
		

		entryId = (int) this.db.insert(STUDENT_TABLE1, null, values);
		return entryId;
	}
	
	public int insertData2(String name, String password, String email, String mobile,
			String date) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("password", password);
		values.put("email", email);
		values.put("mobile", mobile);
		values.put("date", date);

		entryId = (int) this.db.insert(STUDENT_TABLE2, null, values);
		return entryId;
	}

	public int insertData3(String name, String password, String email, String mobile,
			String date) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("password", password);
		values.put("email", email);
		values.put("mobile", mobile);
		values.put("date", date);

		entryId = (int) this.db.insert(STUDENT_TABLE3, null, values);
		return entryId;
	}
	
	
	public int insertData4(String name, String password, String email, String mobile,
			String date) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("password", password);
		values.put("email", email);
		values.put("mobile", mobile);
		values.put("date", date);

		entryId = (int) this.db.insert(STUDENT_TABLE4, null, values);
		return entryId;
	}
	public int insertData6(String doctor_id, String doctor_name, String hospital_name, String starting_time,
			String duration) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("doctor_id",doctor_id);
		values.put("doctor_name",doctor_name);
		values.put("hospital_name", hospital_name);
		values.put("starting_time",starting_time);
		values.put("duration",duration);

		entryId = (int) this.db.insert(STUDENT_TABLE6, null, values);
		return entryId;
	}
	public int insertData7(String id, String name, String place, String spec,
			String time,String dur,String date,String doc) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("name", name);
		values.put("place", place);
		values.put("spec",spec);
		values.put("time", time);
		values.put("dur",dur);
		values.put("date",date);
		values.put("doc",doc);

		entryId = (int) this.db.insert(STUDENT_TABLE7, null, values);
		return entryId;
	}
	
	public int insertData8(String  username, String gender, String dob, String problem,
			String consulting_doctor,String appointment_date) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("username", username);
		values.put("gender", gender);
		values.put("dob", dob);
		values.put("problem",problem);
		values.put("consulting_doctor", consulting_doctor);
		values.put("appointment_date",appointment_date);
		
		entryId = (int) this.db.insert(STUDENT_TABLE9, null, values);
		return entryId;
	}
	public int insertData10(String id, String name, String place, String spec,
			String time,String dur,String date,String doc) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("name", name);
		values.put("place", place);
		values.put("spec",spec);
		values.put("time", time);
		values.put("dur",dur);
		values.put("date",date);
		values.put("doc",doc);

		entryId = (int) this.db.insert(STUDENT_TABLE10, null, values);
		return entryId;
	}
	public int insertData11(String name, String gender, String dob,
			String prob,String doc_name,String doc_spec,String app_date) {
		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("gender", gender);
		values.put("dob", dob);
		values.put("prob",prob);
		values.put("doc_name", doc_name);
		values.put("doc_spec",doc_spec);
		values.put("app_date",app_date);
	

		entryId = (int) this.db.insert(STUDENT_TABLE13, null, values);
		return entryId;
	}
	
	
	public ArrayList<String[]> selectalldatabase() {
		// TODO Auto-generated method stub
		
			Cursor c1 = null;
			DATA.clear();
			String[] columns = new String[] {"name","gender","dob", "prob", "doc_name" ,"doc_spec","app_date" };
			c1 = db.query(STUDENT_TABLE13, columns,null, null,null, null, null, null);
			if (c1.moveToFirst()) {
			do {
			if (c1.getColumnCount() == 7) {
			String[] str = new String[6];
			str[0] = c1.getString(0);
			str[1] = c1.getString(1);
			str[2] = c1.getString(3);
			str[3] = c1.getString(4);
			str[4] = c1.getString(5);
			str[5] = c1.getString(6);
			//str[6] = c1.getString(7);
			
			
			
			
			
			
			
			DATA.add(str);
			}
			} while (c1.moveToNext());
			}

			if (c1 != null && !c1.isClosed()) {
			c1.close();
			}

			return DATA;
			}
	
	
	public ArrayList<String[]> selectdatabase(String search) {
		Cursor c = null;
		DATA.clear();
		String[] columns = new String[] { "seat" };
		c = db.query(STUDENT_TABLE8, columns, "travels=", new String[] {
				search, search, search }, null, null, "id DESC");
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

	public void cr(String k, String k1) {
		ContentValues values = new ContentValues();
		values.put("cn1", k);

		int id = db
				.update(STUDENT_TABLE, values, "name=?", new String[] { k1 });

	}

	public String loginData(String h, String h1) {

		Cursor c1 = null;
		DATA.clear();
		String[] columns = new String[] { "name", "pass" };

		c1 = db.query(STUDENT_TABLE5, columns, "name=? AND pass=?  ",
				new String[] { h, h1 }, null, null, null);
		if (c1.moveToNext()) {

			String n = c1.getString(0);
			return "ok";

		} else {
			return "no";
		}
	}
	
	public String loginData12(String h, String h1) {

		Cursor c1 = null;
		DATA.clear();
		String[] columns = new String[] { "name", "pass" };

		c1 = db.query(STUDENT_TABLE5, columns, "name=? AND pass=?  ",
				new String[] { h, h1 }, null, null, null);
		if (c1.moveToNext()) {

			String n = c1.getString(0);
			return "ok";

		} else {
			return "no";
		}
	}
	
	public String loginData2(String h, String h1) {

		Cursor c1 = null;
		DATA.clear();
		String[] columns = new String[] { "name", "password" };

		c1 = db.query(STUDENT_TABLE2, columns, "name=? AND password=?  ",
				new String[] { h, h1 }, null, null, null);
		if (c1.moveToNext()) {

			String n = c1.getString(0);
			return "ok";

		} else {
			return "no";
		}
	}
	public String loginData3(String h, String h1) {

		Cursor c1 = null;
		DATA.clear();
		String[] columns = new String[] { "name", "password" };

		c1 = db.query(STUDENT_TABLE3, columns, "name=? AND password=?  ",
				new String[] { h, h1 }, null, null, null);
		if (c1.moveToNext()) {

			String n = c1.getString(0);
			return "ok";

		} else {
			return "no";
		}
	}
	public String loginData4(String h, String h1) {

		Cursor c1 = null;
		DATA.clear();
		String[] columns = new String[] { "name", "password" };

		c1 = db.query(STUDENT_TABLE4, columns, "name=? AND password=?  ",
				new String[] { h, h1 }, null, null, null);
		if (c1.moveToNext()) {

			String n = c1.getString(0);
			return "ok";

		} else {
			return "no";
		}
	}
	
	

	public int insertData12(String name, String un,String pw,String em,String mn,String dep,String yr) {

		int entryId = 0;
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("un", un);
		values.put("pw", pw);
		values.put("em", em);
		values.put("mn", mn);
		values.put("dep", dep);
		values.put("yr", yr);
		
		entryId = (int) this.db.insert(STUDENT_TABLE8, null, values);
		return entryId;

	}

	static class OpenHelper extends SQLiteOpenHelper {

		OpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			db.execSQL("CREATE TABLE " + STUDENT_TABLE + "("
					+ "ke INTEGER PRIMARY KEY," + "name TEXT, " + "password TEXT,"
					+ "email TEXT," + "mobile TEXT," + "date TEXT)");

			db.execSQL("CREATE TABLE " + STUDENT_TABLE8 + "(" + "ke INTEGER PRIMARY KEY," + "name TEXT, "+ "un TEXT, "+ "pw TEXT, "+ "mn TEXT," + " em TEXT, "
					+"dep TEXT,"+"yr TEXT)");
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE2 + "("
					+ "ke INTEGER PRIMARY KEY," + "name TEXT, " + "password TEXT,"
					+ "email TEXT," + "mobile TEXT," + "date TEXT)");
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE1 + "("
					+ "ke INTEGER PRIMARY KEY," + "id TEXT, " + "name TEXT,"
					+ "mail TEXT," + "mob TEXT," + "place TEXT," + "qual TEXT,"+ "spec TEXT)");
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE3 + "("
					+ "ke INTEGER PRIMARY KEY," + "name TEXT, " + "password TEXT,"
					+ "email TEXT," + "mobile TEXT," + "date TEXT)");
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE4 + "("
					+ "ke INTEGER PRIMARY KEY," + "name TEXT, " + "password TEXT,"
					+ "email TEXT," + "mobile TEXT," + "date TEXT)");
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE5 + "("
					+ "ke INTEGER PRIMARY KEY," + "name TEXT, " + "pass TEXT,"
					+ "per TEXT," + "mob TEXT," + "addr TEXT)");
			db.execSQL("CREATE TABLE " + STUDENT_TABLE6 + "("
					+ "doctor_id INTEGER PRIMARY KEY," + "doctor_name TEXT, " + "hospital_name TEXT,"
					+ "starting_time TEXT," + "duration TEXT)");
			
			
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE7 + "("
					+ "ke INTEGER PRIMARY KEY," + "id TEXT, " + "name TEXT,"
					+ "place TEXT," + "spec TEXT," + "time TEXT," + "dur TEXT,"+ "date TEXT,"+ "doc TEXT,"+"_id TEXT)");
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE10 + "("
					+ "ke INTEGER PRIMARY KEY," + "id TEXT, " + "name TEXT,"
					+ "place TEXT," + "spec TEXT," + "time TEXT," + "dur TEXT,"+ "date TEXT,"+ "doc TEXT)");
			
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE11 + "("
					+ "ke INTEGER PRIMARY KEY," + "id TEXT, " + "name TEXT,"
					+ "place TEXT," + "spec TEXT," + "time TEXT," + "dur TEXT,"+ "date TEXT"+ "doc TEXT)");
			
			db.execSQL("CREATE TABLE " + STUDENT_TABLE9 + "("
					+ "username TEXT, " + "gender TEXT,"
					+ "dob TEXT," + "problem TEXT," + "consulting_doctor TEXT," + "appointment_date TEXT)");

			db.execSQL("CREATE TABLE " + STUDENT_TABLE13 + "("
					+ "name TEXT, " + "gender TEXT,"+"_id TEXT,"
					+ "dob TEXT," + "prob TEXT," + "doc_name TEXT," + "doc_spec TEXT," + "app_date TEXT)");


			
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
			
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE1);

			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE8);
			
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE2);
			
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE3);

			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE4);
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE5);
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE6);
			
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE7);
			
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE9);
			onCreate(db);
			
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE10);
		
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE11);
			Log.w("Catch DB",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE13);
		}
	}
	
	
	
	public ArrayList<String[]> selectalldatabase2(String smf) {
		// TODO Auto-generated method stub
		
			Cursor c1 = null;
			DATA.clear();
			String[] columns = new String[] { "id","name","mob", "place", "qual", "spec" };
			c1 = db.query(STUDENT_TABLE1, columns,"mail=?", new String[] {smf},null, null, null, null);
			if (c1.moveToFirst()) {
			do {
			if (c1.getColumnCount() == 6) {
			String[] str = new String[6];
			str[0] = c1.getString(1);
			str[1] = c1.getString(2);
			str[2] = c1.getString(3);
			str[3] = c1.getString(4);
			str[4] = c1.getString(5);
			
			
			
			
			
			
			
			DATA.add(str);
			}
			} while (c1.moveToNext());
			}

			if (c1 != null && !c1.isClosed()) {
			c1.close();
			}

			return DATA;
			}
	
	
	
	

	public ArrayList<String[]> selectalldatabase3(String smf1) {
		// TODO Auto-generated method stub
		
			Cursor c1 = null;
			DATA.clear();
			String[] columns = new String[] { "name","place","spec", "time", "dur", "date" ,"doc" };
			c1 = db.query(STUDENT_TABLE7, columns,"id=?", new String[] {smf1},null, null, null, null);
			if (c1.moveToFirst()) {
			do {
			if (c1.getColumnCount() == 7) {
			String[] str = new String[7];
			str[0] = c1.getString(1);
			str[1] = c1.getString(2);
			str[2] = c1.getString(3);
			str[3] = c1.getString(4);
			str[4] = c1.getString(5);
			str[5] = c1.getString(6);
			
			
			
			
			
			
			
			DATA.add(str);
			}
			} while (c1.moveToNext());
			}

			if (c1 != null && !c1.isClosed()) {
			c1.close();
			}

			return DATA;
			}

			
	public ArrayList<String[]> selectalldatabase4(String smf1) {
		// TODO Auto-generated method stub
		
			Cursor c1 = null;
			DATA.clear();
			String[] columns = new String[] {"id", "name","place","time", "dur", "date" ,"doc" };
			c1 = db.query(STUDENT_TABLE7, columns,"spec=?", new String[] {smf1},null, null, null, null);
			if (c1.moveToFirst()) {
			do {
			if (c1.getColumnCount() == 7) {
			String[] str = new String[7];
			str[0] = c1.getString(1);
			str[1] = c1.getString(2);
			str[2] = c1.getString(3);
			str[3] = c1.getString(4);
			str[4] = c1.getString(5);
			str[5] = c1.getString(6);
			
			
			
			
			
			
			
			DATA.add(str);
			}
			} while (c1.moveToNext());
			}

			if (c1 != null && !c1.isClosed()) {
			c1.close();
			}

			return DATA;
			}
	
	public List<String> getAllLabels()
	{
		List<String> st = new ArrayList<String>();
		Cursor c = null;
		String []str = new String[]{"spec"};
		c = db.query(STUDENT_TABLE7, str, null, null, null, null, null);
		if(c.moveToFirst())
		{
			do
			{
				if(c.getColumnCount() == 1)
				{
					String []strg=new String[1];
					st.add(strg[0] = c.getString(0));
				}
			}while(c.moveToNext());
		}
		if(c != null && !c.isClosed())
		{
			c.close();
		}
		return st;
	}
	
public Cursor SelectRatingAllc(String aa){
		
		Cursor c1 = null;
		DATA.clear();
		String[] cols = new String[] {"ke","id", "name","place","spec","time", "dur", "date" ,"doc","_id"};
		c1 = db.query(STUDENT_TABLE7, cols, "spec=?", new String[]{aa}, null, null, null);
		return c1;
	}
	
	public ArrayList<String[]> selectalldatabase5(String smf2) {
		// TODO Auto-generated method stub
		
			Cursor c1 = null;
			DATA.clear();
			String[] columns = new String[] { "id","name","place", "time", "dur", "date" ,"doc" };
			c1 = db.query(STUDENT_TABLE7, columns,"spec=?", new String[] {smf2},null, null, null, null);
		
			if (c1.moveToFirst()) {
			do {
			if (c1.getColumnCount() == 7) {
			String[] str = new String[7];
			str[0] = c1.getString(1);
			str[1] = c1.getString(2);
			str[2] = c1.getString(3);
			str[3] = c1.getString(4);
			str[4] = c1.getString(5);
			str[5] = c1.getString(6);
			
			
			
			
			
			
			
			DATA.add(str);
			}
			} while (c1.moveToNext());
			}

			if (c1 != null && !c1.isClosed()) {
			c1.close();
			}

			return DATA;
			}


	
	
	
	
	
	

	public Cursor getAllContacts() {
		// TODO Auto-generated method stub

		return db.query(STUDENT_TABLE8, new String[] { name, un, pw, em, mn }, null, null,
				null, null, null);
		// return null;
	}

	public Cursor rawQuery(String string, Object object) {

		return null;
	}

}
