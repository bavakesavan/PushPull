package kesavan.studios.kesav.pushpull;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;

public class signin extends AppCompatActivity implements  GoogleApiClient.OnConnectionFailedListener{

    Button btn;
    private EditText usr, gdr, ag, weig, heigh, sta;
    private DBmain db;
    private DBpusha db1;
    private DBpulla db2;
    private DBlegsa db3;
    private DBpushb db4;
    private DBpullb db5;
    private DBlegsb db6;
    private String name, gender, age, weight, height,startd,url,heightseek = "50",  units = "lbs";
    private RelativeLayout relative1, relative2,relative3,relative4,relative5,relative6,relative7;
    private NumberPicker num1, num2, num3;
    private Button next, back;
    private static GoogleApiClient googleApiClient;
    private Button signInButton;
    private SeekBar hbar;
    private ImageView male, female;
    private TextView intro,high,uom;
    private int page = 1,gend = 0 ;
    public static final int SIGN_IN_CODE = 777;
    public static String profileimage = "";
    public static int out =0;

    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        db = new DBmain(this);
        db1 = new DBpusha(this);
        db2 = new DBpulla(this);
        db3 = new DBlegsa(this);
        db4 = new DBpushb(this);
        db5 = new DBpullb(this);
        db6 = new DBlegsb(this);
        btn = (Button) findViewById(R.id.save);
        usr = (EditText) findViewById(R.id.usr);
        gdr = (EditText) findViewById(R.id.psh);
        ag = (EditText) findViewById(R.id.age);
        weig = (EditText) findViewById(R.id.weight);
        heigh = (EditText) findViewById(R.id.height);
        sta = (EditText) findViewById(R.id.rdate);
        relative1 = (RelativeLayout) findViewById(R.id.relative1);
        relative2 = (RelativeLayout) findViewById(R.id.relative2);
        relative3 = (RelativeLayout) findViewById(R.id.relative3);
        relative4 = (RelativeLayout) findViewById(R.id.relative4);
        relative5 = (RelativeLayout) findViewById(R.id.relative5);
        relative6 = (RelativeLayout) findViewById(R.id.relative6);
        relative7 = (RelativeLayout) findViewById(R.id.relative55);
        num1 = (NumberPicker) findViewById(R.id.numberPicker1);
        num2 = (NumberPicker) findViewById(R.id.numberPicker2);
        num3 = (NumberPicker) findViewById(R.id.numberPicker3);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        male = (ImageView) findViewById(R.id.imageView3);
        female = (ImageView) findViewById(R.id.imageView4);
        hbar = (SeekBar) findViewById(R.id.heightbar);
        signInButton = (Button) findViewById(R.id.save);
        intro = (TextView) findViewById(R.id.textView3);
        high = (TextView) findViewById(R.id.textView71);
        uom = (TextView) findViewById(R.id.textView91);

