package kesavan.studios.kesav.pushpull;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBpusha extends SQLiteOpenHelper {

    public static final String TAG = DBpusha.class.getSimpleName();
    public static final String DB_n = "dbpusha.db";
    public static final int DB_VERSION = 2;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_1 = "pushaw1";
    public static final String COLUMN_2 = "pushaw2";
    public static final String COLUMN_3 = "pushaw3";
    public static final String COLUMN_4 = "pushaw4";
    public static final String COLUMN_5 = "pushaw5";
    public static final String COLUMN_6 = "pushaw6";
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

    public DBpusha(Context context) {
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

        int set = cursor.getInt(workout);
        cursor.close();
        db.close();

        return set;
    }

    public int get(int workout, int date) {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToPosition(date);
        int set = cursor.getInt(workout);
        cursor.close();
        db.close();

        return set;
    }

    public String getlabel(int date) {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToPosition(date);
        String set = cursor.getString(7) + "";
        cursor.close();
        db.close();

        return set;
    }
    public int getmax(int workout) {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        int max=  1;
        for(int i =0; i < cursor.getCount();i++){
            if(max <  cursor.getInt(workout)){
                max = cursor.getInt(workout);
            }else {
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return max*5;
    }

    public int getmin(int workout) {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToLast();
        int min = 10;
        for(int i =0; i < cursor.getCount();i++){
            if(min > cursor.getInt(workout) && 10 < cursor.getInt(workout)){
                min = cursor.getInt(workout);
            }else {
                cursor.moveToPrevious();
            }
        }
        cursor.close();
        db.close();

        return min*5;
    }

    public int getsize() {

        String selectQuery = "select * from  " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int size = cursor.getCount();
        cursor.close();
        db.close();
        return size;
    }
}
