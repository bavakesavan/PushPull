package kesavan.studios.kesav.pushpull;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBmain extends SQLiteOpenHelper {

    public static final String TAG = DBmain.class.getSimpleName();
    public static final String DB_n = "dbmainuser1.db";
    public static final int DB_VERSION = 2;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_1 = "name";
    public static final String COLUMN_2 = "gender";
    public static final String COLUMN_3 = "age";
    public static final String COLUMN_4 = "weight";
    public static final String COLUMN_5 = "height";
    public static final String COLUMN_6 = "routinestartday";
    public static final String COLUMN_7 = "url";
    public static final String COLUMN_8 = "uom";
    public static final String COLUMN_9 = "empty3";
    public static final String COLUMN_10 = "empty4";
    public static final String COLUMN_11 = "empty5";
    public static final String COLUMN_12 = "empty6";
    public static final String COLUMN_13 = "empty7";
    public static final String COLUMN_14 = "empty8";
    public static final String COLUMN_15 = "date";
    public static final String COLUMN_16 = "restday";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_1 + " TEXT,"
            + COLUMN_2 + " TEXT,"
            + COLUMN_3 + " TEXT,"
            + COLUMN_4 + " TEXT,"
            + COLUMN_5 + " TEXT,"
            + COLUMN_6 + " TEXT,"
            + COLUMN_7 + " TEXT,"
            + COLUMN_8 + " TEXT,"
            + COLUMN_9 + " TEXT,"
            + COLUMN_10 + " TEXT,"
            + COLUMN_11 + " TEXT,"
            + COLUMN_12 + " TEXT,"
            + COLUMN_13 + " TEXT,"
            + COLUMN_14 + " TEXT,"
            + COLUMN_15 + " TEXT,"
            + COLUMN_16 + " TEXT);";

    public DBmain(Context context) {
        super(context, DB_n, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public void addUser(String name, String gender, String age, String weight, String height, String rstart, String url, String uom) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1, name);
        values.put(COLUMN_2, gender);
        values.put(COLUMN_3, age);
        values.put(COLUMN_4, weight);
        values.put(COLUMN_5, height);
        values.put(COLUMN_6, rstart);
        values.put(COLUMN_7, url);
        values.put(COLUMN_8, uom);
        values.put(COLUMN_9, "");
        values.put(COLUMN_10, "");
        values.put(COLUMN_11, "");
        values.put(COLUMN_12, "");
        values.put(COLUMN_13, "");
        values.put(COLUMN_14, "");
        values.put(COLUMN_15, "");
        values.put(COLUMN_16, "");

        long id = db.insert(USER_TABLE, null, values);
        db.close();

    }

    public boolean getUser(String email, String pass) {

        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + USER_TABLE + " where " + COLUMN_1 + " = " + "'" + email + "'" + " and " + COLUMN_2 + " = " + "'" + pass + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        if (cursor.getCount() > 0) {
            return true;

        }
        cursor.close();
        db.close();

        return false;
    }

    public String getname() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String firstname = cursor.getString(1);
        if (firstname.contains(" ")) {

            firstname = firstname.substring(0, firstname.indexOf(" "));
        }

        cursor.close();
        db.close();

        return firstname;
    }
    public String getuom() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String units = cursor.getString(8);

        cursor.close();
        db.close();

        return units;
    }


    public String getage() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String age = cursor.getString(3);

        cursor.close();
        db.close();

        return age;
    }
    public String getfullname() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String firstname = cursor.getString(1);
        cursor.close();
        db.close();

        return firstname;
    }

    public String getgender() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String gender = cursor.getString(2);
        cursor.close();
        db.close();

        return gender;
    }

    public String geturl() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String purl = cursor.getString(7);

        cursor.close();
        db.close();

        return purl;
    }

    public String getday() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String dayselected = cursor.getString(6);

        cursor.close();
        db.close();

        return dayselected;
    }

    public String sweight() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String dayselected = cursor.getString(4);

        cursor.close();
        db.close();

        return dayselected;
    }

    public String height() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String dayselected = cursor.getString(5);

        cursor.close();
        db.close();

        return dayselected;
    }

    public String cweight() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String dayselected = cursor.getString(4);

        cursor.close();
        db.close();

        return dayselected;
    }

    public String dweight() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        String dayselected = cursor.getString(8);

        cursor.close();
        db.close();

        return dayselected;
    }
}