        high.setText(0 + "' " + 0 + "\"");

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent2, SIGN_IN_CODE);
            }
        });
        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender="0";
                male.setImageResource(R.drawable.male_selected);
                female.setImageResource(R.drawable.female);
                next.setVisibility(View.VISIBLE);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender="1";
                male.setImageResource(R.drawable.male);
                female.setImageResource(R.drawable.female_selected);
                next.setVisibility(View.VISIBLE);

            }
        });

        uom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uom.getText() == "kgs"){
                    uom.setText("lbs");
                    units = "lbs";

                    num2.setMinValue(20);
                    num2.setMaxValue(300);
                    num2.setValue(150);

                }else{
                    uom.setText("kgs");
                    units = "kgs";
                    num2.setMinValue(20);
                    num2.setMaxValue(150);
                    num2.setValue(60);

                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (page == 1){
                    genderchoose();
                }else if (page == 2){
                    agechoose();
                }else if (page == 3){
                    uomchoose();
                }else if (page == 4){
                    weightchoose();
                }else if (page == 5){
                    heightchoose();
                }else if (page == 6){
                    routinechoose();
                }else if (page == 7){
                    createdb();
                    goMainScreen();
                }else if (page == 8){
                    weightchoose2();
                }else if (page == 9){
                    createdb2();
                    goMainScreen();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (page == 3){
                    genderchoose();
                }else if (page == 4){
                    agechoose();
                }else if (page == 5){
                    uomchoose();
                }else if (page == 6){
                    weightchoose();
                }else if (page == 7){
                    heightchoose();
                }else if (page == 9){
                    uomchoose2();
                }
            }
        });

        hbar.setProgress(50);
        high.setText((50/24) + 4 + "' " + (50/2)%12 + "\"");
        hbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                heightseek=String.valueOf(progress);
                int inches = progress/2;
                int feet = inches / 12;
                int leftover = inches % 12;
                high.setText(feet + 4 + "' " + leftover + "\"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        num1.setMinValue(10);
        num1.setMaxValue(100);
        num1.setValue(22);


        num2.setMinValue(20);
        num2.setMaxValue(300);
        num2.setValue(150);

        num3.setMinValue(0);
        num3.setMaxValue(6);
        num3.setDisplayedValues( new String[] { "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday" } );

    }

    @Override
    protected void onResume() {

        super.onResume();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()) {
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Context context = getApplicationContext();
        Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if (requestCode == SIGN_IN_CODE) {
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                handleSignInResult(result);
            }
        }catch (Exception e){

            name = "";
            age = ag.getText().toString();
            weight = weig.getText().toString();
            height = heigh.getText().toString();
            startd = sta.getText().toString();
            intro.setText("Hi " + name + ",");
            url ="";


            prefs.edit().putBoolean("firstrun", false).commit();

            Context context = getApplicationContext();
            Toast.makeText(context, "Sign in failed", Toast.LENGTH_SHORT).show();
            genderchoose();
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            try {
                GoogleSignInAccount account = result.getSignInAccount();

                name = account.getDisplayName();
                age = ag.getText().toString();
                weight = weig.getText().toString();
                height = heigh.getText().toString();
                startd = sta.getText().toString();

                url = account.getPhotoUrl().toString();

                String firstname = "";
                if (name.contains(" ")) {

                    firstname = name.substring(0, name.indexOf(" "));
                }

                intro.setText("Hi " + firstname + ",");

                prefs.edit().putBoolean("firstrun", false).commit();
                try {
                    if(db.getuom()== null){
                        uomchoose2();
                    }else{

                        genderchoose();
                    }
                }catch (Exception e){
                    genderchoose();
                }
            }catch (Exception e){

                name = "";
                age = ag.getText().toString();
                weight = weig.getText().toString();
                height = heigh.getText().toString();
                startd = sta.getText().toString();

                intro.setText("Hi " + name + ",");
                url ="";

                prefs.edit().putBoolean("firstrun", false).commit();

                Context context = getApplicationContext();
                Toast.makeText(context, "Sign in failed", Toast.LENGTH_SHORT).show();
                genderchoose();
            }
        }

    }

    private void genderchoose(){

        page=2;
        relative1.setVisibility(View.GONE);
        relative3.setVisibility(View.GONE);
        relative7.setVisibility(View.GONE);
        relative4.setVisibility(View.GONE);
        relative5.setVisibility(View.GONE);
        relative6.setVisibility(View.GONE);
        relative2.setVisibility(View.VISIBLE);
        back.setVisibility(View.GONE);
    }

    private void agechoose(){

        page=3;
        relative2.setVisibility(View.GONE);
        relative1.setVisibility(View.GONE);
        relative4.setVisibility(View.GONE);
        relative5.setVisibility(View.GONE);
        relative6.setVisibility(View.GONE);
        relative7.setVisibility(View.GONE);
        back.setVisibility(View.VISIBLE);
        relative3.setVisibility(View.VISIBLE);

    }

    private void weightchoose(){

        page=5;
        relative3.setVisibility(View.GONE);
        relative2.setVisibility(View.GONE);
        relative1.setVisibility(View.GONE);
        relative5.setVisibility(View.GONE);
        relative6.setVisibility(View.GONE);
        relative7.setVisibility(View.GONE);
        relative4.setVisibility(View.VISIBLE);

    }
    private void weightchoose2(){

        page=9;
        relative3.setVisibility(View.GONE);
        relative2.setVisibility(View.GONE);
        relative1.setVisibility(View.GONE);
        relative5.setVisibility(View.GONE);
        relative6.setVisibility(View.GONE);
        relative7.setVisibility(View.GONE);
        relative4.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);

    }

    private void heightchoose(){

        page=6;
        relative4.setVisibility(View.GONE);
        relative3.setVisibility(View.GONE);
        relative2.setVisibility(View.GONE);
        relative1.setVisibility(View.GONE);
        relative6.setVisibility(View.GONE);
        relative7.setVisibility(View.GONE);
        relative5.setVisibility(View.VISIBLE);

    }

    private void routinechoose(){

        page=7;
        relative5.setVisibility(View.GONE);
        relative3.setVisibility(View.GONE);
        relative4.setVisibility(View.GONE);
        relative2.setVisibility(View.GONE);
        relative1.setVisibility(View.GONE);
        relative7.setVisibility(View.GONE);
        relative6.setVisibility(View.VISIBLE);

    }


    private void uomchoose(){

        page=4;
        relative5.setVisibility(View.GONE);
        relative3.setVisibility(View.GONE);
        relative4.setVisibility(View.GONE);
        relative2.setVisibility(View.GONE);
        relative1.setVisibility(View.GONE);
        relative6.setVisibility(View.GONE);
        relative7.setVisibility(View.VISIBLE);

    }
    private void uomchoose2(){

        page=8;
        relative5.setVisibility(View.GONE);
        relative3.setVisibility(View.GONE);
        relative4.setVisibility(View.GONE);
        relative2.setVisibility(View.GONE);
        relative1.setVisibility(View.GONE);
        relative6.setVisibility(View.GONE);
        relative7.setVisibility(View.VISIBLE);
        back.setVisibility(View.GONE);
        next.setVisibility(View.VISIBLE);

    }

    private void createdb(){

        age=Integer.toString(num1.getValue());
        weight=Integer.toString(num2.getValue());
        height=heightseek;
        startd=Integer.toString(num3.getValue());

        db.addUser(name,gender,age, weight, height, startd,url,units);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);

        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
        edit.commit();


    }
    private void createdb2(){
        db.addUser(db.getfullname(),db.getgender(),db.getage(), db.cweight(), db.height(), db.getday(),db.geturl(),""+  uom.getText());
    }

    static void signout()
    {
        Auth.GoogleSignInApi.signOut(googleApiClient);
    }

    private void goMainScreen() {

        Intent intent = new Intent(this, MainA.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
