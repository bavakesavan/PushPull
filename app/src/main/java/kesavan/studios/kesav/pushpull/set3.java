package kesavan.studios.kesav.pushpull;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class set3 extends SQLiteOpenHelper {

    public static final String TAG = set3.class.getSimpleName();
    public static final String DB_n = "set31.db";
    public static final int DB_VERSION = 2;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_1 = "s1";
    public static final String COLUMN_2 = "s2";
    public static final String COLUMN_3 = "s3";
    public static final String COLUMN_4 = "DB";
    public static final String COLUMN_5 = "timesignature";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_1 + " TEXT,"
            + COLUMN_2 + " TEXT,"
            + COLUMN_3 + " TEXT,"
            + COLUMN_4 + " TEXT,"
            + COLUMN_5 + " TEXT);";


    public set3(Context context) {
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


    public void update(int pushaw1, int pushaw2, int pushaw3, int pushaw4, String pushaw5) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1, pushaw1);
        values.put(COLUMN_2, pushaw2);
        values.put(COLUMN_3, pushaw3);
        values.put(COLUMN_4, pushaw4);
        values.put(COLUMN_5, pushaw5);

        long id = db.insert(USER_TABLE, null, values);
        db.close();
        Log.d(TAG, "user inserted" + id);
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
            if(date.equals(cursor.getString(5)+"")){
                dbdate = cursor.getString(5);
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