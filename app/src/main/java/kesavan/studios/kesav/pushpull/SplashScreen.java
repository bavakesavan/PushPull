package kesavan.studios.kesav.pushpull;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

public class SplashScreen extends AppCompatActivity {
    public DBmain db;
    public DBmainold dbold;
    public DBrating dbrating2;
    private DBpusha db1;
    private DBpulla db2;
    private DBlegsa db3;
    private DBpushb db4;
    private DBpullb db5;
    private DBlegsb db6;
    private int askUOM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.splash);
        db = new DBmain(this);
        dbold = new DBmainold(this);
        db1 = new DBpusha(this);
        db2 = new DBpulla(this);
        db3 = new DBlegsa(this);
        db4 = new DBpushb(this);
        db5 = new DBpullb(this);
        db6 = new DBlegsb(this);
        dbrating2 = new DBrating(this);

        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {

                    try {
                        db1.getinfo(1);
                    }catch (Exception e){
                        db1.update(6, 8, 8, 6, 6, 6, "");
                        db2.update(6, 8, 8, 6, 6, 6, "");
                        db3.update(6, 8, 8, 6, 6, 6, "");
                        db4.update(6, 8, 8, 6, 6, 6, "");
                        db5.update(6, 8, 8, 6, 6, 6, "");
                        db6.update(6, 8, 8, 6, 6, 6, "");
                    }

                    Random rand = new Random();
                    sleep(rand.nextInt(1000) + 500);
                    Context context = getApplicationContext();
                    File dbFile = context.getDatabasePath("dbmainuser.db");

                    if( String.valueOf(dbFile.exists()).equals("true")){
                        db.addUser(dbold.getfullname(),dbold.getgender(),dbold.getage(), dbold.cweight(), dbold.height(), dbold.getday(),dbold.geturl(),null);
                        dbFile.delete();
                        Intent intent = new Intent(context, signin.class);
                        finish();
                        startActivity(intent);
                    }

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
                    try{
                        int rate = dbrating2.getrating();
                        if(rate < 31 && rate > 9){
                            rate--;
                            dbrating2.update(rate,0,0);
                        }
                    }catch (Exception e){
                        dbrating2.update(15,0,0);
                    }
                    if (!previouslyStarted) {
                        Intent intent = new Intent(context, signin.class);
                        finish();
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), MainA.class);
                        finish();
                        startActivity(intent);
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

}