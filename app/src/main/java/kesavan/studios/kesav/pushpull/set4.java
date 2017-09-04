package kesavan.studios.kesav.pushpull;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class set4 extends SQLiteOpenHelper {

    public static final String TAG = set4.class.getSimpleName();
    public static final String DB_n = "set41.db";
    public static final int DB_VERSION = 2;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_1 = "s1";
    public static final String COLUMN_2 = "s2";
    public static final String COLUMN_3 = "s3";
    public static final String COLUMN_4 = "s4";
    public static final String COLUMN_5 = "s5";
    public static final String COLUMN_6 = "DB";
    public static final String COLUMN_7 = "timesignature";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_1 + " TEXT,"
            + COLUMN_2 + " TEXT,"
            + COLUMN_3 + " TEXT,"
            + COLUMN_4 + " TEXT,"
            + COLUMN_5 + " TEXT,"
            + COLUMN_6 + " TEXT,"
            + COLUMN_7 + " TEXT);";


    public set4(Context context) {
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

    public void update(int pushaw1, int pushaw2, int pushaw3, int pushaw4, int pushaw5, int pushaw6, String pushaw7) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1, pushaw1);
        values.put(COLUMN_2, pushaw2);
        values.put(COLUMN_3, pushaw3);
        values.put(COLUMN_4, pushaw4);
        values.put(COLUMN_5, pushaw5);
        values.put(COLUMN_6, pushaw6);
        values.put(COLUMN_7, pushaw7);

        long id = db.insert(USER_TABLE, null, values);
        db.close();
    }

    public int getinfo(int workout) {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        int firstname = cursor.getInt(workout);
        cursor.close();
        db.close();

        return firstname;
    }
    public String getday(String date) {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String dbdate = "DNE";
        // Move to most recent row
        cursor.moveToLast();
        for(int i =0; i < cursor.getCount();i++){
            if(date.equals(cursor.getString(7)+"")){
                dbdate = cursor.getString(7);
                break;
            }else {
                cursor.moveToPrevious();
            }
        }

        cursor.close();
        db.close();

        return dbdate;
    }
}