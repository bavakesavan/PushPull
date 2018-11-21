package kesavan.studios.kesav.pushpull;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class signin extends AppCompatActivity {

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
    private static GoogleApiClient googleApiClient;
    private Button next, back, signInButton, facebookButton;
    private SeekBar hbar;
    private ImageView male, female, origIcon;
    private TextView intro,high,uom;
    private int page = 1,gend = 0 ;
    public static final int SIGN_IN_CODE = 777;
    public static String profileimage = "";
    public static int out =0;
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private LinearLayout icon, icon2;
    Animation uptodown, downtoup, midtoup, fadeupto, midtoupfade;
    SharedPreferences prefs = null;
    private final int SPLASH_DISPLAY_LENGTH = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        midtoup = AnimationUtils.loadAnimation(this, R.anim.midtoup);
        midtoupfade = AnimationUtils.loadAnimation(this, R.anim.midtoupfade);
        fadeupto = AnimationUtils.loadAnimation(this, R.anim.fadeup);
        db = new DBmain(this);
        db1 = new DBpusha(this);
        db2 = new DBpulla(this);
        db3 = new DBlegsa(this);
        db4 = new DBpushb(this);
        db5 = new DBpullb(this);
        db6 = new DBlegsb(this);
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
        origIcon = (ImageView) findViewById(R.id.originIcon);
        hbar = (SeekBar) findViewById(R.id.heightbar);
        signInButton = (Button) findViewById(R.id.save);
        facebookButton = (Button) findViewById(R.id.login_button1);
        intro = (TextView) findViewById(R.id.textView3);
        high = (TextView) findViewById(R.id.textView71);
        uom = (TextView) findViewById(R.id.textView91);
        high.setText(0 + "' " + 0 + "\"");
        icon = (LinearLayout) findViewById(R.id.splashlayout);
        icon2 = (LinearLayout) findViewById(R.id.splashlayout2);

        origIcon.setVisibility(View.GONE);
        icon.setAnimation(midtoup);
        AlphaAnimation animation1 = new AlphaAnimation(0f, 1.0f);
        animation1.setDuration(900);
        animation1.setStartOffset(1000);
        animation1.setFillAfter(true);
        animation1.setFillBefore(false);
        icon2.startAnimation(animation1);

        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn();

            }
        });


        mCallbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
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

                    num2.setMinValue(40);
                    num2.setMaxValue(400);
                    num2.setValue(150);

                }else{
                    uom.setText("kgs");
                    units = "kgs";
                    num2.setMinValue(20);
                    num2.setMaxValue(200);
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
        num2.setMaxValue(400);
        num2.setValue(150);

        num3.setMinValue(0);
        num3.setMaxValue(6);
        num3.setDisplayedValues( new String[] { "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday" } );

    }

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                Context context = getApplicationContext();
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                //  updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        // showProgressDialog();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Context context = getApplicationContext();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //   updateUI(user);
                            //goMainScreen();
                            genderchoose();
                            Toast.makeText(context, "User: " + user.getDisplayName(), Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }

                    }
                });
    }
    // [END auth_with_google]

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        mAuth.signOut();
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //   updateUI(null);
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            goMainScreen();
        }
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            //   Toast.makeText(FacebookLoginActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });
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

    private void goMainScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(signin.this, MainA.class);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


}
