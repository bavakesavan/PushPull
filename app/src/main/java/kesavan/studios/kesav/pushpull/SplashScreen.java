package kesavan.studios.kesav.pushpull;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

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
    private final int SPLASH_DISPLAY_LENGTH = 300;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        layout = (RelativeLayout) findViewById(R.id.splashlayout1);



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
                    sleep(0);
                    Context context = getApplicationContext();

                    File dbFile = context.getDatabasePath("dbmainuser.db");

                    if( String.valueOf(dbFile.exists()).equals("true")){
                        db.addUser(dbold.getfullname(),dbold.getgender(),dbold.getage(), dbold.cweight(), dbold.height(), dbold.getday(),dbold.geturl(),null);
                        dbFile.delete();


                        new Handler().postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                //Create an Intent that will start the Menu-Activity.

                                Intent mainIntent = new Intent(SplashScreen.this,signin.class);
                                startActivity(mainIntent);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            }
                        }, SPLASH_DISPLAY_LENGTH);

                       // Intent intent = new Intent(context, signin.class);
                       // finish();
                       // startActivity(intent);
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
                        new Handler().postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                //  Create an Intent that will start the Menu-Activity.

                                Intent mainIntent = new Intent(SplashScreen.this,signin.class);
                                startActivity(mainIntent);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            }
                        }, SPLASH_DISPLAY_LENGTH);

                    } else {
                        new Handler().postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                //  Create an Intent that will start the Menu-Activity.

                                Intent mainIntent = new Intent(SplashScreen.this,MainA.class);
                                startActivity(mainIntent);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            }
                        }, SPLASH_DISPLAY_LENGTH);
    
                    }

                    Intent mainIntent = new Intent(SplashScreen.this, signin.class);
                    startActivity(mainIntent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        myThread.start();
    }

}