package kesavan.studios.kesav.pushpull;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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
import com.google.firebase.database.IgnoreExtraProperties;

import java.sql.Date;

@IgnoreExtraProperties
public class signin extends AppCompatActivity {

    private @ServerTimestamp
    Date timestamp;
    private String name, gender, age, weight, height,startd,url,heightseek = "50",  units = "lbs";
    private RelativeLayout relative1, relative2;
    private NumberPicker num1, num2, num3;
    private static GoogleApiClient googleApiClient;
    private Button next, back, signInButton, facebookButton;
    private SeekBar hbar;
    private ImageView male, female, UserImage, origIcon;
    private TextView intro, high, uom, UserName;
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

        relative1 = (RelativeLayout) findViewById(R.id.relative1);
        relative2 = (RelativeLayout) findViewById(R.id.relative2);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);

        UserImage = (ImageView) findViewById(R.id.UserImage);
        UserName = (TextView) findViewById(R.id.User_Name);

        origIcon = (ImageView) findViewById(R.id.originIcon);
        signInButton = (Button) findViewById(R.id.save);
        facebookButton = (Button) findViewById(R.id.login_button1);
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

        Context context = getApplicationContext();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn();

            }
        });
        FirebaseUser user = mAuth.getCurrentUser();
        Toast.makeText(context, "User: " + user.getDisplayName(), Toast.LENGTH_LONG).show();

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


    }

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
                Context context = getApplicationContext();
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                //  updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

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
                            Toast.makeText(context, "User: " + user.getDisplayName(), Toast.LENGTH_LONG).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }

                    }
                });
    }


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
            //goMainScreen();
            //genderchoose();
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

        relative1.setVisibility(View.GONE);
        relative2.setVisibility(View.VISIBLE);

       /* URL newurl = null;
        Bitmap mIcon_val = null;
        try {
            newurl = new URL(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString());
            mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
            UserImage.setImageBitmap(mIcon_val);
        } catch (IOException e) {
            UserImage.setImageResource(R.drawable.profile);
        }*/
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        UserName.setText(userId);
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
