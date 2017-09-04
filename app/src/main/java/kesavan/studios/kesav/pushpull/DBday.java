package kesavan.studios.kesav.pushpull;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBday extends SQLiteOpenHelper {

    public static final String TAG = DBday.class.getSimpleName();
    public static final String DB_n = "srttext4.db";
    public static final int DB_VERSION = 2;

    public static final String USER_TABLE = "day";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_1 = "pushaw1";
    public static final String COLUMN_2 = "pushaw2";
    public static final String COLUMN_3 = "pushaw3";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_1 + " TEXT,"
            + COLUMN_2 + " TEXT,"
            + COLUMN_3 + " TEXT);";

    public DBday(Context context) {
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

    public void update(int pushaw1, int pushaw2, int pushaw3) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1, pushaw1);
        values.put(COLUMN_2, pushaw2);
        values.put(COLUMN_3, pushaw3);

        long id = db.insert(USER_TABLE, null, values);
        db.close();
    }

    public int getsweight() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        int dday = cursor.getInt(1);
        cursor.close();
        db.close();

        return dday;
    }

    public int getcweight() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        int dday = cursor.getInt(2);
        cursor.close();
        db.close();

        return dday;
    }

    public int getdweight() {

        String selectQuery = "select * from  " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to most recent row
        cursor.moveToLast();

        int dday = cursor.getInt(3);
        cursor.close();
        db.close();

        return dday;
    }
}
