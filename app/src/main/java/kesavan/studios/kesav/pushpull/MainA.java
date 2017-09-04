package kesavan.studios.kesav.pushpull;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import at.markushi.ui.CircleButton;

public class MainA extends AppCompatActivity {

    public int count[] = new int[26];
    public String[][] excer = new String[5][4];

    public int today = 0, page = 1, start = 0, splash = 0, dbb = 0, dbbb = 0, abs = 0, s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0, s6 = 0, new_workout = 0, dayselect = 0, dayselected = 0, profile = 0, goal1 = 0, countera, rate = 9, pg1=1, pg2=0, pg3=0, bcount = 0, hcount =0;
    public Calendar c = Calendar.getInstance();
    public SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public String uom = "lbs", month, year, date;

    public String[][] Rest = new String[][] {{"REST",uom,"REST"},{"REST",uom,"REST"},{"REST",uom,"REST"},{"REST",uom,"REST"},{"REST",uom,"REST"},{"REST",uom,"REST"}};
    public String[][] Pusha = new String[][] {{"Bench Press",uom,"Rest time: 90-120 sec"},{"Neck Press",uom,"Rest time: 60 sec"},{"Tricep Dips",uom,"Rest time: 60 sec"},{"Cable Crossovers",uom,"Rest time: 30 sec"},{"Tricep Extensions",uom,"Rest time: 30 sec"},{"Lateral Raises",uom,"Rest time: 15 sec"}};
    public String[][] Pulla = new String[][] {{"Deadlift",uom,"Rest time: 90-120 sec"},{"Chin-ups",uom,"Rest time: 60 sec"},{"Rows",uom,"Rest time: 60 sec"},{"Shrugs",uom,"Rest time: 30 sec"},{"Barbell Curls",uom,"Rest time: 30 sec"},{"Reverse Cable Fly",uom,"Rest time: 15 sec"}};
    public String[][] Legsa = new String[][] {{"Back Squat",uom,"Rest time: 90-120 sec"},{"Good Mornings",uom,"Rest time: 60 sec"},{"Leg Press",uom,"Rest time: 60 sec"},{"Reverse Hyperextension",uom,"Rest time: 30 sec"},{"Leg Curl",uom,"Rest time: 30 sec"},{"Calf Raises",uom,"Rest time: 15 sec"}};
    public String[][] Pushb = new String[][] {{"Overhead Press",uom,"Rest time: 90-120 sec"},{"Incline Bench Press",uom,"Rest time: 60 sec"},{"Close Grip Bench Press",uom,"Rest time: 60 sec"},{"Seated Machine Fly",uom,"Rest time: 30 sec"},{"Tricep Pushdown",uom,"Rest time: 30 sec"},{"Cable Lateral Raises",uom,"Rest time: 15 sec"}};
    public String[][] Pullb = new String[][] {{"Snatch Grip Deadlift",uom,"Rest time: 90-120 sec"},{"Barbell Rows",uom,"Rest time: 60 sec"},{"Pull-ups",uom,"Rest time: 60 sec"},{"1-arm Rows",uom,"Rest time: 30 sec"},{"Incline Dumbbell Curl",uom,"Rest time: 30 sec"},{"Machine Revese Fly",uom,"Rest time: 15 sec"}};
    public String[][] Legsb = new String[][] {{"Front Squat",uom,"Rest time: 90-120 sec"},{"Romanian Deadlifts",uom,"Rest time: 60 sec"},{"Barbell Hip Thrusts",uom,"Rest time: 60 sec"},{"Dubbell Lunges",uom,"Rest time: 30 sec"},{"Leg Extensions",uom,"Rest time: 30 sec"},{"Leg Raises",uom,"Rest time: 15 sec"}};

    CompactCalendarView compactCalendar;

    Button b1, b2, edit, logout, savew, cancelw, savew2, cancelw2, rb1, rb2;

    private CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, ab1, ab2, ab3, ab4, ab5, ab6, ab7, ab8, ab9, hc, hc1, hc2, hc3, hc4, hc5, hc6, a1, a2, a3, a4, a5, a6, a7, a8, a9, ratecard, pullbutton, pushbutton, legbutton, weightbutton, bmibutton, heightbutton, summary;
    private CircleButton cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20, cb21, cb22, cb23, cb24, cb25, cb26;
    private CircleButton hcb1, hcb2, hcb3, hcb4, hcb5, hcb6, hcb7, hcb8, hcb9, hcb10, hcb11, hcb12, hcb13, hcb14, hcb15, hcb16, hcb17, hcb18, hcb19, hcb20, hcb21, hcb22, hcb23, hcb24, hcb25, hcb26;

    private TextView nwe, nwe2, ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8, ct9, ct10, ct11, ct12, ct13, ct14, ct15, ct16, ct17, ct18, ct19, ct20, ct21, ct22, ct23, ct24, ratetext, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, ct25, graphtext, todaytxt, np1, wd, pname, title, sweight, cweight, dweight, weight, height, bmi;
    private TextView h1t1, h1t2, h1t3, h2t1, h2t2, h2t3, h3t1, h3t2, h3t3, h4t1, h4t2, h4t3, h5t1, h5t2, h5t3, h6t1, h6t2, h6t3,uom1,uom2,uom3,uom4,uom5,uom6;
    public TextView tday, tmday, rmday, sumtext;
    private GraphView graph;
    LineGraphSeries < DataPoint > series;
    private ScrollView sc1, sc2, sc3;
    private ImageView picture1;
    private NumberPicker dpick;
    private SeekBar wbar, sbar, sbar2;
    private NumberPicker np;
    private session session;
    private int count2[] = new int[6];
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    private DBmain db;
    private DBpusha db1;
    private DBpulla db2;
    private DBlegsa db3;
    private DBpushb db4;
    private DBpullb db5;
    private DBlegsb db6;
    private DBday db7;
    private DBrating db8;
    private set1 dbs1;
    private set2 dbs2;
    private set3 dbs3;
    private set4 dbs4;
    private set5 dbs5;
    private set6 dbs6;
    private String dayselec = "Monday";
    private RelativeLayout rel1,relpush, relpull, relleg;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash = 1;

        //String formattedDate = df.format(c.getTime()); // to get time
        final String days[];
        days = new String[] {"Mon","Tue","Wed","Thu","Fri","Sat","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        count[0] = 4;
        count[1] = 4;
        count[2] = 4;
        count[3] = 4;
        count[4] = 4;
        count[5] = 9;
        count[6] = 9;
        count[7] = 9;
        count[8] = 9;
        count[9] = 9;
        count[10] = 9;
        count[11] = 11;
        count[12] = 11;
        count[13] = 11;
        count[14] = 11;
        count[15] = 11;
        count[16] = 11;
        count[17] = 11;
        count[18] = 11;
        count[19] = 11;
        count[20] = 11;
        count[21] = 11;
        count[22] = 11;
        count[23] = 11;
        count[24] = 11;
        count[25] = 11;

        //Creating DB classes4
        db = new DBmain(this);
        db1 = new DBpusha(this);
        db2 = new DBpulla(this);
        db3 = new DBlegsa(this);
        db4 = new DBpushb(this);
        db5 = new DBpullb(this);
        db6 = new DBlegsb(this);
        db7 = new DBday(this);
        db8 = new DBrating(this);
        dbs1 = new set1(this);
        dbs2 = new set2(this);
        dbs3 = new set3(this);
        dbs4 = new set4(this);
        dbs5 = new set5(this);
        dbs6 = new set6(this);

        dayselected = Integer.parseInt(db.getday());
        uom = db.getuom()+"";

        Context context = getApplicationContext();

        if (dayselected == 0) {
            dayselec = "Monday";
        } else if (dayselected == 1) {
            dayselec = "Tuesday";
        } else if (dayselected == 2) {
            dayselec = "Wednesday";
        } else if (dayselected == 3) {
            dayselec = "Thursday";
        } else if (dayselected == 4) {
            dayselec = "Friday";
        } else if (dayselected == 5) {
            dayselec = "Saturday";
        } else if (dayselected == 6) {
            dayselec = "Sunday";
        }

        ct25 = (TextView) findViewById(R.id.textView2);
        ct25.setText("Routine start day: " + dayselec);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.swing_up_left);
        final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.swing_up_1);
        final Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.swing_up_2);
        final Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.swing_up_3);
        final Animation animation5 = AnimationUtils.loadAnimation(this, R.anim.swing_up_4);
        final Animation animation6 = AnimationUtils.loadAnimation(this, R.anim.swing_up_5);
        final Animation animation7 = AnimationUtils.loadAnimation(this, R.anim.swing_up_6);
        final Animation animation8 = AnimationUtils.loadAnimation(this, R.anim.swing_up_7);
        final Animation animation9 = AnimationUtils.loadAnimation(this, R.anim.swing_up_8);
        dayselect = dayselected;

        Calendar calendar2 = Calendar.getInstance();
        final int day2 = calendar2.get(Calendar.DAY_OF_WEEK);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {

            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();

                date = dateClicked + "";
                String[] parts = date.split(" ");
                month = parts[1];
                switch (month) {
                    case "Jan":
                        month = "01";
                        break;
                    case "Feb":
                        month = "02";
                        break;
                    case "Mar":
                        month = "03";
                        break;
                    case "Apr":
                        month = "04";
                        break;
                    case "May":
                        month = "05";
                        break;
                    case "Jun":
                        month = "06";
                        break;
                    case "Jul":
                        month = "07";
                        break;
                    case "Aug":
                        month = "08";
                        break;
                    case "Sep":
                        month = "09";
                        break;
                    case "Oct":
                        month = "10";
                        break;
                    case "Nov":
                        month = "11";
                        break;
                    case "Dec":
                        month = "12";
                        break;
                }
                date = parts[2];
                year = parts[5];
                date = year + "-" + month + "-" + date;

                hc.setVisibility(View.GONE);
                hc1.setVisibility(View.GONE);
                hc2.setVisibility(View.GONE);
                hc3.setVisibility(View.GONE);
                hc4.setVisibility(View.GONE);
                hc5.setVisibility(View.GONE);
                hc6.setVisibility(View.GONE);

                if (dateClicked.toString().contains(days[dayselect])) {
                    Toast.makeText(context, "Push A", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().contains(days[dayselect + 1])) {
                    Toast.makeText(context, "Pull A", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().contains(days[dayselect + 2])) {
                    Toast.makeText(context, "Legs A", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().contains(days[dayselect + 3])) {
                    Toast.makeText(context, "Push B", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().contains(days[dayselect + 4])) {
                    Toast.makeText(context, "Pull B", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().contains(days[dayselect + 5])) {
                    Toast.makeText(context, "Legs B", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Rest Day", Toast.LENGTH_SHORT).show();
                }
                history(date);

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {}
        });

        sc1 = (ScrollView) findViewById(R.id.ScrollView01);
        sc2 = (ScrollView) findViewById(R.id.ScrollView02);
        sc3 = (ScrollView) findViewById(R.id.ScrollView03);

        //Initializing Cards
        c1 = (CardView) findViewById(R.id.cardView);
        c2 = (CardView) findViewById(R.id.cardView2);
        c3 = (CardView) findViewById(R.id.cardView3);
        c4 = (CardView) findViewById(R.id.cardView4);
        c5 = (CardView) findViewById(R.id.cardView5);
        c6 = (CardView) findViewById(R.id.cardView6);
        c7 = (CardView) findViewById(R.id.cardView7);
        c8 = (CardView) findViewById(R.id.cardView8);
        c9 = (CardView) findViewById(R.id.cardView9);
        c10 = (CardView) findViewById(R.id.cardView10);
        c11 = (CardView) findViewById(R.id.cardView11);
        c12 = (CardView) findViewById(R.id.cardView12);
        c13 = (CardView) findViewById(R.id.cardView13);
        c14 = (CardView) findViewById(R.id.cardView14);
        c15 = (CardView) findViewById(R.id.cardView15);
        c16 = (CardView) findViewById(R.id.cardView16);
        c17 = (CardView) findViewById(R.id.cardView17);
        c18 = (CardView) findViewById(R.id.cardView18);
        c19 = (CardView) findViewById(R.id.cardView19);
        c20 = (CardView) findViewById(R.id.cardVie);
        c21 = (CardView) findViewById(R.id.cardVw);
        c22 = (CardView) findViewById(R.id.weightcrd);
        c23 = (CardView) findViewById(R.id.weightcrd2);
        c24 = (CardView) findViewById(R.id.weightcard);
        c25 = (CardView) findViewById(R.id.ppcard);
        c26 = (CardView) findViewById(R.id.pscard);
        ab1 = (CardView) findViewById(R.id.cardViewa1);
        ab2 = (CardView) findViewById(R.id.cardViewa2);
        ab3 = (CardView) findViewById(R.id.cardViewa3);
        ab4 = (CardView) findViewById(R.id.cardViewa4);
        ab5 = (CardView) findViewById(R.id.cardViewa5);
        ab6 = (CardView) findViewById(R.id.cardViewa6);
        ab7 = (CardView) findViewById(R.id.cardViewa7);
        ab8 = (CardView) findViewById(R.id.cardViewa8);
        ab9 = (CardView) findViewById(R.id.cardViewa9);
        hc = (CardView) findViewById(R.id.historyc1);
        hc1 = (CardView) findViewById(R.id.h1istoryc1);
        hc2 = (CardView) findViewById(R.id.h2istoryc1);
        hc3 = (CardView) findViewById(R.id.h3istoryc1);
        hc4 = (CardView) findViewById(R.id.h4istoryc1);
        hc5 = (CardView) findViewById(R.id.h5istoryc1);
        hc6 = (CardView) findViewById(R.id.h6istoryc1);
        a1 = (CardView) findViewById(R.id.cardViewa1);
        a2 = (CardView) findViewById(R.id.cardViewa2);
        a3 = (CardView) findViewById(R.id.cardViewa3);
        a4 = (CardView) findViewById(R.id.cardViewa4);
        a5 = (CardView) findViewById(R.id.cardViewa5);
        a6 = (CardView) findViewById(R.id.cardViewa6);
        a7 = (CardView) findViewById(R.id.cardViewa7);
        a8 = (CardView) findViewById(R.id.cardViewa8);
        a9 = (CardView) findViewById(R.id.cardViewa9);
        ratecard = (CardView) findViewById(R.id.rating);
        pushbutton = (CardView) findViewById(R.id.ppcard);
        pullbutton = (CardView) findViewById(R.id.plcard);
        legbutton = (CardView) findViewById(R.id.lcard);
        weightbutton = (CardView) findViewById(R.id.wpcard);
        bmibutton = (CardView) findViewById(R.id.bpcard);
        heightbutton = (CardView) findViewById(R.id.hpcard);
        summary = (CardView) findViewById(R.id.summmary);

        relpush = (RelativeLayout) findViewById(R.id.relpush);
        relpull = (RelativeLayout) findViewById(R.id.relpull);
        relleg = (RelativeLayout) findViewById(R.id.relleg);

        //Initializing Circle Button
        cb1 = (CircleButton) findViewById(R.id.cb1);
        cb2 = (CircleButton) findViewById(R.id.cb2);
        cb3 = (CircleButton) findViewById(R.id.cb3);
        cb4 = (CircleButton) findViewById(R.id.cb4);
        cb5 = (CircleButton) findViewById(R.id.cb5);
        cb6 = (CircleButton) findViewById(R.id.cb21);
        cb7 = (CircleButton) findViewById(R.id.cb22);
        cb8 = (CircleButton) findViewById(R.id.cb23);
        cb9 = (CircleButton) findViewById(R.id.cb31);
        cb10 = (CircleButton) findViewById(R.id.cb32);
        cb11 = (CircleButton) findViewById(R.id.cb33);
        cb12 = (CircleButton) findViewById(R.id.cb41);
        cb13 = (CircleButton) findViewById(R.id.cb42);
        cb14 = (CircleButton) findViewById(R.id.cb43);
        cb15 = (CircleButton) findViewById(R.id.cb44);
        cb16 = (CircleButton) findViewById(R.id.cb45);
        cb17 = (CircleButton) findViewById(R.id.cb51);
        cb18 = (CircleButton) findViewById(R.id.cb52);
        cb19 = (CircleButton) findViewById(R.id.cb53);
        cb20 = (CircleButton) findViewById(R.id.cb54);
        cb21 = (CircleButton) findViewById(R.id.cb55);
        cb22 = (CircleButton) findViewById(R.id.cb61);
        cb23 = (CircleButton) findViewById(R.id.cb62);
        cb24 = (CircleButton) findViewById(R.id.cb63);
        cb25 = (CircleButton) findViewById(R.id.cb64);
        cb26 = (CircleButton) findViewById(R.id.cb65);

        //Initializing Circle Button
        hcb1 = (CircleButton) findViewById(R.id.h1cb1);
        hcb2 = (CircleButton) findViewById(R.id.h1cb2);
        hcb3 = (CircleButton) findViewById(R.id.h1cb3);
        hcb4 = (CircleButton) findViewById(R.id.h1cb4);
        hcb5 = (CircleButton) findViewById(R.id.h1cb5);
        hcb6 = (CircleButton) findViewById(R.id.h2cb1);
        hcb7 = (CircleButton) findViewById(R.id.h2cb2);
        hcb8 = (CircleButton) findViewById(R.id.h2cb3);
        hcb9 = (CircleButton) findViewById(R.id.h3cb1);
        hcb10 = (CircleButton) findViewById(R.id.h3cb2);
        hcb11 = (CircleButton) findViewById(R.id.h3cb3);
        hcb12 = (CircleButton) findViewById(R.id.h4cb1);
        hcb13 = (CircleButton) findViewById(R.id.h4cb2);
        hcb14 = (CircleButton) findViewById(R.id.h4cb3);
        hcb15 = (CircleButton) findViewById(R.id.h4cb4);
        hcb16 = (CircleButton) findViewById(R.id.h4cb5);
        hcb17 = (CircleButton) findViewById(R.id.h5cb1);
        hcb18 = (CircleButton) findViewById(R.id.h5cb2);
        hcb19 = (CircleButton) findViewById(R.id.h5cb3);
        hcb20 = (CircleButton) findViewById(R.id.h5cb4);
        hcb21 = (CircleButton) findViewById(R.id.h5cb5);
        hcb22 = (CircleButton) findViewById(R.id.h6cb1);
        hcb23 = (CircleButton) findViewById(R.id.h6cb2);
        hcb24 = (CircleButton) findViewById(R.id.h6cb3);
        hcb25 = (CircleButton) findViewById(R.id.h6cb4);
        hcb26 = (CircleButton) findViewById(R.id.h6cb5);

        //Initial History text
        h1t1 = (TextView) findViewById(R.id.h1istoryt1);
        h1t2 = (TextView) findViewById(R.id.h1istoryt2);
        h1t3 = (TextView) findViewById(R.id.h1istoryt4);
        h2t1 = (TextView) findViewById(R.id.h2istoryt1);
        h2t2 = (TextView) findViewById(R.id.h2istoryt2);
        h2t3 = (TextView) findViewById(R.id.h2istoryt4);
        h3t1 = (TextView) findViewById(R.id.h3istoryt1);
        h3t2 = (TextView) findViewById(R.id.h3istoryt2);
        h3t3 = (TextView) findViewById(R.id.h3istoryt4);
        h4t1 = (TextView) findViewById(R.id.h4istoryt1);
        h4t2 = (TextView) findViewById(R.id.h4istoryt2);
        h4t3 = (TextView) findViewById(R.id.h4istoryt4);
        h5t1 = (TextView) findViewById(R.id.h5istoryt1);
        h5t2 = (TextView) findViewById(R.id.h5istoryt2);
        h5t3 = (TextView) findViewById(R.id.h5istoryt4);
        h6t1 = (TextView) findViewById(R.id.h6istoryt1);
        h6t2 = (TextView) findViewById(R.id.h6istoryt2);
        h6t3 = (TextView) findViewById(R.id.h6istoryt4);

        //Initial Hi statement
        todaytxt = (TextView) findViewById(R.id.textView40);
        graphtext = (TextView) findViewById(R.id.graphtext);
        sweight = (TextView) findViewById(R.id.startw);
        cweight = (TextView) findViewById(R.id.currw);
        dweight = (TextView) findViewById(R.id.desw);
        weight = (TextView) findViewById(R.id.wtext);
        height = (TextView) findViewById(R.id.htext);
        bmi = (TextView) findViewById(R.id.btext);
        ratetext = (TextView) findViewById(R.id.ratme);
        title = (TextView) findViewById(R.id.textVie1);
        nwe = (TextView) findViewById(R.id.wht);
        nwe2 = (TextView) findViewById(R.id.wht2);
        wbar = (SeekBar) findViewById(R.id.weightbar);
        sbar = (SeekBar) findViewById(R.id.weightbr);
        sbar2 = (SeekBar) findViewById(R.id.weightbr2);
        d7 = (TextView) findViewById(R.id.wtex1t);
        d8 = (TextView) findViewById(R.id.b1text);
        d9 = (TextView) findViewById(R.id.ht1ext);
        d10 = (TextView) findViewById(R.id.graphtext);


        uom1 = (TextView) findViewById(R.id.h1istoryt5);
        uom1.setText(uom);
        uom2 = (TextView) findViewById(R.id.h2istoryt5);
        uom2.setText(uom);
        uom3 = (TextView) findViewById(R.id.h3istoryt5);
        uom3.setText(uom);
        uom4 = (TextView) findViewById(R.id.h4istoryt5);
        uom4.setText(uom);
        uom5 = (TextView) findViewById(R.id.h5istoryt5);
        uom5.setText(uom);
        uom6 = (TextView) findViewById(R.id.h6istoryt5);
        uom6.setText(uom);

        
        todaytxt.setText("Hi " + db.getname() + ",");
        nwe.setText(db.sweight() + uom);
        nwe2.setText(db.sweight() + uom);
        weight.setText(db.sweight() + " " + uom);
        try {
            int progress = Integer.parseInt(db.height());
            if(uom.equals("lbs")) {
                int inches = progress / 2;
                int feet = inches / 12;
                int leftover = inches % 12;
                height.setText(feet + 4 + "' " + leftover + "\"");
                int inchesb = inches + 48;
                bmi.setText("BMI: " + (703 * Integer.parseInt(db.sweight())) / (inchesb * inchesb));
            }else{
                int inches = progress / 2;
                int feet = inches / 12;
                int leftover = inches % 12;
                height.setText(feet + 4 + "' " + leftover + "\"");
                int inchesb = inches + 48;
                bmi.setText("BMI: " +(int) Math.round((703 * Integer.parseInt(db.sweight()) * 2.20462) / (inchesb * inchesb)));
            }
        } catch (Exception e) {

           Toast.makeText(context, "You need to setup your profile again to show your height and BMI", Toast.LENGTH_LONG).show();
        }


        if (!db.geturl().equals("")) {
            ImageView pImage = (ImageView) findViewById(R.id.imgProfilePic);
            Glide.with(this).load(db.geturl()).crossFade().override(100, 100).into(pImage);
        }
        pname = (TextView) findViewById(R.id.profile1);
        pname.setText(db.getfullname());

        sbar.setProgress(50);
        sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int prog = (progress - 50);
                nwe.setText((Integer.parseInt(db.sweight()) + prog) + uom);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        wbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int a = 0, c = 0;
                if (db7.getdweight() > db7.getcweight()) {
                    a = db7.getsweight();
                    c = db7.getdweight();
                } else if (db7.getdweight() < db7.getcweight()) {
                    c = db7.getsweight();
                    a = db7.getdweight();

                }
                int btm = c - a;
                cweight.setText("Current " + (int) Math.round((((double)(wbar.getProgress())) / 100) * btm + a) + uom);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        if (goal1 == 2) {
            c22.setVisibility(View.GONE);
        }
        if (goal1 == 1) {
            c23.setVisibility(View.GONE);
            c22.setVisibility(View.GONE);
        }

        try {
            int tt = db7.getdweight();
            c23.setVisibility(View.GONE);
            c22.setVisibility(View.GONE);
            sweight.setText("Start " + db7.getsweight() + uom);
            cweight.setText("Current " + db7.getcweight() + uom);
            dweight.setText("Goal " + db7.getdweight() + uom);
            try {
                double bar = 0;
                int a = 0, b = 0, c = 0;
                if (db7.getdweight() > db7.getcweight()) {
                    a = db7.getsweight();
                    b = db7.getcweight();
                    c = db7.getdweight();
                } else if (db7.getdweight() < db7.getcweight()) {
                    c = db7.getsweight();
                    b = db7.getcweight();
                    a = db7.getdweight();

                }
                int btm = c - a;
                int top = b - a;
                bar = (((double)(top)) / ((double)(btm))) * 100;
                int y = (int) Math.round(bar);
                wbar.setProgress(y);

            } catch (Exception e) {
                c24.setVisibility(View.GONE);
            }
        } catch (Exception e) {

        }
        cancelw2 = (Button) findViewById(R.id.wupdate);
        cancelw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0, c = 0;
                if (db7.getdweight() > db7.getcweight()) {
                    a = db7.getsweight();
                    c = db7.getdweight();
                } else if (db7.getdweight() < db7.getcweight()) {
                    c = db7.getsweight();
                    a = db7.getdweight();

                }
                int btm = c - a;
                db7.update(db7.getsweight(), (int) Math.round((((double)(wbar.getProgress())) / 100) * btm + a), db7.getdweight());
                cweight.setText("Current " + db7.getcweight() + uom);

            }
        });


        savew = (Button) findViewById(R.id.wsave);
        savew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c23.setVisibility(View.GONE);
                c22.setVisibility(View.GONE);
                db7.update(Integer.parseInt(db.sweight()), Integer.parseInt(db.sweight()), Integer.parseInt(db.sweight()) + sbar.getProgress() - 50);

                goal1 = 1;
                sweight.setText("Start " + db7.getsweight() + uom);
                cweight.setText("Current " + db7.getcweight() + uom);
                dweight.setText("Goal " + db7.getdweight() + uom);
                try {
                    double bar = 0;
                    int a = 0, b = 0, c = 0;
                    if (db7.getdweight() > db7.getcweight()) {
                        a = db7.getsweight();
                        b = db7.getcweight();
                        c = db7.getdweight();
                    } else if (db7.getdweight() < db7.getcweight()) {
                        c = db7.getsweight();
                        b = db7.getcweight();
                        a = db7.getdweight();

                    }
                    int btm = c - a;
                    int top = b - a;
                    bar = (((double)(top)) / ((double)(btm))) * 100;
                    int y = (int) Math.round(bar);
                    wbar.setProgress(y);

                } catch (Exception e) {
                    c24.setVisibility(View.GONE);
                }
            }
        });

        cancelw = (Button) findViewById(R.id.wnnow);
        cancelw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c22.setVisibility(View.GONE);
                goal1 = 2;
            }
        });

        rb1 = (Button) findViewById(R.id.notnow);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratetext.setTextSize(16);
                if (rate == 0) {
                    ratetext.setText("Would you mind giving us some feedback?");
                    rb1.setText("No, Thanks");
                    rb2.setText("Ok, Sure");
                    rate = 1;
                } else {
                    ratecard.setVisibility(View.GONE);
                    rate = 30;
                    db8.update(rate, 0, 0);
                }
            }
        });

        rb2 = (Button) findViewById(R.id.ratebutton);
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratetext.setTextSize(16);
                if (rate == 0) {
                    ratetext.setText("How about rating us on the Play Store, then?");
                    rb1.setText("No, Thanks");
                    rb2.setText("Ok, Sure");
                    rate = 2;
                } else if (rate == 1) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", "contact@bavakesavan.com", null));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Push Pull Legs - Feedback");
                    intent.putExtra(Intent.EXTRA_TEXT, "I am some having trouble with your app.");
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                    ratecard.setVisibility(View.GONE);
                    rate = 20;
                    db8.update(rate, 0, 0);
                } else if (rate == 2) {
                    Context context = getApplicationContext();
                    Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    // To count with Play market backstack, After pressing back button,
                    // to taken back to our application, we need to add following flags to intent.
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=kesavan.studios.kesav.pushpull" + context.getPackageName())));
                    }
                    ratecard.setVisibility(View.GONE);
                    db8.update(rate, 0, 0);
                }
            }
        });

        sbar2.setProgress(50);
        sbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int prog = (progress - 50);
                nwe2.setText((Integer.parseInt(db.sweight()) + prog) + uom);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        savew2 = (Button) findViewById(R.id.wsave2);
        savew2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c23.setVisibility(View.GONE);
                c22.setVisibility(View.GONE);
                db7.update(Integer.parseInt(db.sweight()), Integer.parseInt(db.sweight()), Integer.parseInt(db.sweight()) + sbar2.getProgress() - 50);
                goal1 = 1;
                sweight.setText("Start " + db7.getsweight() + uom);
                cweight.setText("Current " + db7.getcweight() + uom);
                dweight.setText("Goal " + db7.getdweight() + uom);
                try {
                    double bar = 0;
                    int a = 0, b = 0, c = 0;
                    if (db7.getdweight() > db7.getcweight()) {
                        a = db7.getsweight();
                        b = db7.getcweight();
                        c = db7.getdweight();
                    } else if (db7.getdweight() < db7.getcweight()) {
                        c = db7.getsweight();
                        b = db7.getcweight();
                        a = db7.getdweight();

                    }
                    int btm = c - a;
                    int top = b - a;
                    bar = (((double)(top)) / ((double)(btm))) * 100;
                    int y = (int) Math.round(bar);
                    wbar.setProgress(y);

                } catch (Exception e) {
                    c24.setVisibility(View.GONE);
                }
            }
        });


        c12 = (CardView) findViewById(R.id.cardView12);
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abs = 1;
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);
                c20.setVisibility(View.VISIBLE);
                c21.setVisibility(View.VISIBLE);
                sc1.setVisibility(View.VISIBLE);
                sc2.setVisibility(View.GONE);
                a1.setVisibility(View.VISIBLE);
                a2.setVisibility(View.VISIBLE);
                a3.setVisibility(View.VISIBLE);
                a4.setVisibility(View.VISIBLE);
                a5.setVisibility(View.VISIBLE);
                a6.setVisibility(View.VISIBLE);
                a7.setVisibility(View.VISIBLE);
                a8.setVisibility(View.VISIBLE);
                a9.setVisibility(View.VISIBLE);

                countera = 0;

                title.setText("Ab Workout");
                start = 3;
                page = 99;

            }
        });

        //Main screen buttons
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);
                today(day2, dayselected);

                if (excer == Rest) {

                    Context context = getApplicationContext();
                    Toast.makeText(context, "Take a break, it's your rest day", Toast.LENGTH_SHORT).show();
                } else {
                    c20.setVisibility(View.VISIBLE);
                    c21.setVisibility(View.VISIBLE);
                    sc1.setVisibility(View.VISIBLE);
                    sc2.setVisibility(View.GONE);

                    page = 2;
                    start = 1;
                    dbb = 0;

                    if (excer == Pusha) {
                        dbb = 1;
                        title.setText("Push A");
                    } else if (excer == Pulla) {
                        dbb = 2;
                        title.setText("Pull A");
                    } else if (excer == Legsa) {
                        dbb = 3;
                        title.setText("Legs A");
                    } else if (excer == Pushb) {
                        dbb = 4;
                        title.setText("Push B");
                    } else if (excer == Pullb) {
                        dbb = 5;
                        title.setText("Pull B");
                    } else if (excer == Legsb) {
                        dbb = 6;
                        title.setText("Legs B");
                    }
                    count2[0] = 0;
                    count2[1] = 0;
                    count2[2] = 0;
                    count2[3] = 0;
                    count2[4] = 0;
                    count2[5] = 0;

                    new_workout = 1;
                    updatecards();
                }
            }
        });

        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);

                c20.setVisibility(View.VISIBLE);
                title.setText("Push A");
                excer = Pusha;
                sc1.setVisibility(View.VISIBLE);
                sc2.setVisibility(View.GONE);
                dbb = 1;
                page = 2;
                start = 1;
                new_workout = 1;
                count2[0] = 0;
                count2[1] = 0;
                count2[2] = 0;
                count2[3] = 0;
                count2[4] = 0;
                count2[5] = 0;

                updatecards();
            }
        });

        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);
                c20.setVisibility(View.VISIBLE);
                title.setText("Pull A");
                excer = Pulla;
                sc1.setVisibility(View.VISIBLE);
                sc2.setVisibility(View.GONE);
                dbb = 2;
                page = 2;
                start = 1;
                new_workout = 1;
                count2[0] = 0;
                count2[1] = 0;
                count2[2] = 0;
                count2[3] = 0;
                count2[4] = 0;
                count2[5] = 0;

                updatecards();
            }
        });

        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);

                c20.setVisibility(View.VISIBLE);
                title.setText("Legs A");
                excer = Legsa;
                sc1.setVisibility(View.VISIBLE);
                sc2.setVisibility(View.GONE);
                dbb = 3;
                page = 2;
                start = 1;
                new_workout = 1;
                count2[0] = 0;
                count2[1] = 0;
                count2[2] = 0;
                count2[3] = 0;
                count2[4] = 0;
                count2[5] = 0;

                updatecards();
            }
        });

        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);

                c20.setVisibility(View.VISIBLE);
                title.setText("Push B");
                excer = Pushb;
                sc1.setVisibility(View.VISIBLE);
                sc2.setVisibility(View.GONE);
                dbb = 4;
                page = 2;
                start = 1;
                new_workout = 1;
                count2[0] = 0;
                count2[1] = 0;
                count2[2] = 0;
                count2[3] = 0;
                count2[4] = 0;
                count2[5] = 0;

                updatecards();
            }
        });

        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);

                c20.setVisibility(View.VISIBLE);
                title.setText("Pull B");
                excer = Pullb;
                sc1.setVisibility(View.VISIBLE);
                sc2.setVisibility(View.GONE);
                dbb = 5;
                page = 2;
                start = 1;
                new_workout = 1;
                count2[0] = 0;
                count2[1] = 0;
                count2[2] = 0;
                count2[3] = 0;
                count2[4] = 0;
                count2[5] = 0;

                updatecards();
            }
        });

        c18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1.fullScroll(ScrollView.FOCUS_UP);
                sc2.fullScroll(ScrollView.FOCUS_UP);

                c20.setVisibility(View.VISIBLE);
                title.setText("Legs B");
                excer = Legsb;
                sc1.setVisibility(View.VISIBLE);
                sc2.setVisibility(View.GONE);
                dbb = 6;
                page = 2;
                start = 1;
                new_workout = 1;
                count2[0] = 0;
                count2[1] = 0;
                count2[2] = 0;
                count2[3] = 0;
                count2[4] = 0;
                count2[5] = 0;

                updatecards();

            }
        });

        ab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(1);
            }
        });
        ab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(2);
            }
        });
        ab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(3);
            }
        });
        ab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(4);
            }
        });
        ab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(5);
            }
        });
        ab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(6);
            }
        });
        ab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(7);
            }
        });
        ab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(8);
            }
        });
        ab9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture(9);
            }
        });


        //Initialzing textboxes and done action listener
        ct1 = (TextView) findViewById(R.id.textView7);
        ct2 = (TextView) findViewById(R.id.textView9);
        ct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbbb = 1;
                openDialog(1);
            }
        });
        ct3 = (TextView) findViewById(R.id.textView10);
        ct4 = (TextView) findViewById(R.id.textView14);
        ct5 = (TextView) findViewById(R.id.textView27);
        ct6 = (TextView) findViewById(R.id.textView29);
        ct6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbbb = 2;
                openDialog(2);
            }
        });
        ct7 = (TextView) findViewById(R.id.textView210);
        ct8 = (TextView) findViewById(R.id.textView214);
        ct9 = (TextView) findViewById(R.id.textView37);
        ct10 = (TextView) findViewById(R.id.textView39);
        ct10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbbb = 3;
                openDialog(3);
            }
        });
        ct11 = (TextView) findViewById(R.id.textView310);
        ct12 = (TextView) findViewById(R.id.textView314);
        ct13 = (TextView) findViewById(R.id.textView47);
        ct14 = (TextView) findViewById(R.id.textView49);
        ct14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbbb = 4;
                openDialog(4);
            }
        });
        ct15 = (TextView) findViewById(R.id.textView410);
        ct16 = (TextView) findViewById(R.id.textView414);
        ct17 = (TextView) findViewById(R.id.textView57);
        ct18 = (TextView) findViewById(R.id.textView59);
        ct18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbbb = 5;
                openDialog(5);
            }
        });
        ct19 = (TextView) findViewById(R.id.textView510);
        ct20 = (TextView) findViewById(R.id.textView514);
        ct21 = (TextView) findViewById(R.id.textView67);
        ct22 = (TextView) findViewById(R.id.textView69);
        ct22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbbb = 6;
                openDialog(6);
            }
        });
        ct23 = (TextView) findViewById(R.id.textView610);
        ct24 = (TextView) findViewById(R.id.textView614);

        tday = (TextView) findViewById(R.id.textView13);
        tmday = (TextView) findViewById(R.id.textView21);
        rmday = (TextView) findViewById(R.id.textView22);

        //Swipe animation
        if (splash == 1) {
            splash = 2;

            c11.startAnimation(animation9);
            c12.startAnimation(animation2);
            c13.startAnimation(animation3);
            c14.startAnimation(animation4);
            c15.startAnimation(animation5);
            c16.startAnimation(animation6);
            c17.startAnimation(animation7);
            c18.startAnimation(animation8);
            c22.startAnimation(animation2);
        }

        //Done exercise
        d1 = (TextView) findViewById(R.id.textView11);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[0] == 4) {
                    count[0] = 3;
                }
                if (count[1] == 4) {
                    count[1] = 3;
                }
                if (count[2] == 4) {
                    count[2] = 3;
                }
                if (count[3] == 4) {
                    count[3] = 3;
                }
                if (count[4] == 4) {
                    count[4] = 3;
                }
                dbs1.update(count[0], count[1], count[2], count[3], count[4], dbb, df.format(c.getTime())+ "");
                updatedb();
                c1.startAnimation(animation);
                count2[0] = 1;
                new CountDownTimer(500, 50) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        c1.setVisibility(View.GONE);
                        workoutstatus();
                    }

                    public void onTick(long millisUntilFinished) {
                        if (millisUntilFinished == 498) {
                            c1.startAnimation(animation);
                        }
                    }
                }.start();
            }
        });

        d2 = (TextView) findViewById(R.id.textView211);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[5] == 9) {
                    count[5] = 8;
                }
                if (count[6] == 9) {
                    count[6] = 8;
                }
                if (count[7] == 9) {
                    count[7] = 8;
                }
                dbs2.update(count[5], count[6], count[7], dbb, df.format(c.getTime())+ "");
                updatedb();
                c2.startAnimation(animation);
                count2[1] = 1;
                new CountDownTimer(500, 50) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        c2.setVisibility(View.GONE);
                        workoutstatus();
                    }

                    public void onTick(long millisUntilFinished) {
                        if (millisUntilFinished == 499) {
                            c2.startAnimation(animation);

                        }
                    }
                }.start();
            }
        });

        d3 = (TextView) findViewById(R.id.textView311);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[8] == 9) {
                    count[8] = 8;
                }
                if (count[9] == 9) {
                    count[9] = 8;
                }
                if (count[10] == 9) {
                    count[10] = 8;
                }
                dbs3.update(count[8], count[9], count[10], dbb, df.format(c.getTime())+ "");
                updatedb();
                c3.startAnimation(animation);
                count2[2] = 1;
                new CountDownTimer(500, 50) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        c3.setVisibility(View.GONE);
                    }

                    public void onTick(long millisUntilFinished) {
                        if (millisUntilFinished == 499) {
                            c3.startAnimation(animation);
                        }
                    }
                }.start();
            }
        });

        d4 = (TextView) findViewById(R.id.textView411);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[11] == 11) {
                    count[11] = 10;
                }
                if (count[12] == 11) {
                    count[12] = 10;
                }
                if (count[13] == 11) {
                    count[13] = 10;
                }
                if (count[14] == 11) {
                    count[14] = 10;
                }
                if (count[15] == 11) {
                    count[15] = 10;
                }
                dbs4.update(count[11], count[12], count[13], count[14], count[15], dbb, df.format(c.getTime())+ "");
                updatedb();
                c4.startAnimation(animation);
                count2[3] = 1;
                new CountDownTimer(500, 50) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        c4.setVisibility(View.GONE);
                        workoutstatus();
                    }

                    public void onTick(long millisUntilFinished) {
                        if (millisUntilFinished == 499) {
                            c4.startAnimation(animation);
                        }
                    }
                }.start();
            }
        });

        d5 = (TextView) findViewById(R.id.textView511);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[16] == 11) {
                    count[16] = 10;
                }
                if (count[17] == 11) {
                    count[17] = 10;
                }
                if (count[18] == 11) {
                    count[18] = 10;
                }
                if (count[19] == 11) {
                    count[19] = 10;
                }
                if (count[20] == 11) {
                    count[20] = 10;
                }
                dbs5.update(count[16], count[17], count[18], count[19], count[20], dbb, df.format(c.getTime())+ "");
                updatedb();
                c5.startAnimation(animation);
                count2[4] = 1;
                new CountDownTimer(500, 50) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        c5.setVisibility(View.GONE);
                        workoutstatus();
                    }

                    public void onTick(long millisUntilFinished) {
                        if (millisUntilFinished == 499) {
                            c5.startAnimation(animation);
                        }
                    }
                }.start();
            }
        });

        d6 = (TextView) findViewById(R.id.textView611);
        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[21] == 11) {
                    count[21] = 10;
                }
                if (count[22] == 11) {
                    count[22] = 10;
                }
                if (count[23] == 11) {
                    count[23] = 10;
                }
                if (count[24] == 11) {
                    count[24] = 10;
                }
                if (count[25] == 11) {
                    count[25] = 10;
                }
                dbs6.update(count[21], count[22], count[23], count[24], count[25], dbb, df.format(c.getTime())+ "");
                updatedb();
                c6.startAnimation(animation);
                count2[5] = 1;
                new CountDownTimer(500, 50) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        c6.setVisibility(View.GONE);
                        workoutstatus();
                    }

                    public void onTick(long millisUntilFinished) {
                        if (millisUntilFinished == 499) {
                            c6.startAnimation(animation);
                        }
                    }
                }.start();
            }
        });

        edit = (Button) findViewById(R.id.editprof);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signin.class);
                startActivity(intent);
            }
        });

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin.signout();
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putBoolean(getString(R.string.pref_previously_started), Boolean.FALSE);
                edit.commit();
                Intent intent = new Intent(getApplicationContext(), signin.class);
                startActivity(intent);
            }
        });

        graph = (GraphView) findViewById(R.id.pushgraph);
        graph.removeAllSeries();
        LineGraphSeries < DataPoint > series = new LineGraphSeries < > (data(0,0));
        graph.addSeries(series);
        series.setColor(Color.parseColor("#af3067"));
        graphtext.setText("Bench Press");
        graphtext.setVisibility(View.VISIBLE);

        pushbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graph.removeAllSeries();
                LineGraphSeries < DataPoint > series1 = new LineGraphSeries < > (data(0,pg1));
                sc3.fullScroll(View.FOCUS_DOWN);
                if (pg1 == 0){
                    pg1=1;
                    d7.setText("Push - A");
                    d10.setText(Pusha[0][0]+"");
                }else{
                    pg1=0;
                    d7.setText("Push - B");
                    d10.setText(Pushb[0][0]+"");
                }
                series1.setColor(Color.parseColor("#af3067"));
                graph.addSeries(series1);
                graph.setVisibility(View.VISIBLE);
            }
        });
        pullbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graph.removeAllSeries();
                LineGraphSeries < DataPoint > series2 = new LineGraphSeries < > (data(1,pg2));
                sc3.fullScroll(View.FOCUS_DOWN);
                if (pg2 == 0){
                    pg2++;
                    d8.setText("Pull - A");
                    d10.setText(Pulla[0][0]+"");
                }else{
                    pg2=0;
                    d8.setText("Pull - B");
                    d10.setText(Pullb[0][0]+"");
                }
                series2.setColor(Color.parseColor("#af3067"));
                graph.addSeries(series2);
                graph.setVisibility(View.VISIBLE);
            }
        });
        legbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graph.removeAllSeries();
                LineGraphSeries < DataPoint > series3 = new LineGraphSeries < > (data(2,pg3));
                sc3.fullScroll(View.FOCUS_DOWN);
                if (pg3 == 0){
                    pg3++;
                    d9.setText("Legs - A");
                    d10.setText(Legsa[0][0]+"");
                }else{
                    pg3=0;
                    d9.setText("Legs - B");
                    d10.setText(Legsb[0][0]+"");
                }
                series3.setColor(Color.parseColor("#af3067"));
                graph.addSeries(series3);
                graph.setVisibility(View.VISIBLE);
            }
        });
        weightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        bmibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bcount ==0) {
                    hcount=0;
                    heightbutton.setBackgroundColor(Color.parseColor("#424242"));
                    summary.setVisibility(View.VISIBLE);
                    bmibutton.setBackgroundColor(Color.parseColor("#555555"));
                    TextView sumText = (TextView) findViewById(R.id.sum);
                    sumText.setText("Know more about yourself");
                    ImageView sumImage = (ImageView) findViewById(R.id.hspic);
                    sumImage.setImageResource(R.drawable.bmiinfo);
                    bcount++;
                }else{
                    bcount=0;
                    hcount=0;
                    summary.setVisibility(View.GONE);
                    bmibutton.setBackgroundColor(Color.parseColor("#424242"));
                }
            }
        });

        heightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hcount ==0) {
                    bcount=0;
                    bmibutton.setBackgroundColor(Color.parseColor("#424242"));
                    TextView sumText = (TextView) findViewById(R.id.sum);
                    summary.setVisibility(View.VISIBLE);
                    sumText.setText("Stand Up Straight");
                    heightbutton.setBackgroundColor(Color.parseColor("#555555"));
                    ImageView sumImage = (ImageView) findViewById(R.id.hspic);
                    sumImage.setImageResource(R.drawable.heightprogress);
                    hcount++;
                }else{
                    hcount=0;
                    bcount=0;
                    summary.setVisibility(View.GONE);
                    heightbutton.setBackgroundColor(Color.parseColor("#424242"));
                }
            }
        });

        //Bottom navigation action listener
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        sc1.fullScroll(ScrollView.FOCUS_UP);
                        sc2.fullScroll(ScrollView.FOCUS_UP);
                        sc3.fullScroll(ScrollView.FOCUS_UP);

                        switch (item.getItemId()) {
                            case R.id.home:

                                if (db8.getrating() == 9) {
                                    rate = 0;
                                    ratecard.setVisibility(View.VISIBLE);

                                }
                                sc3.setVisibility(View.GONE);
                                if (start == 0) {
                                    sc1.setVisibility(View.GONE);
                                    sc2.setVisibility(View.VISIBLE);
                                    page = 1;
                                } else if (start == 99) {
                                    c21.setVisibility(View.VISIBLE);
                                    if (countera == 0) {
                                        a1.setVisibility(View.VISIBLE);
                                        a2.setVisibility(View.VISIBLE);
                                        a3.setVisibility(View.VISIBLE);
                                        a4.setVisibility(View.VISIBLE);
                                        a5.setVisibility(View.VISIBLE);
                                        a6.setVisibility(View.VISIBLE);
                                        a7.setVisibility(View.VISIBLE);
                                        a8.setVisibility(View.VISIBLE);
                                        a9.setVisibility(View.VISIBLE);
                                        if (rate == 0) {
                                            ratecard.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    c20.setVisibility(View.VISIBLE);
                                    page = 99;
                                } else {
                                    c21.setVisibility(View.VISIBLE);
                                    if (count2[0] == 0) {
                                        c1.setVisibility(View.VISIBLE);
                                    }
                                    if (count2[1] == 0) {
                                        c2.setVisibility(View.VISIBLE);
                                    }
                                    if (count2[2] == 0) {
                                        c3.setVisibility(View.VISIBLE);
                                    }
                                    if (count2[3] == 0) {
                                        c4.setVisibility(View.VISIBLE);
                                    }
                                    if (count2[4] == 0) {
                                        c5.setVisibility(View.VISIBLE);
                                    }
                                    if (count2[5] == 0) {
                                        c6.setVisibility(View.VISIBLE);
                                    }
                                    c20.setVisibility(View.VISIBLE);
                                    page = 2;
                                }
                                c7.setVisibility(View.GONE);
                                c8.setVisibility(View.GONE);
                                c9.setVisibility(View.GONE);
                                c10.setVisibility(View.GONE);
                                c19.setVisibility(View.GONE);
                                hc.setVisibility(View.GONE);
                                hc1.setVisibility(View.GONE);
                                hc2.setVisibility(View.GONE);
                                hc3.setVisibility(View.GONE);
                                hc4.setVisibility(View.GONE);
                                hc5.setVisibility(View.GONE);
                                hc6.setVisibility(View.GONE);
                                return true;
                            case R.id.calender:
                                history(df.format(c.getTime())+ "");
                                sc1.setVisibility(View.VISIBLE);
                                sc2.setVisibility(View.GONE);
                                sc3.setVisibility(View.GONE);
                                c1.setVisibility(View.GONE);
                                c2.setVisibility(View.GONE);
                                c3.setVisibility(View.GONE);
                                c4.setVisibility(View.GONE);
                                c5.setVisibility(View.GONE);
                                c6.setVisibility(View.GONE);
                                a1.setVisibility(View.GONE);
                                a2.setVisibility(View.GONE);
                                a3.setVisibility(View.GONE);
                                a4.setVisibility(View.GONE);
                                a5.setVisibility(View.GONE);
                                a6.setVisibility(View.GONE);
                                a7.setVisibility(View.GONE);
                                a8.setVisibility(View.GONE);
                                a9.setVisibility(View.GONE);
                                c7.setVisibility(View.VISIBLE);
                                c8.setVisibility(View.VISIBLE);
                                c9.setVisibility(View.VISIBLE);
                                c10.setVisibility(View.VISIBLE);
                                c19.setVisibility(View.VISIBLE);
                                c20.setVisibility(View.INVISIBLE);
                                c21.setVisibility(View.GONE);
                                page = 3;
                                return true;
                            case R.id.settings:

                                graph.setVisibility(View.VISIBLE);
                                sc2.setVisibility(View.INVISIBLE);
                                c20.setVisibility(View.INVISIBLE);
                                c21.setVisibility(View.GONE);
                                sc3.setVisibility(View.VISIBLE);
                                c25.setVisibility(View.VISIBLE);
                                c26.setVisibility(View.VISIBLE);
                                c7.setVisibility(View.GONE);
                                c8.setVisibility(View.GONE);
                                c9.setVisibility(View.GONE);
                                c10.setVisibility(View.GONE);
                                c19.setVisibility(View.GONE);
                                hc.setVisibility(View.GONE);
                                hc1.setVisibility(View.GONE);
                                hc2.setVisibility(View.GONE);
                                hc3.setVisibility(View.GONE);
                                hc4.setVisibility(View.GONE);
                                hc5.setVisibility(View.GONE);
                                hc6.setVisibility(View.GONE);
                                page = 4;
                                return true;
                        }
                        return false;
                    }
                });

        //Circle button
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[0] == 0) {
                    count[0] = 3;
                } else {
                    count[0] = count[0] - 1;
                }

                if (count[0] == 3) {
                    cb1.setImageResource(R.drawable.ic_3);
                } else if (count[0] == 2) {
                    cb1.setImageResource(R.drawable.ic_2);
                } else if (count[0] == 1) {
                    cb1.setImageResource(R.drawable.ic_1);
                } else if (count[0] == 0) {
                    cb1.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[1] == 0) {
                    count[1] = 3;
                } else {
                    count[1] = count[1] - 1;
                }

                if (count[1] == 3) {
                    cb2.setImageResource(R.drawable.ic_3);
                } else if (count[1] == 2) {
                    cb2.setImageResource(R.drawable.ic_2);
                } else if (count[1] == 1) {
                    cb2.setImageResource(R.drawable.ic_1);
                } else if (count[1] == 0) {
                    cb2.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[2] == 0) {
                    count[2] = 3;
                } else {
                    count[2] = count[2] - 1;
                }

                if (count[2] == 3) {
                    cb3.setImageResource(R.drawable.ic_3);
                } else if (count[2] == 2) {
                    cb3.setImageResource(R.drawable.ic_2);
                } else if (count[2] == 1) {
                    cb3.setImageResource(R.drawable.ic_1);
                } else if (count[2] == 0) {
                    cb3.setImageResource(R.drawable.ic_0);
                }

            }
        });

        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[3] == 0) {
                    count[3] = 3;
                } else {
                    count[3] = count[3] - 1;
                }

                if (count[3] == 3) {
                    cb4.setImageResource(R.drawable.ic_3);
                } else if (count[3] == 2) {
                    cb4.setImageResource(R.drawable.ic_2);
                } else if (count[3] == 1) {
                    cb4.setImageResource(R.drawable.ic_1);
                } else if (count[3] == 0) {
                    cb4.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[4] == 0) {
                    count[4] = 3;
                } else {
                    count[4] = count[4] - 1;
                }

                if (count[4] == 3) {
                    cb5.setImageResource(R.drawable.ic_3);
                } else if (count[4] == 2) {
                    cb5.setImageResource(R.drawable.ic_2);
                } else if (count[4] == 1) {
                    cb5.setImageResource(R.drawable.ic_1);
                } else if (count[4] == 0) {
                    cb5.setImageResource(R.drawable.ic_0);
                }

            }
        });

        cb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[5] == 0) {
                    count[5] = 8;
                } else {
                    count[5] = count[5] - 1;
                }

                if (count[5] == 8) {
                    cb6.setImageResource(R.drawable.ic_8);
                } else if (count[5] == 7) {
                    cb6.setImageResource(R.drawable.ic_7);
                } else if (count[5] == 6) {
                    cb6.setImageResource(R.drawable.ic_6);
                } else if (count[5] == 5) {
                    cb6.setImageResource(R.drawable.ic_5);
                } else if (count[5] == 4) {
                    cb6.setImageResource(R.drawable.ic_4);
                } else if (count[5] == 3) {
                    cb6.setImageResource(R.drawable.ic_3);
                } else if (count[5] == 2) {
                    cb6.setImageResource(R.drawable.ic_2);
                } else if (count[5] == 1) {
                    cb6.setImageResource(R.drawable.ic_1);
                } else if (count[5] == 0) {
                    cb6.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[6] == 0) {
                    count[6] = 8;
                } else {
                    count[6] = count[6] - 1;
                }

                if (count[6] == 8) {
                    cb7.setImageResource(R.drawable.ic_8);
                } else if (count[6] == 7) {
                    cb7.setImageResource(R.drawable.ic_7);
                } else if (count[6] == 6) {
                    cb7.setImageResource(R.drawable.ic_6);
                } else if (count[6] == 5) {
                    cb7.setImageResource(R.drawable.ic_5);
                } else if (count[6] == 4) {
                    cb7.setImageResource(R.drawable.ic_4);
                } else if (count[6] == 3) {
                    cb7.setImageResource(R.drawable.ic_3);
                } else if (count[6] == 2) {
                    cb7.setImageResource(R.drawable.ic_2);
                } else if (count[6] == 1) {
                    cb7.setImageResource(R.drawable.ic_1);
                } else if (count[6] == 0) {
                    cb7.setImageResource(R.drawable.ic_0);
                }

            }
        });

        cb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[7] == 0) {
                    count[7] = 8;
                } else {
                    count[7] = count[7] - 1;
                }

                if (count[7] == 8) {
                    cb8.setImageResource(R.drawable.ic_8);
                } else if (count[7] == 7) {
                    cb8.setImageResource(R.drawable.ic_7);
                } else if (count[7] == 6) {
                    cb8.setImageResource(R.drawable.ic_6);
                } else if (count[7] == 5) {
                    cb8.setImageResource(R.drawable.ic_5);
                } else if (count[7] == 4) {
                    cb8.setImageResource(R.drawable.ic_4);
                } else if (count[7] == 3) {
                    cb8.setImageResource(R.drawable.ic_3);
                } else if (count[7] == 2) {
                    cb8.setImageResource(R.drawable.ic_2);
                } else if (count[7] == 1) {
                    cb8.setImageResource(R.drawable.ic_1);
                } else if (count[7] == 0) {
                    cb8.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[8] == 0) {
                    count[8] = 10;
                } else {
                    count[8] = count[8] - 1;
                }

                if (count[8] == 10) {
                    cb9.setImageResource(R.drawable.ic_10);
                } else if (count[8] == 9) {
                    cb9.setImageResource(R.drawable.ic_9);
                } else if (count[8] == 8) {
                    cb9.setImageResource(R.drawable.ic_8);
                } else if (count[8] == 7) {
                    cb9.setImageResource(R.drawable.ic_7);
                } else if (count[8] == 6) {
                    cb9.setImageResource(R.drawable.ic_6);
                } else if (count[8] == 5) {
                    cb9.setImageResource(R.drawable.ic_5);
                } else if (count[8] == 4) {
                    cb9.setImageResource(R.drawable.ic_4);
                } else if (count[8] == 3) {
                    cb9.setImageResource(R.drawable.ic_3);
                } else if (count[8] == 2) {
                    cb9.setImageResource(R.drawable.ic_2);
                } else if (count[8] == 1) {
                    cb9.setImageResource(R.drawable.ic_1);
                } else if (count[8] == 0) {
                    cb9.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[9] == 0) {
                    count[9] = 10;
                } else {
                    count[9] = count[9] - 1;
                }

                if (count[9] == 10) {
                    cb10.setImageResource(R.drawable.ic_10);
                } else if (count[9] == 9) {
                    cb10.setImageResource(R.drawable.ic_9);
                } else if (count[9] == 8) {
                    cb10.setImageResource(R.drawable.ic_8);
                } else if (count[9] == 7) {
                    cb10.setImageResource(R.drawable.ic_7);
                } else if (count[9] == 6) {
                    cb10.setImageResource(R.drawable.ic_6);
                } else if (count[9] == 5) {
                    cb10.setImageResource(R.drawable.ic_5);
                } else if (count[9] == 4) {
                    cb10.setImageResource(R.drawable.ic_4);
                } else if (count[9] == 3) {
                    cb10.setImageResource(R.drawable.ic_3);
                } else if (count[9] == 2) {
                    cb10.setImageResource(R.drawable.ic_2);
                } else if (count[9] == 1) {
                    cb10.setImageResource(R.drawable.ic_1);
                } else if (count[9] == 0) {
                    cb10.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[10] == 0) {
                    count[10] = 10;
                } else {
                    count[10] = count[10] - 1;
                }
                if (count[10] == 10) {
                    cb11.setImageResource(R.drawable.ic_10);
                } else if (count[10] == 9) {
                    cb11.setImageResource(R.drawable.ic_9);
                } else if (count[10] == 8) {
                    cb11.setImageResource(R.drawable.ic_8);
                } else if (count[10] == 7) {
                    cb11.setImageResource(R.drawable.ic_7);
                } else if (count[10] == 6) {
                    cb11.setImageResource(R.drawable.ic_6);
                } else if (count[10] == 5) {
                    cb11.setImageResource(R.drawable.ic_5);
                } else if (count[10] == 4) {
                    cb11.setImageResource(R.drawable.ic_4);
                } else if (count[10] == 3) {
                    cb11.setImageResource(R.drawable.ic_3);
                } else if (count[10] == 2) {
                    cb11.setImageResource(R.drawable.ic_2);
                } else if (count[10] == 1) {
                    cb11.setImageResource(R.drawable.ic_1);
                } else if (count[10] == 0) {
                    cb11.setImageResource(R.drawable.ic_0);
                }

            }
        });

        cb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[11] == 0) {
                    count[11] = 10;
                } else {
                    count[11] = count[11] - 1;
                }

                if (count[11] == 10) {
                    cb12.setImageResource(R.drawable.ic_10);
                } else if (count[11] == 9) {
                    cb12.setImageResource(R.drawable.ic_9);
                } else if (count[11] == 8) {
                    cb12.setImageResource(R.drawable.ic_8);
                } else if (count[11] == 7) {
                    cb12.setImageResource(R.drawable.ic_7);
                } else if (count[11] == 6) {
                    cb12.setImageResource(R.drawable.ic_6);
                } else if (count[11] == 5) {
                    cb12.setImageResource(R.drawable.ic_5);
                } else if (count[11] == 4) {
                    cb12.setImageResource(R.drawable.ic_4);
                } else if (count[11] == 3) {
                    cb12.setImageResource(R.drawable.ic_3);
                } else if (count[11] == 2) {
                    cb12.setImageResource(R.drawable.ic_2);
                } else if (count[11] == 1) {
                    cb12.setImageResource(R.drawable.ic_1);
                } else if (count[11] == 0) {
                    cb12.setImageResource(R.drawable.ic_0);
                }

            }
        });

        cb13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[12] == 0) {
                    count[12] = 10;
                } else {
                    count[12] = count[12] - 1;
                }

                if (count[12] == 10) {
                    cb13.setImageResource(R.drawable.ic_10);
                } else if (count[12] == 9) {
                    cb13.setImageResource(R.drawable.ic_9);
                } else if (count[12] == 8) {
                    cb13.setImageResource(R.drawable.ic_8);
                } else if (count[12] == 7) {
                    cb13.setImageResource(R.drawable.ic_7);
                } else if (count[12] == 6) {
                    cb13.setImageResource(R.drawable.ic_6);
                } else if (count[12] == 5) {
                    cb13.setImageResource(R.drawable.ic_5);
                } else if (count[12] == 4) {
                    cb13.setImageResource(R.drawable.ic_4);
                } else if (count[12] == 3) {
                    cb13.setImageResource(R.drawable.ic_3);
                } else if (count[12] == 2) {
                    cb13.setImageResource(R.drawable.ic_2);
                } else if (count[12] == 1) {
                    cb13.setImageResource(R.drawable.ic_1);
                } else if (count[12] == 0) {
                    cb13.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[13] == 0) {
                    count[13] = 10;
                } else {
                    count[13] = count[13] - 1;
                }

                if (count[13] == 10) {
                    cb14.setImageResource(R.drawable.ic_10);
                } else if (count[13] == 9) {
                    cb14.setImageResource(R.drawable.ic_9);
                } else if (count[13] == 8) {
                    cb14.setImageResource(R.drawable.ic_8);
                } else if (count[13] == 7) {
                    cb14.setImageResource(R.drawable.ic_7);
                } else if (count[13] == 6) {
                    cb14.setImageResource(R.drawable.ic_6);
                } else if (count[13] == 5) {
                    cb14.setImageResource(R.drawable.ic_5);
                } else if (count[13] == 4) {
                    cb14.setImageResource(R.drawable.ic_4);
                } else if (count[13] == 3) {
                    cb14.setImageResource(R.drawable.ic_3);
                } else if (count[13] == 2) {
                    cb14.setImageResource(R.drawable.ic_2);
                } else if (count[13] == 1) {
                    cb14.setImageResource(R.drawable.ic_1);
                } else if (count[13] == 0) {
                    cb14.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[14] == 0) {
                    count[14] = 10;
                } else {
                    count[14] = count[14] - 1;
                }

                if (count[14] == 10) {
                    cb15.setImageResource(R.drawable.ic_10);
                } else if (count[14] == 9) {
                    cb15.setImageResource(R.drawable.ic_9);
                } else if (count[14] == 8) {
                    cb15.setImageResource(R.drawable.ic_8);
                } else if (count[14] == 7) {
                    cb15.setImageResource(R.drawable.ic_7);
                } else if (count[14] == 6) {
                    cb15.setImageResource(R.drawable.ic_6);
                } else if (count[14] == 5) {
                    cb15.setImageResource(R.drawable.ic_5);
                } else if (count[14] == 4) {
                    cb15.setImageResource(R.drawable.ic_4);
                } else if (count[14] == 3) {
                    cb15.setImageResource(R.drawable.ic_3);
                } else if (count[14] == 2) {
                    cb15.setImageResource(R.drawable.ic_2);
                } else if (count[14] == 1) {
                    cb15.setImageResource(R.drawable.ic_1);
                } else if (count[14] == 0) {
                    cb15.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[15] == 0) {
                    count[15] = 10;
                } else {
                    count[15] = count[15] - 1;
                }

                if (count[15] == 10) {
                    cb16.setImageResource(R.drawable.ic_10);
                } else if (count[15] == 9) {
                    cb16.setImageResource(R.drawable.ic_9);
                } else if (count[15] == 8) {
                    cb16.setImageResource(R.drawable.ic_8);
                } else if (count[15] == 7) {
                    cb16.setImageResource(R.drawable.ic_7);
                } else if (count[15] == 6) {
                    cb16.setImageResource(R.drawable.ic_6);
                } else if (count[15] == 5) {
                    cb16.setImageResource(R.drawable.ic_5);
                } else if (count[15] == 4) {
                    cb16.setImageResource(R.drawable.ic_4);
                } else if (count[15] == 3) {
                    cb16.setImageResource(R.drawable.ic_3);
                } else if (count[15] == 2) {
                    cb16.setImageResource(R.drawable.ic_2);
                } else if (count[15] == 1) {
                    cb16.setImageResource(R.drawable.ic_1);
                } else if (count[15] == 0) {
                    cb16.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[16] == 0) {
                    count[16] = 10;
                } else {
                    count[16] = count[16] - 1;
                }

                if (count[16] == 10) {
                    cb17.setImageResource(R.drawable.ic_10);
                } else if (count[16] == 9) {
                    cb17.setImageResource(R.drawable.ic_9);
                } else if (count[16] == 8) {
                    cb17.setImageResource(R.drawable.ic_8);
                } else if (count[16] == 7) {
                    cb17.setImageResource(R.drawable.ic_7);
                } else if (count[16] == 6) {
                    cb17.setImageResource(R.drawable.ic_6);
                } else if (count[16] == 5) {
                    cb17.setImageResource(R.drawable.ic_5);
                } else if (count[16] == 4) {
                    cb17.setImageResource(R.drawable.ic_4);
                } else if (count[16] == 3) {
                    cb17.setImageResource(R.drawable.ic_3);
                } else if (count[16] == 2) {
                    cb17.setImageResource(R.drawable.ic_2);
                } else if (count[16] == 1) {
                    cb17.setImageResource(R.drawable.ic_1);
                } else if (count[16] == 0) {
                    cb17.setImageResource(R.drawable.ic_0);
                }

            }
        });

        cb18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[17] == 0) {
                    count[17] = 10;
                } else {
                    count[17] = count[17] - 1;
                }

                if (count[17] == 10) {
                    cb18.setImageResource(R.drawable.ic_10);
                } else if (count[17] == 9) {
                    cb18.setImageResource(R.drawable.ic_9);
                } else if (count[17] == 8) {
                    cb18.setImageResource(R.drawable.ic_8);
                } else if (count[17] == 7) {
                    cb18.setImageResource(R.drawable.ic_7);
                } else if (count[17] == 6) {
                    cb18.setImageResource(R.drawable.ic_6);
                } else if (count[17] == 5) {
                    cb18.setImageResource(R.drawable.ic_5);
                } else if (count[17] == 4) {
                    cb18.setImageResource(R.drawable.ic_4);
                } else if (count[17] == 3) {
                    cb18.setImageResource(R.drawable.ic_3);
                } else if (count[17] == 2) {
                    cb18.setImageResource(R.drawable.ic_2);
                } else if (count[17] == 1) {
                    cb18.setImageResource(R.drawable.ic_1);
                } else if (count[17] == 0) {
                    cb18.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count[18] == 0) {
                    count[18] = 10;
                } else {
                    count[18] = count[18] - 1;
                }

                if (count[18] == 10) {
                    cb19.setImageResource(R.drawable.ic_10);
                } else if (count[18] == 9) {
                    cb19.setImageResource(R.drawable.ic_9);
                } else if (count[18] == 8) {
                    cb19.setImageResource(R.drawable.ic_8);
                } else if (count[18] == 7) {
                    cb19.setImageResource(R.drawable.ic_7);
                } else if (count[18] == 6) {
                    cb19.setImageResource(R.drawable.ic_6);
                } else if (count[18] == 5) {
                    cb19.setImageResource(R.drawable.ic_5);
                } else if (count[18] == 4) {
                    cb19.setImageResource(R.drawable.ic_4);
                } else if (count[18] == 3) {
                    cb19.setImageResource(R.drawable.ic_3);
                } else if (count[18] == 2) {
                    cb19.setImageResource(R.drawable.ic_2);
                } else if (count[18] == 1) {
                    cb19.setImageResource(R.drawable.ic_1);
                } else if (count[18] == 0) {
                    cb19.setImageResource(R.drawable.ic_0);
                }

            }
        });

        cb20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[19] == 0) {
                    count[19] = 10;
                } else {
                    count[19] = count[19] - 1;
                }

                if (count[19] == 10) {
                    cb20.setImageResource(R.drawable.ic_10);
                } else if (count[19] == 9) {
                    cb20.setImageResource(R.drawable.ic_9);
                } else if (count[19] == 8) {
                    cb20.setImageResource(R.drawable.ic_8);
                } else if (count[19] == 7) {
                    cb20.setImageResource(R.drawable.ic_7);
                } else if (count[19] == 6) {
                    cb20.setImageResource(R.drawable.ic_6);
                } else if (count[19] == 5) {
                    cb20.setImageResource(R.drawable.ic_5);
                } else if (count[19] == 4) {
                    cb20.setImageResource(R.drawable.ic_4);
                } else if (count[19] == 3) {
                    cb20.setImageResource(R.drawable.ic_3);
                } else if (count[19] == 2) {
                    cb20.setImageResource(R.drawable.ic_2);
                } else if (count[19] == 1) {
                    cb20.setImageResource(R.drawable.ic_1);
                } else if (count[19] == 0) {
                    cb20.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[20] == 0) {
                    count[20] = 10;
                } else {
                    count[20] = count[20] - 1;
                }

                if (count[20] == 10) {
                    cb21.setImageResource(R.drawable.ic_10);
                } else if (count[20] == 9) {
                    cb21.setImageResource(R.drawable.ic_9);
                } else if (count[20] == 8) {
                    cb21.setImageResource(R.drawable.ic_8);
                } else if (count[20] == 7) {
                    cb21.setImageResource(R.drawable.ic_7);
                } else if (count[20] == 6) {
                    cb21.setImageResource(R.drawable.ic_6);
                } else if (count[20] == 5) {
                    cb21.setImageResource(R.drawable.ic_5);
                } else if (count[20] == 4) {
                    cb21.setImageResource(R.drawable.ic_4);
                } else if (count[20] == 3) {
                    cb21.setImageResource(R.drawable.ic_3);
                } else if (count[20] == 2) {
                    cb21.setImageResource(R.drawable.ic_2);
                } else if (count[20] == 1) {
                    cb21.setImageResource(R.drawable.ic_1);
                } else if (count[20] == 0) {
                    cb21.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[21] == 0) {
                    count[21] = 10;
                } else {
                    count[21] = count[21] - 1;
                }

                if (count[21] == 10) {
                    cb22.setImageResource(R.drawable.ic_10);
                } else if (count[21] == 9) {
                    cb22.setImageResource(R.drawable.ic_9);
                } else if (count[21] == 8) {
                    cb22.setImageResource(R.drawable.ic_8);
                } else if (count[21] == 7) {
                    cb22.setImageResource(R.drawable.ic_7);
                } else if (count[21] == 6) {
                    cb22.setImageResource(R.drawable.ic_6);
                } else if (count[21] == 5) {
                    cb22.setImageResource(R.drawable.ic_5);
                } else if (count[21] == 4) {
                    cb22.setImageResource(R.drawable.ic_4);
                } else if (count[21] == 3) {
                    cb22.setImageResource(R.drawable.ic_3);
                } else if (count[21] == 2) {
                    cb22.setImageResource(R.drawable.ic_2);
                } else if (count[21] == 1) {
                    cb22.setImageResource(R.drawable.ic_1);
                } else if (count[21] == 0) {
                    cb22.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[22] == 0) {
                    count[22] = 10;
                } else {
                    count[22] = count[22] - 1;
                }

                if (count[22] == 10) {
                    cb23.setImageResource(R.drawable.ic_10);
                } else if (count[22] == 9) {
                    cb23.setImageResource(R.drawable.ic_9);
                } else if (count[22] == 8) {
                    cb23.setImageResource(R.drawable.ic_8);
                } else if (count[22] == 7) {
                    cb23.setImageResource(R.drawable.ic_7);
                } else if (count[22] == 6) {
                    cb23.setImageResource(R.drawable.ic_6);
                } else if (count[22] == 5) {
                    cb23.setImageResource(R.drawable.ic_5);
                } else if (count[22] == 4) {
                    cb23.setImageResource(R.drawable.ic_4);
                } else if (count[22] == 3) {
                    cb23.setImageResource(R.drawable.ic_3);
                } else if (count[22] == 2) {
                    cb23.setImageResource(R.drawable.ic_2);
                } else if (count[22] == 1) {
                    cb23.setImageResource(R.drawable.ic_1);
                } else if (count[22] == 0) {
                    cb23.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[23] == 0) {
                    count[23] = 10;
                } else {
                    count[23] = count[23] - 1;
                }

                if (count[23] == 10) {
                    cb24.setImageResource(R.drawable.ic_10);
                } else if (count[23] == 9) {
                    cb24.setImageResource(R.drawable.ic_9);
                } else if (count[23] == 8) {
                    cb24.setImageResource(R.drawable.ic_8);
                } else if (count[23] == 7) {
                    cb24.setImageResource(R.drawable.ic_7);
                } else if (count[23] == 6) {
                    cb24.setImageResource(R.drawable.ic_6);
                } else if (count[23] == 5) {
                    cb24.setImageResource(R.drawable.ic_5);
                } else if (count[23] == 4) {
                    cb24.setImageResource(R.drawable.ic_4);
                } else if (count[23] == 3) {
                    cb24.setImageResource(R.drawable.ic_3);
                } else if (count[23] == 2) {
                    cb24.setImageResource(R.drawable.ic_2);
                } else if (count[23] == 1) {
                    cb24.setImageResource(R.drawable.ic_1);
                } else if (count[23] == 0) {
                    cb24.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[24] == 0) {
                    count[24] = 10;
                } else {
                    count[24] = count[24] - 1;
                }

                if (count[24] == 10) {
                    cb25.setImageResource(R.drawable.ic_10);
                } else if (count[24] == 9) {
                    cb25.setImageResource(R.drawable.ic_9);
                } else if (count[24] == 8) {
                    cb25.setImageResource(R.drawable.ic_8);
                } else if (count[24] == 7) {
                    cb25.setImageResource(R.drawable.ic_7);
                } else if (count[24] == 6) {
                    cb25.setImageResource(R.drawable.ic_6);
                } else if (count[24] == 5) {
                    cb25.setImageResource(R.drawable.ic_5);
                } else if (count[24] == 4) {
                    cb25.setImageResource(R.drawable.ic_4);
                } else if (count[24] == 3) {
                    cb25.setImageResource(R.drawable.ic_3);
                } else if (count[24] == 2) {
                    cb25.setImageResource(R.drawable.ic_2);
                } else if (count[24] == 1) {
                    cb25.setImageResource(R.drawable.ic_1);
                } else if (count[24] == 0) {
                    cb25.setImageResource(R.drawable.ic_0);
                }
            }
        });

        cb26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count[25] == 0) {
                    count[25] = 10;
                } else {
                    count[25] = count[25] - 1;
                }

                if (count[25] == 10) {
                    cb26.setImageResource(R.drawable.ic_10);
                } else if (count[25] == 9) {
                    cb26.setImageResource(R.drawable.ic_9);
                } else if (count[25] == 8) {
                    cb26.setImageResource(R.drawable.ic_8);
                } else if (count[25] == 7) {
                    cb26.setImageResource(R.drawable.ic_7);
                } else if (count[25] == 6) {
                    cb26.setImageResource(R.drawable.ic_6);
                } else if (count[25] == 5) {
                    cb26.setImageResource(R.drawable.ic_5);
                } else if (count[25] == 4) {
                    cb26.setImageResource(R.drawable.ic_4);
                } else if (count[25] == 3) {
                    cb26.setImageResource(R.drawable.ic_3);
                } else if (count[25] == 2) {
                    cb26.setImageResource(R.drawable.ic_2);
                } else if (count[25] == 1) {
                    cb26.setImageResource(R.drawable.ic_1);
                } else if (count[25] == 0) {
                    cb26.setImageResource(R.drawable.ic_0);
                }
            }
        });

        today(day2, dayselected);
    }
    private void updatexlabel(final int ia){
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if ( isValueX ) {
                    try{
                        String xlabel = String.valueOf(Math.round(value));
                        String xdate = xlabel;

                        String string_temp = new Double(value).toString();
                        String string_form = string_temp.substring(0,string_temp.indexOf('.'));

                        xdate =  splitdate(Integer.parseInt(String.valueOf(string_form)), ia);
                        return xdate + "";
                    }
                    catch(Exception d){
                        return "";
                    }
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX);
                }
            }
        });

    }

    private String splitdate(int xlabel, int i) {
        String xdate = "";
        try {
            switch (i){
                case 1:
                    xdate = db1.getlabel(xlabel);
                    break;
                case 2:
                    xdate = db2.getlabel(xlabel);
                    break;
                case 3:
                    xdate = db3.getlabel(xlabel);
                    break;
                case 4:
                    xdate = db4.getlabel(xlabel);
                    break;
                case 5:
                    xdate = db5.getlabel(xlabel);
                    break;
                case 6:
                    xdate = db6.getlabel(xlabel);
                    break;

            }

            String[] parts = xdate.split("-");
            month = parts[1];
            switch (month) {
                case "01":
                    month = "Jan";
                    break;
                case "02":
                    month = "Feb";
                    break;
                case "03":
                    month = "Mar";
                    break;
                case "04":
                    month = "Apr";
                    break;
                case "05":
                    month = "May";
                    break;
                case "06":
                    month = "Jun";
                    break;
                case "07":
                    month = "Jul";
                    break;
                case "08":
                    month = "Aug";
                    break;
                case "09":
                    month = "Sep";
                    break;
                case "10":
                    month = "Oct";
                    break;
                case "11":
                    month = "Nov";
                    break;
                case "12":
                    month = "Dec";
                    break;
            }
            xdate = parts[2];
            xdate = month + "-" + xdate;
        } catch (Exception e) {
            xdate = "";
        }
        return xdate;
    }

    private DataPoint[] data( int plan, int section) {

       int n =0;
        switch(plan){
            case 0:
                relpush.setBackgroundColor(Color.parseColor("#efefef"));
                relpull.setBackgroundColor(Color.parseColor("#ffffff"));
                relleg.setBackgroundColor(Color.parseColor("#ffffff"));
                switch(section){
                    case 0:
                        n = db1.getsize();
                        DataPoint[] values = new DataPoint[n]; //creating an object of type DataPoint[] of size 'n'
                        for (int i = 0; i < n; i++) {
                            DataPoint v = new DataPoint(i, db1.get(1,i)*5);
                            values[i] = v;
                        }
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setScalable(false);
                        graph.getViewport().setScalableY(false);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(db1.getsize() - 1);
                        graph.getViewport().setMinY(db1.getmin(1) - 50);
                        graph.getViewport().setMaxY(db1.getmax(1) + 50);
                        updatexlabel(1);
                        return values;
                    case 1:
                        n = db4.getsize();
                        DataPoint[] values1 = new DataPoint[n]; //creating an object of type DataPoint[] of size 'n'
                        for (int i = 0; i < n; i++) {
                            DataPoint v = new DataPoint(i, db4.get(1,i)*5);
                            values1[i] = v;
                        }
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setScalable(false);
                        graph.getViewport().setScalableY(false);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(db4.getsize()-1);
                        graph.getViewport().setMinY(db4.getmin(1) - 50);
                        graph.getViewport().setMaxY(db4.getmax(1) + 50);
                        updatexlabel(4);
                        return values1;
                }
                break;
            case 1:
                relpush.setBackgroundColor(Color.parseColor("#ffffff"));
                relpull.setBackgroundColor(Color.parseColor("#efefef"));
                relleg.setBackgroundColor(Color.parseColor("#ffffff"));
                switch(section){
                    case 0:
                        n = db2.getsize();
                        DataPoint[] values2 = new DataPoint[n]; //creating an object of type DataPoint[] of size 'n'
                        for (int i = 0; i < n; i++) {
                            DataPoint v = new DataPoint(i, db2.get(1,i)*5);
                            values2[i] = v;
                        }
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setScalable(false);
                        graph.getViewport().setScalableY(false);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(db2.getsize()-1);
                        graph.getViewport().setMinY(db2.getmin(1) - 50);
                        graph.getViewport().setMaxY(db2.getmax(1) + 50);
                        updatexlabel(2);
                        return values2;
                    case 1:
                        n = db5.getsize();
                        DataPoint[] values3 = new DataPoint[n]; //creating an object of type DataPoint[] of size 'n'
                        for (int i = 0; i < n; i++) {
                            DataPoint v = new DataPoint(i, db5.get(1,i)*5);
                            values3[i] = v;
                        }
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setScalable(false);
                        graph.getViewport().setScalableY(false);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(db5.getsize()-1);
                        graph.getViewport().setMinY(db5.getmin(1) - 50);
                        graph.getViewport().setMaxY(db5.getmax(1) + 50);
                        updatexlabel(5);
                        return values3;
                }
                break;
            case 2:
                relpush.setBackgroundColor(Color.parseColor("#ffffff"));
                relpull.setBackgroundColor(Color.parseColor("#ffffff"));
                relleg.setBackgroundColor(Color.parseColor("#efefef"));
                switch(section){
                    case 0:
                        n = db3.getsize();
                        DataPoint[] values4 = new DataPoint[n]; //creating an object of type DataPoint[] of size 'n'
                        for (int i = 0; i < n; i++) {
                            DataPoint v = new DataPoint(i, db3.get(1,i)*5);
                            values4[i] = v;
                        }
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setScalable(false);
                        graph.getViewport().setScalableY(false);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(db3.getsize()-1);
                        graph.getViewport().setMinY(db3.getmin(1) - 50);
                        graph.getViewport().setMaxY(db3.getmax(1) + 50);
                        updatexlabel(3);
                        return values4;
                    case 1:
                        n = db6.getsize();
                        DataPoint[] values5 = new DataPoint[n]; //creating an object of type DataPoint[] of size 'n'
                        for (int i = 0; i < n; i++) {
                            DataPoint v = new DataPoint(i, db6.get(1,i)*5);
                            values5[i] = v;
                        }
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setScalable(false);
                        graph.getViewport().setScalableY(false);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(db6.getsize()-1);
                        graph.getViewport().setMinY(db6.getmin(1) - 50);
                        graph.getViewport().setMaxY(db6.getmax(1) + 50);
                        updatexlabel(6);
                        return values5;
                }
                break;
        }
        DataPoint[] values6 = new DataPoint[n]; //creating an object of type DataPoint[] of size 'n'
        for (int i = 0; i < n; i++) {
            DataPoint v = new DataPoint(i,60);
            values6[i] = v;
        }
        return values6;
    }

    private void history(String date) {

        try {

            if (dbs1.getday(date).equals(date) || dbs2.getday(date).equals(date) || dbs3.getday(date).equals(date) || dbs4.getday(date).equals(date) || dbs5.getday(date).equals(date) || dbs6.getday(date).equals(date)) {
                hc.setVisibility(View.VISIBLE);
            }

            String imtemp;
            int temp;

            if (dbs1.getday(date).equals(date)) {
                if (dbs1.getinfo(6) == 1) {
                    excer = Pusha;
                } else if (dbs1.getinfo(6) == 2) {
                    excer = Pulla;
                } else if (dbs1.getinfo(6) == 3) {
                    excer = Legsa;
                } else if (dbs1.getinfo(6) == 4) {
                    excer = Pushb;
                } else if (dbs1.getinfo(6) == 5) {
                    excer = Pullb;
                } else if (dbs1.getinfo(6) == 6) {
                    excer = Legsb;
                }
                updatehc1(dbs1.getinfo(6));
                hc1.setVisibility(View.VISIBLE);
                imtemp = "ic_" + dbs1.getinfo(1);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb1.setImageResource(temp);
                imtemp = "ic_" + dbs1.getinfo(2);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb2.setImageResource(temp);
                imtemp = "ic_" + dbs1.getinfo(3);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb3.setImageResource(temp);
                imtemp = "ic_" + dbs1.getinfo(4);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb4.setImageResource(temp);
                imtemp = "ic_" + dbs1.getinfo(5);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb5.setImageResource(temp);
            }
            if (dbs2.getday(date).equals(date)) {
                if (dbs2.getinfo(4) == 1) {
                    excer = Pusha;
                } else if (dbs2.getinfo(4) == 2) {
                    excer = Pulla;
                } else if (dbs2.getinfo(4) == 3) {
                    excer = Legsa;
                } else if (dbs2.getinfo(4) == 4) {
                    excer = Pushb;
                } else if (dbs2.getinfo(4) == 5) {
                    excer = Pullb;
                } else if (dbs2.getinfo(4) == 6) {
                    excer = Legsb;
                }
                updatehc2(dbs2.getinfo(4));
                hc2.setVisibility(View.VISIBLE);
                imtemp = "ic_" + dbs2.getinfo(1);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb6.setImageResource(temp);
                imtemp = "ic_" + dbs2.getinfo(2);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb7.setImageResource(temp);
                imtemp = "ic_" + dbs2.getinfo(3);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb8.setImageResource(temp);
            }
            if (dbs3.getday(date).equals(date)) {
                if (dbs3.getinfo(4) == 1) {
                    excer = Pusha;
                } else if (dbs3.getinfo(4) == 2) {
                    excer = Pulla;
                } else if (dbs3.getinfo(4) == 3) {
                    excer = Legsa;
                } else if (dbs3.getinfo(4) == 4) {
                    excer = Pushb;
                } else if (dbs3.getinfo(4) == 5) {
                    excer = Pullb;
                } else if (dbs3.getinfo(4) == 6) {
                    excer = Legsb;
                }
                updatehc3(dbs3.getinfo(4));
                hc3.setVisibility(View.VISIBLE);
                imtemp = "ic_" + dbs3.getinfo(1);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb9.setImageResource(temp);
                imtemp = "ic_" + dbs3.getinfo(2);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb10.setImageResource(temp);
                imtemp = "ic_" + dbs3.getinfo(3);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb11.setImageResource(temp);
            }
            if (dbs4.getday(date).equals(date)) {
                if (dbs4.getinfo(6) == 1) {
                    excer = Pusha;
                } else if (dbs4.getinfo(6) == 2) {
                    excer = Pulla;
                } else if (dbs4.getinfo(6) == 3) {
                    excer = Legsa;
                } else if (dbs4.getinfo(6) == 4) {
                    excer = Pushb;
                } else if (dbs4.getinfo(6) == 5) {
                    excer = Pullb;
                } else if (dbs4.getinfo(6) == 6) {
                    excer = Legsb;
                }
                updatehc4(dbs4.getinfo(6));
                hc4.setVisibility(View.VISIBLE);
                imtemp = "ic_" + dbs4.getinfo(1);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb12.setImageResource(temp);
                imtemp = "ic_" + dbs4.getinfo(2);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb13.setImageResource(temp);
                imtemp = "ic_" + dbs4.getinfo(3);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb14.setImageResource(temp);
                imtemp = "ic_" + dbs4.getinfo(4);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb15.setImageResource(temp);
                imtemp = "ic_" + dbs4.getinfo(5);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb16.setImageResource(temp);
            }
            if (dbs5.getday(date).equals(date)) {
                if (dbs5.getinfo(6) == 1) {
                    excer = Pusha;
                } else if (dbs5.getinfo(6) == 2) {
                    excer = Pulla;
                } else if (dbs5.getinfo(6) == 3) {
                    excer = Legsa;
                } else if (dbs5.getinfo(6) == 4) {
                    excer = Pushb;
                } else if (dbs5.getinfo(6) == 5) {
                    excer = Pullb;
                } else if (dbs5.getinfo(6) == 6) {
                    excer = Legsb;
                }
                updatehc5(dbs5.getinfo(6));
                hc5.setVisibility(View.VISIBLE);
                imtemp = "ic_" + dbs5.getinfo(1);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb17.setImageResource(temp);
                imtemp = "ic_" + dbs5.getinfo(2);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb18.setImageResource(temp);
                imtemp = "ic_" + dbs5.getinfo(3);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb19.setImageResource(temp);
                imtemp = "ic_" + dbs5.getinfo(4);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb20.setImageResource(temp);
                imtemp = "ic_" + dbs5.getinfo(5);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb21.setImageResource(temp);
            }
            if (dbs6.getday(date).equals(date)) {
                if (dbs6.getinfo(6) == 1) {
                    excer = Pusha;
                } else if (dbs6.getinfo(6) == 2) {
                    excer = Pulla;
                } else if (dbs6.getinfo(6) == 3) {
                    excer = Legsa;
                } else if (dbs6.getinfo(6) == 4) {
                    excer = Pushb;
                } else if (dbs6.getinfo(6) == 5) {
                    excer = Pullb;
                } else if (dbs6.getinfo(6) == 6) {
                    excer = Legsb;
                }
                updatehc6(dbs6.getinfo(6));
                hc6.setVisibility(View.VISIBLE);
                imtemp = "ic_" + dbs6.getinfo(1);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb22.setImageResource(temp);
                imtemp = "ic_" + dbs6.getinfo(2);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb23.setImageResource(temp);
                imtemp = "ic_" + dbs6.getinfo(3);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb24.setImageResource(temp);
                imtemp = "ic_" + dbs6.getinfo(4);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb25.setImageResource(temp);
                imtemp = "ic_" + dbs6.getinfo(5);
                temp = getResources().getIdentifier(imtemp, "drawable", getPackageName());
                hcb26.setImageResource(temp);
            }
        } catch (Exception e) {

        }
    }

    public void openDialog(int workout) {

        final Dialog dialog = new Dialog(this); // Context, this, etc.

        dialog.setContentView(R.layout.dialog_demo);
        dialog.setTitle("Edit weight");

        b1 = (Button) dialog.findViewById(R.id.button3);
        b2 = (Button) dialog.findViewById(R.id.button2);

        np = (NumberPicker) dialog.findViewById(R.id.np); //Initializing a new string array with elements

        setNumberPickerTextColor(np);
        if (workout == 99) {
            dialog.cancel();
        }

        String[] weight = new String[100];
        weight[0] = "0";

        for (int i = 1; i < 100; i++) {
            weight[i] = Integer.toString((Integer.parseInt(weight[i - 1]) + 5));
            //System.out.println(i);
        }

        np.setMinValue(0);
        np.setMaxValue(99);

        if (dbbb == 1 && dbb == 1) {
            np.setValue(db1.getinfo(workout));
        } else if (dbbb == 2 && dbb == 1) {
            np.setValue(db1.getinfo(workout));
        } else if (dbbb == 3 && dbb == 1) {
            np.setValue(db1.getinfo(workout));
        } else if (dbbb == 4 && dbb == 1) {
            np.setValue(db1.getinfo(workout));
        } else if (dbbb == 5 && dbb == 1) {
            np.setValue(db1.getinfo(workout));
        } else if (dbbb == 6 && dbb == 1) {
            np.setValue(db1.getinfo(workout));
        } else if (dbbb == 1 && dbb == 2) {
            np.setValue(db2.getinfo(workout));
        } else if (dbbb == 2 && dbb == 2) {
            np.setValue(db2.getinfo(workout));
        } else if (dbbb == 3 && dbb == 2) {
            np.setValue(db2.getinfo(workout));
        } else if (dbbb == 4 && dbb == 2) {
            np.setValue(db2.getinfo(workout));
        } else if (dbbb == 5 && dbb == 2) {
            np.setValue(db2.getinfo(workout));
        } else if (dbbb == 6 && dbb == 2) {
            np.setValue(db2.getinfo(workout));
        } else if (dbbb == 1 && dbb == 3) {
            np.setValue(db3.getinfo(workout));
        } else if (dbbb == 2 && dbb == 3) {
            np.setValue(db3.getinfo(workout));
        } else if (dbbb == 3 && dbb == 3) {
            np.setValue(db3.getinfo(workout));
        } else if (dbbb == 4 && dbb == 3) {
            np.setValue(db3.getinfo(workout));
        } else if (dbbb == 5 && dbb == 3) {
            np.setValue(db3.getinfo(workout));
        } else if (dbbb == 6 && dbb == 3) {
            np.setValue(db3.getinfo(workout));
        } else if (dbbb == 1 && dbb == 4) {
            np.setValue(db4.getinfo(workout));
        } else if (dbbb == 2 && dbb == 4) {
            np.setValue(db4.getinfo(workout));
        } else if (dbbb == 3 && dbb == 4) {
            np.setValue(db4.getinfo(workout));
        } else if (dbbb == 4 && dbb == 4) {
            np.setValue(db4.getinfo(workout));
        } else if (dbbb == 5 && dbb == 4) {
            np.setValue(db4.getinfo(workout));
        } else if (dbbb == 6 && dbb == 4) {
            np.setValue(db4.getinfo(workout));
        } else if (dbbb == 1 && dbb == 5) {
            np.setValue(db5.getinfo(workout));
        } else if (dbbb == 2 && dbb == 5) {
            np.setValue(db5.getinfo(workout));
        } else if (dbbb == 3 && dbb == 5) {
            np.setValue(db5.getinfo(workout));
        } else if (dbbb == 4 && dbb == 5) {
            np.setValue(db5.getinfo(workout));
        } else if (dbbb == 5 && dbb == 5) {
            np.setValue(db5.getinfo(workout));
        } else if (dbbb == 6 && dbb == 5) {
            np.setValue(db5.getinfo(workout));
        } else if (dbbb == 1 && dbb == 6) {
            np.setValue(db6.getinfo(workout));
        } else if (dbbb == 2 && dbb == 6) {
            np.setValue(db6.getinfo(workout));
        } else if (dbbb == 3 && dbb == 6) {
            np.setValue(db6.getinfo(workout));
        } else if (dbbb == 4 && dbb == 6) {
            np.setValue(db6.getinfo(workout));
        } else if (dbbb == 5 && dbb == 6) {
            np.setValue(db6.getinfo(workout));
        } else if (dbbb == 6 && dbb == 6) {
            np.setValue(db6.getinfo(workout));
        }
        np.setDisplayedValues(weight);

        //LBS OF KGS UNIT OF MEARUSE WIEGHT
        np1 = (TextView) dialog.findViewById(R.id.np1);
        final String[] unitofw = {
                uom,
                "kgs"
        };
        np1.setText(unitofw[0]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatecards();
                dialog.cancel();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(dbbb){
                    case 1:
                        ct2.setText("" + np.getValue() *5 );
                        break;
                    case 2:
                        ct6.setText("" + np.getValue()*5);
                        break;
                    case 3:
                        ct10.setText("" + np.getValue()*5);
                        break;
                    case 4:
                        ct14.setText("" + np.getValue()*5);
                        break;
                    case 5:
                        ct18.setText("" +np.getValue()*5);
                        break;
                    case 6:
                        ct22.setText("" + np.getValue()*5);
                        break;
                }
                dialog.cancel();
            }
        });
        dialog.show();
    }

    public void openPicture(int workout) {

        final Dialog dialog = new Dialog(this); // Context, this, etc.

        dialog.setContentView(R.layout.pictures);
        picture1 = (ImageView) dialog.findViewById(R.id.imageView6);
        int temp;
        temp = getResources().getIdentifier("ab1", "drawable", getPackageName());
        if(workout == 1) {
            temp = getResources().getIdentifier("ab1", "drawable", getPackageName());
        }else if(workout == 2) {
            temp = getResources().getIdentifier("ab2", "drawable", getPackageName());
        }else if(workout == 3) {
            temp = getResources().getIdentifier("ab3", "drawable", getPackageName());
        }else if(workout == 4) {
            temp = getResources().getIdentifier("ab4", "drawable", getPackageName());
        }else if(workout == 5) {
            temp = getResources().getIdentifier("ab5", "drawable", getPackageName());
        }else if(workout == 6) {
            temp = getResources().getIdentifier("ab6", "drawable", getPackageName());
        }else if(workout == 7) {
            temp = getResources().getIdentifier("ab7", "drawable", getPackageName());
        }else if(workout == 8) {
            temp = getResources().getIdentifier("ab8", "drawable", getPackageName());
        }else if(workout == 9) {
            temp = getResources().getIdentifier("ab9", "drawable", getPackageName());
        }
        picture1.setImageResource(temp);
            dialog.show();
    }

    private void updatedb() {
        if (dbbb == 1 && dbb == 1) {
            db1.update(np.getValue(), db1.getinfo(2), db1.getinfo(3), db1.getinfo(4), db1.getinfo(5), db1.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 2 && dbb == 1) {
            db1.update(db1.getinfo(1), np.getValue(), db1.getinfo(3), db1.getinfo(4), db1.getinfo(5), db1.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 3 && dbb == 1) {
            db1.update(db1.getinfo(1), db1.getinfo(2), np.getValue(), db1.getinfo(4), db1.getinfo(5), db1.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 4 && dbb == 1) {
            db1.update(db1.getinfo(1), db1.getinfo(2), db1.getinfo(3), np.getValue(), db1.getinfo(5), db1.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 5 && dbb == 1) {
            db1.update(db1.getinfo(1), db1.getinfo(2), db1.getinfo(3), db1.getinfo(4), np.getValue(), db1.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 6 && dbb == 1) {
            db1.update(db1.getinfo(1), db1.getinfo(2), db1.getinfo(3), db1.getinfo(4), db1.getinfo(5), np.getValue(), df.format(c.getTime())+ "");
        } else if (dbbb == 1 && dbb == 2) {
            db2.update(np.getValue(), db2.getinfo(2), db2.getinfo(3), db2.getinfo(4), db2.getinfo(5), db2.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 2 && dbb == 2) {
            db2.update(db2.getinfo(1), np.getValue(), db2.getinfo(3), db2.getinfo(4), db2.getinfo(5), db2.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 3 && dbb == 2) {
            db2.update(db2.getinfo(1), db2.getinfo(2), np.getValue(), db2.getinfo(4), db2.getinfo(5), db2.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 4 && dbb == 2) {
            db2.update(db2.getinfo(1), db2.getinfo(2), db2.getinfo(3), np.getValue(), db2.getinfo(5), db2.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 5 && dbb == 2) {
            db2.update(db2.getinfo(1), db2.getinfo(2), db2.getinfo(3), db2.getinfo(4), np.getValue(), db2.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 6 && dbb == 2) {
            db2.update(db2.getinfo(1), db2.getinfo(2), db2.getinfo(3), db2.getinfo(4), db2.getinfo(5), np.getValue(), df.format(c.getTime())+ "");
        } else if (dbbb == 1 && dbb == 3) {
            db3.update(np.getValue(), db3.getinfo(2), db3.getinfo(3), db3.getinfo(4), db3.getinfo(5), db3.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 2 && dbb == 3) {
            db3.update(db3.getinfo(1), np.getValue(), db3.getinfo(3), db3.getinfo(4), db3.getinfo(5), db3.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 3 && dbb == 3) {
            db3.update(db3.getinfo(1), db3.getinfo(2), np.getValue(), db3.getinfo(4), db3.getinfo(5), db3.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 4 && dbb == 3) {
            db3.update(db3.getinfo(1), db3.getinfo(2), db3.getinfo(3), np.getValue(), db3.getinfo(5), db3.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 5 && dbb == 3) {
            db3.update(db3.getinfo(1), db3.getinfo(2), db3.getinfo(3), db3.getinfo(4), np.getValue(), db3.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 6 && dbb == 3) {
            db3.update(db3.getinfo(1), db3.getinfo(2), db3.getinfo(3), db3.getinfo(4), db3.getinfo(5), np.getValue(), df.format(c.getTime())+ "");
        } else if (dbbb == 1 && dbb == 4) {
            db4.update(np.getValue(), db4.getinfo(2), db4.getinfo(3), db4.getinfo(4), db4.getinfo(5), db4.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 2 && dbb == 4) {
            db4.update(db4.getinfo(1), np.getValue(), db4.getinfo(3), db4.getinfo(4), db4.getinfo(5), db4.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 3 && dbb == 4) {
            db4.update(db4.getinfo(1), db4.getinfo(2), np.getValue(), db4.getinfo(4), db4.getinfo(5), db4.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 4 && dbb == 4) {
            db4.update(db4.getinfo(1), db4.getinfo(2), db4.getinfo(3), np.getValue(), db4.getinfo(5), db4.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 5 && dbb == 4) {
            db4.update(db4.getinfo(1), db4.getinfo(2), db4.getinfo(3), db4.getinfo(4), np.getValue(), db4.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 6 && dbb == 4) {
            db4.update(db4.getinfo(1), db4.getinfo(2), db4.getinfo(3), db4.getinfo(4), db4.getinfo(5), np.getValue(), df.format(c.getTime())+ "");
        } else if (dbbb == 1 && dbb == 5) {
            db5.update(np.getValue(), db5.getinfo(2), db5.getinfo(3), db5.getinfo(4), db5.getinfo(5), db5.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 2 && dbb == 5) {
            db5.update(db5.getinfo(1), np.getValue(), db5.getinfo(3), db5.getinfo(4), db5.getinfo(5), db5.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 3 && dbb == 5) {
            db5.update(db5.getinfo(1), db5.getinfo(2), np.getValue(), db5.getinfo(4), db5.getinfo(5), db5.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 4 && dbb == 5) {
            db5.update(db5.getinfo(1), db5.getinfo(2), db5.getinfo(3), np.getValue(), db5.getinfo(5), db5.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 5 && dbb == 5) {
            db5.update(db5.getinfo(1), db5.getinfo(2), db5.getinfo(3), db5.getinfo(4), np.getValue(), db5.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 6 && dbb == 5) {
            db5.update(db5.getinfo(1), db5.getinfo(2), db5.getinfo(3), db5.getinfo(4), db5.getinfo(5), np.getValue(), df.format(c.getTime())+ "");
        } else if (dbbb == 1 && dbb == 6) {
            db6.update(np.getValue(), db6.getinfo(2), db6.getinfo(3), db6.getinfo(4), db6.getinfo(5), db6.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 2 && dbb == 6) {
            db6.update(db6.getinfo(1), np.getValue(), db6.getinfo(3), db6.getinfo(4), db6.getinfo(5), db6.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 3 && dbb == 6) {
            db6.update(db6.getinfo(1), db6.getinfo(2), np.getValue(), db6.getinfo(4), db6.getinfo(5), db6.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 4 && dbb == 6) {
            db6.update(db6.getinfo(1), db6.getinfo(2), db6.getinfo(3), np.getValue(), db6.getinfo(5), db6.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 5 && dbb == 6) {
            db6.update(db6.getinfo(1), db6.getinfo(2), db6.getinfo(3), db6.getinfo(4), np.getValue(), db6.getinfo(6), df.format(c.getTime())+ "");
        } else if (dbbb == 6 && dbb == 6) {
            db6.update(db6.getinfo(1), db6.getinfo(2), db6.getinfo(3), db6.getinfo(4), db6.getinfo(5), np.getValue(), df.format(c.getTime())+ "");
        }
    }

    public void workoutstatus() {
        if (count2[0] == 1 && count2[1] == 1 && count2[2] == 1 && count2[3] == 1 && count2[4] == 1 && count2[5] == 1) {
            c1.setVisibility(View.GONE);
            c2.setVisibility(View.GONE);
            c3.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
            c5.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
            a1.setVisibility(View.GONE);
            a2.setVisibility(View.GONE);
            a3.setVisibility(View.GONE);
            a4.setVisibility(View.GONE);
            a5.setVisibility(View.GONE);
            a6.setVisibility(View.GONE);
            a7.setVisibility(View.GONE);
            a8.setVisibility(View.GONE);
            a9.setVisibility(View.GONE);
            sc1.setVisibility(View.GONE);
            sc3.setVisibility(View.GONE);
            sc2.setVisibility(View.VISIBLE);
            c20.setVisibility(View.INVISIBLE);
            c21.setVisibility(View.INVISIBLE);
            page = 1;
            start = 0;
            bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
            count2[0] = 0;
            count2[1] = 0;
            count2[2] = 0;
            count2[3] = 0;
            count2[4] = 0;
            count2[5] = 0;
            Context context = getApplicationContext();
            Toast.makeText(context, "Goodjob, You've finished your workout", Toast.LENGTH_SHORT).show();

        }
    }

    public void updatecards() {


        ct1.setText("" + excer[0][0]);
        ct3.setText("" + uom);
        ct4.setText("" + excer[0][2]);
        ct5.setText("" + excer[1][0]);
        ct7.setText("" + uom);
        ct8.setText("" + excer[1][2]);
        ct9.setText("" + excer[2][0]);
        ct11.setText("" + uom);
        ct12.setText("" + excer[2][2]);
        ct13.setText("" + excer[3][0]);
        ct15.setText("" + uom);
        ct16.setText("" + excer[3][2]);
        ct17.setText("" + excer[4][0]);
        ct19.setText("" + uom);
        ct20.setText("" + excer[4][2]);
        ct21.setText("" + excer[5][0]);
        ct23.setText("" + uom);
        ct24.setText("" + excer[5][2]);

        if (dbb == 1) {
            ct2.setText("" + db1.getinfo(1) * 5);
            ct6.setText("" + db1.getinfo(2) * 5);
            ct10.setText("" + db1.getinfo(3) * 5);
            ct14.setText("" + db1.getinfo(4) * 5);
            ct18.setText("" + db1.getinfo(5) * 5);
            ct22.setText("" + db1.getinfo(6) * 5);
        } else if (dbb == 2) {
            ct2.setText("" + db2.getinfo(1) * 5);
            ct6.setText("" + db2.getinfo(2) * 5);
            ct10.setText("" + db2.getinfo(3) * 5);
            ct14.setText("" + db2.getinfo(4) * 5);
            ct18.setText("" + db2.getinfo(5) * 5);
            ct22.setText("" + db2.getinfo(6) * 5);
        } else if (dbb == 3) {
            ct2.setText("" + db3.getinfo(1) * 5);
            ct6.setText("" + db3.getinfo(2) * 5);
            ct10.setText("" + db3.getinfo(3) * 5);
            ct14.setText("" + db3.getinfo(4) * 5);
            ct18.setText("" + db3.getinfo(5) * 5);
            ct22.setText("" + db3.getinfo(6) * 5);
        } else if (dbb == 4) {
            ct2.setText("" + db4.getinfo(1) * 5);
            ct6.setText("" + db4.getinfo(2) * 5);
            ct10.setText("" + db4.getinfo(3) * 5);
            ct14.setText("" + db4.getinfo(4) * 5);
            ct18.setText("" + db4.getinfo(5) * 5);
            ct22.setText("" + db4.getinfo(6) * 5);
        } else if (dbb == 5) {
            ct2.setText("" + db5.getinfo(1) * 5);
            ct6.setText("" + db5.getinfo(2) * 5);
            ct10.setText("" + db5.getinfo(3) * 5);
            ct14.setText("" + db5.getinfo(4) * 5);
            ct18.setText("" + db5.getinfo(5) * 5);
            ct22.setText("" + db5.getinfo(6) * 5);
        } else if (dbb == 6) {
            ct2.setText("" + db6.getinfo(1) * 5);
            ct6.setText("" + db6.getinfo(2) * 5);
            ct10.setText("" + db6.getinfo(3) * 5);
            ct14.setText("" + db6.getinfo(4) * 5);
            ct18.setText("" + db6.getinfo(5) * 5);
            ct22.setText("" + db6.getinfo(6) * 5);
        }
        if (new_workout == 1) {
            c1.setVisibility(View.VISIBLE);
            c21.setVisibility(View.VISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            c5.setVisibility(View.VISIBLE);
            c6.setVisibility(View.VISIBLE);
            new_workout = 0;
        }
    }

    public void updatehc1(int hdb) {
        h1t1.setText("" + excer[0][0]);
        if (hdb == 1) {
            h1t3.setText("" + db1.getinfo(1) * 5);
        } else if (hdb == 2) {
            h1t3.setText("" + db2.getinfo(1) * 5);
        } else if (hdb == 3) {
            h1t3.setText("" + db3.getinfo(1) * 5);
        } else if (hdb == 4) {
            h1t3.setText("" + db4.getinfo(1) * 5);
        } else if (hdb == 5) {
            h1t3.setText("" + db5.getinfo(1) * 5);
        } else if (hdb == 6) {
            h1t3.setText("" + db6.getinfo(1) * 5);
        }
    }

    public void updatehc2(int hdb) {
        h2t1.setText("" + excer[1][0]);
        if (hdb == 1) {
            h2t3.setText("" + db1.getinfo(2) * 5);
        } else if (hdb == 2) {
            h2t3.setText("" + db2.getinfo(2) * 5);
        } else if (hdb == 3) {
            h2t3.setText("" + db3.getinfo(2) * 5);
        } else if (hdb == 4) {
            h2t3.setText("" + db4.getinfo(2) * 5);
        } else if (hdb == 5) {
            h2t3.setText("" + db5.getinfo(2) * 5);
        } else if (hdb == 6) {
            h2t3.setText("" + db6.getinfo(2) * 5);
        }
    }

    public void updatehc3(int hdb) {
        h3t1.setText("" + excer[2][0]);
        if (hdb == 1) {
            h3t3.setText("" + db1.getinfo(3) * 5);
        } else if (hdb == 2) {
            h3t3.setText("" + db2.getinfo(3) * 5);
        } else if (hdb == 3) {
            h3t3.setText("" + db3.getinfo(3) * 5);
        } else if (hdb == 4) {
            h3t3.setText("" + db4.getinfo(3) * 5);
        } else if (hdb == 5) {
            h3t3.setText("" + db5.getinfo(3) * 5);
        } else if (hdb == 6) {
            h3t3.setText("" + db6.getinfo(3) * 5);
        }
    }

    public void updatehc4(int hdb) {
        h4t1.setText("" + excer[3][0]);
        if (hdb == 1) {
            h4t3.setText("" + db1.getinfo(4) * 5);
        } else if (hdb == 2) {
            h4t3.setText("" + db2.getinfo(4) * 5);
        } else if (hdb == 3) {
            h4t3.setText("" + db3.getinfo(4) * 5);
        } else if (hdb == 4) {
            h4t3.setText("" + db4.getinfo(4) * 5);
        } else if (hdb == 5) {
            h4t3.setText("" + db5.getinfo(4) * 5);
        } else if (hdb == 6) {
            h4t3.setText("" + db6.getinfo(4) * 5);
        }
    }

    public void updatehc5(int hdb) {
        h5t1.setText("" + excer[4][0]);
        if (hdb == 1) {
            h5t3.setText("" + db1.getinfo(5) * 5);
        } else if (hdb == 2) {
            h5t3.setText("" + db2.getinfo(5) * 5);
        } else if (hdb == 3) {
            h5t3.setText("" + db3.getinfo(5) * 5);
        } else if (hdb == 4) {
            h5t3.setText("" + db4.getinfo(5) * 5);
        } else if (hdb == 5) {
            h5t3.setText("" + db5.getinfo(5) * 5);
        } else if (hdb == 6) {
            h5t3.setText("" + db6.getinfo(5) * 5);
        }
    }

    public void updatehc6(int hdb) {
        h6t1.setText("" + excer[5][0]);
        if (hdb == 1) {
            h6t3.setText("" + db1.getinfo(6) * 5);
        } else if (hdb == 2) {
            h6t3.setText("" + db2.getinfo(6) * 5);
        } else if (hdb == 3) {
            h6t3.setText("" + db3.getinfo(6) * 5);
        } else if (hdb == 4) {
            h6t3.setText("" + db4.getinfo(6) * 5);
        } else if (hdb == 5) {
            h6t3.setText("" + db5.getinfo(6) * 5);
        } else if (hdb == 6) {
            h6t3.setText("" + db6.getinfo(6) * 5);
        }
    }

    public void today(int day2, int dayselected) {

        if (day2 == 1) {
            if (dayselected == 6) {
                excer = Pusha;
                tday.setText("Today is Push A");
                tmday.setText("Tomorrow is Pull A");
                rmday.setText("Your next rest day is in 6 days");
            }
            if (dayselected == 0) {
                excer = Rest;
                tday.setText("Today is your Rest day");
                tmday.setText("Tomorrow is Push A");
                rmday.setText("Your next rest day is in 7 days");
            }
            if (dayselected == 1) {
                excer = Legsb;
                tday.setText("Today is Legs B");
                tmday.setText("Tomorrow is your Rest Day");
                rmday.setText("Your next rest day is tomorrow");
            }
            if (dayselected == 2) {
                excer = Pullb;
                tday.setText("Today is Pull B");
                tmday.setText("Tomorrow is Legs B");
                rmday.setText("Your next rest day is in 2 days");
            }
            if (dayselected == 3) {
                excer = Pushb;
                tday.setText("Today is Push B");
                tmday.setText("Tomorrow is Pull B");
                rmday.setText("Your next rest day is in 3 days");
            }
            if (dayselected == 4) {
                excer = Legsa;
                tday.setText("Today is Legs A");
                tmday.setText("Tomorrow is Push B");
                rmday.setText("Your next rest day is in 4 days");
            }
            if (dayselected == 5) {
                excer = Pulla;
                tday.setText("Today is Pull A");
                tmday.setText("Tomorrow is Legs A");
                rmday.setText("Your next rest day is in 5 days");
            }
        } else if (day2 == 2) {
            if (dayselected == 0) {
                excer = Pusha;
                tday.setText("Today is Push A");
                tmday.setText("Tomorrow is Pull A");
                rmday.setText("Your next rest day is in 6 days");
            }
            if (dayselected == 1) {
                excer = Rest;
                tday.setText("Today is your Rest day");
                tmday.setText("Tomorrow is Push A");
                rmday.setText("Your next rest day is in 7 days");
            }
            if (dayselected == 2) {
                excer = Legsb;
                tday.setText("Today is Legs B");
                tmday.setText("Tomorrow is your Rest Day");
                rmday.setText("Your next rest day is tomorrow");
            }
            if (dayselected == 3) {
                excer = Pullb;
                tday.setText("Today is Pull B");
                tmday.setText("Tomorrow is Legs B");
                rmday.setText("Your next rest day is in 2 days");
            }
            if (dayselected == 4) {
                excer = Pushb;
                tday.setText("Today is Push B");
                tmday.setText("Tomorrow is Pull B");
                rmday.setText("Your next rest day is in 3 days");
            }
            if (dayselected == 5) {
                excer = Legsa;
                tday.setText("Today is Legs A");
                tmday.setText("Tomorrow is Push B");
                rmday.setText("Your next rest day is in 4 days");
            }
            if (dayselected == 6) {
                excer = Pulla;
                tday.setText("Today is Pull A");
                tmday.setText("Tomorrow is Legs A");
                rmday.setText("Your next rest day is in 5 days");
            }
        } else if (day2 == 3) {
            if (dayselected == 1) {
                excer = Pusha;
                tday.setText("Today is Push A");
                tmday.setText("Tomorrow is Pull A");
                rmday.setText("Your next rest day is in 6 days");
            }
            if (dayselected == 2) {
                excer = Rest;
                tday.setText("Today is your Rest day");
                tmday.setText("Tomorrow is Push A");
                rmday.setText("Your next rest day is in 7 days");
            }
            if (dayselected == 3) {
                excer = Legsb;
                tday.setText("Today is Legs B");
                tmday.setText("Tomorrow is your Rest Day");
                rmday.setText("Your next rest day is tomorrow");
            }
            if (dayselected == 4) {
                excer = Pullb;
                tday.setText("Today is Pull B");
                tmday.setText("Tomorrow is Legs B");
                rmday.setText("Your next rest day is in 2 days");
            }
            if (dayselected == 5) {
                excer = Pushb;
                tday.setText("Today is Push B");
                tmday.setText("Tomorrow is Pull B");
                rmday.setText("Your next rest day is in 3 days");
            }
            if (dayselected == 6) {
                excer = Legsa;
                tday.setText("Today is Legs A");
                tmday.setText("Tomorrow is Push B");
                rmday.setText("Your next rest day is in 4 days");
            }
            if (dayselected == 0) {
                excer = Pulla;
                tday.setText("Today is Pull A");
                tmday.setText("Tomorrow is Legs A");
                rmday.setText("Your next rest day is in 5 days");
            }
        } else if (day2 == 4) {
            if (dayselected == 2) {
                excer = Pusha;
                tday.setText("Today is Push A");
                tmday.setText("Tomorrow is Pull A");
                rmday.setText("Your next rest day is in 6 days");
            }
            if (dayselected == 3) {
                excer = Rest;
                tday.setText("Today is your Rest day");
                tmday.setText("Tomorrow is Push A");
                rmday.setText("Your next rest day is in 7 days");
            }
            if (dayselected == 4) {
                excer = Legsb;
                tday.setText("Today is Legs B");
                tmday.setText("Tomorrow is your Rest Day");
                rmday.setText("Your next rest day is tomorrow");
            }
            if (dayselected == 5) {
                excer = Pullb;
                tday.setText("Today is Pull B");
                tmday.setText("Tomorrow is Legs B");
                rmday.setText("Your next rest day is in 2 days");
            }
            if (dayselected == 6) {
                excer = Pushb;
                tday.setText("Today is Push B");
                tmday.setText("Tomorrow is Pull B");
                rmday.setText("Your next rest day is in 3 days");
            }
            if (dayselected == 0) {
                excer = Legsa;
                tday.setText("Today is Legs A");
                tmday.setText("Tomorrow is Push B");
                rmday.setText("Your next rest day is in 4 days");
            }
            if (dayselected == 1) {
                excer = Pulla;
                tday.setText("Today is Pull A");
                tmday.setText("Tomorrow is Legs A");
                rmday.setText("Your next rest day is in 5 days");
            }
        } else if (day2 == 5) {
            if (dayselected == 3) {
                excer = Pusha;
                tday.setText("Today is Push A");
                tmday.setText("Tomorrow is Pull A");
                rmday.setText("Your next rest day is in 6 days");
            }
            if (dayselected == 4) {
                excer = Rest;
                tday.setText("Today is your Rest day");
                tmday.setText("Tomorrow is Push A");
                rmday.setText("Your next rest day is in 7 days");
            }
            if (dayselected == 5) {
                excer = Legsb;
                tday.setText("Today is Legs B");
                tmday.setText("Tomorrow is your Rest Day");
                rmday.setText("Your next rest day is tomorrow");
            }
            if (dayselected == 6) {
                excer = Pullb;
                tday.setText("Today is Pull B");
                tmday.setText("Tomorrow is Legs B");
                rmday.setText("Your next rest day is in 2 days");
            }
            if (dayselected == 0) {
                excer = Pushb;
                tday.setText("Today is Push B");
                tmday.setText("Tomorrow is Pull B");
                rmday.setText("Your next rest day is in 3 days");
            }
            if (dayselected == 1) {
                excer = Legsa;
                tday.setText("Today is Legs A");
                tmday.setText("Tomorrow is Push B");
                rmday.setText("Your next rest day is in 4 days");
            }
            if (dayselected == 2) {
                excer = Pulla;
                tday.setText("Today is Pull A");
                tmday.setText("Tomorrow is Legs A");
                rmday.setText("Your next rest day is in 5 days");
            }
        } else if (day2 == 6) {
            if (dayselected == 4) {
                excer = Pusha;
                tday.setText("Today is Push A");
                tmday.setText("Tomorrow is Pull A");
                rmday.setText("Your next rest day is in 6 days");
            }
            if (dayselected == 5) {
                excer = Rest;
                tday.setText("Today is your Rest day");
                tmday.setText("Tomorrow is Push A");
                rmday.setText("Your next rest day is in 7 days");
            }
            if (dayselected == 6) {
                excer = Legsb;
                tday.setText("Today is Legs B");
                tmday.setText("Tomorrow is your Rest Day");
                rmday.setText("Your next rest day is tomorrow");
            }
            if (dayselected == 0) {
                excer = Pullb;
                tday.setText("Today is Pull B");
                tmday.setText("Tomorrow is Legs B");
                rmday.setText("Your next rest day is in 2 days");
            }
            if (dayselected == 1) {
                excer = Pushb;
                tday.setText("Today is Push B");
                tmday.setText("Tomorrow is Pull B");
                rmday.setText("Your next rest day is in 3 days");
            }
            if (dayselected == 2) {
                excer = Legsa;
                tday.setText("Today is Legs A");
                tmday.setText("Tomorrow is Push B");
                rmday.setText("Your next rest day is in 4 days");
            }
            if (dayselected == 3) {
                excer = Pulla;
                tday.setText("Today is Pull A");
                tmday.setText("Tomorrow is Legs A");
                rmday.setText("Your next rest day is in 5 days");
            }
        } else if (day2 == 7) {
            if (dayselected == 5) {
                excer = Pusha;
                tday.setText("Today is Push A");
                tmday.setText("Tomorrow is Pull A");
                rmday.setText("Your next rest day is in 6 days");
            }
            if (dayselected == 6) {
                excer = Rest;
                tday.setText("Today is your Rest day");
                tmday.setText("Tomorrow is Push A");
                rmday.setText("Your next rest day is in 7 days");
            }
            if (dayselected == 0) {
                excer = Legsb;
                tday.setText("Today is Legs B");
                tmday.setText("Tomorrow is your Rest Day");
                rmday.setText("Your next rest day is tomorrow");
            }
            if (dayselected == 1) {
                excer = Pullb;
                tday.setText("Today is Pull B");
                tmday.setText("Tomorrow is Legs B");
                rmday.setText("Your next rest day is in 2 days");
            }
            if (dayselected == 2) {
                excer = Pushb;
                tday.setText("Today is Push B");
                tmday.setText("Tomorrow is Pull B");
                rmday.setText("Your next rest day is in 3 days");
            }
            if (dayselected == 3) {
                excer = Legsa;
                tday.setText("Today is Legs A");
                tmday.setText("Tomorrow is Push B");
                rmday.setText("Your next rest day is in 4 days");
            }
            if (dayselected == 4) {
                excer = Pulla;
                tday.setText("Today is Pull A");
                tmday.setText("Tomorrow is Legs A");
                rmday.setText("Your next rest day is in 5 days");
            }
        }
    }

    @Override
    public void onBackPressed() {

        Context context = getApplicationContext();
        switch (page) {

            case 1:
                finish();
                break;
            case 2:
                Toast.makeText(context, "Press back again to end session", Toast.LENGTH_SHORT).show();
                page = 5;
                break;
            case 3:
                if (start == 0) {
                    sc1.setVisibility(View.GONE);
                    sc2.setVisibility(View.VISIBLE);
                    if (count2[0] == 0) {
                        c1.setVisibility(View.VISIBLE);
                    }
                    if (count2[1] == 0) {
                        c2.setVisibility(View.VISIBLE);
                    }
                    if (count2[2] == 0) {
                        c3.setVisibility(View.VISIBLE);
                    }
                    if (count2[3] == 0) {
                        c4.setVisibility(View.VISIBLE);
                    }
                    if (count2[4] == 0) {
                        c5.setVisibility(View.VISIBLE);
                    }
                    if (count2[5] == 0) {
                        c6.setVisibility(View.VISIBLE);
                    }
                    c20.setVisibility(View.INVISIBLE);
                    c21.setVisibility(View.INVISIBLE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);
                    c10.setVisibility(View.GONE);
                    c19.setVisibility(View.GONE);
                    hc.setVisibility(View.GONE);
                    hc1.setVisibility(View.GONE);
                    hc2.setVisibility(View.GONE);
                    hc3.setVisibility(View.GONE);
                    hc4.setVisibility(View.GONE);
                    hc5.setVisibility(View.GONE);
                    hc6.setVisibility(View.GONE);
                    page = 1;
                } else if (start == 3) {
                    c21.setVisibility(View.VISIBLE);
                    a1.setVisibility(View.VISIBLE);
                    a2.setVisibility(View.VISIBLE);
                    a3.setVisibility(View.VISIBLE);
                    a4.setVisibility(View.VISIBLE);
                    a5.setVisibility(View.VISIBLE);
                    a6.setVisibility(View.VISIBLE);
                    a7.setVisibility(View.VISIBLE);
                    a8.setVisibility(View.VISIBLE);
                    a9.setVisibility(View.VISIBLE);
                    c20.setVisibility(View.VISIBLE);

                    page = 2;
                } else {
                    if (count2[0] == 0) {
                        c1.setVisibility(View.VISIBLE);
                    }
                    if (count2[1] == 0) {
                        c2.setVisibility(View.VISIBLE);
                    }
                    if (count2[2] == 0) {
                        c3.setVisibility(View.VISIBLE);
                    }
                    if (count2[3] == 0) {
                        c4.setVisibility(View.VISIBLE);
                    }
                    if (count2[4] == 0) {
                        c5.setVisibility(View.VISIBLE);
                    }
                    if (count2[5] == 0) {
                        c6.setVisibility(View.VISIBLE);
                    }
                    if (count2[0] == 0 || count2[1] == 0 || count2[2] == 0 || count2[3] == 0 || count2[4] == 0 || count2[5] == 0) {
                        c20.setVisibility(View.VISIBLE);
                        c21.setVisibility(View.VISIBLE);
                    } else {
                        c20.setVisibility(View.INVISIBLE);
                        c21.setVisibility(View.INVISIBLE);
                    }
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);
                    c10.setVisibility(View.GONE);
                    c19.setVisibility(View.GONE);
                    hc.setVisibility(View.GONE);
                    hc1.setVisibility(View.GONE);
                    hc2.setVisibility(View.GONE);
                    hc3.setVisibility(View.GONE);
                    hc4.setVisibility(View.GONE);
                    hc5.setVisibility(View.GONE);
                    hc6.setVisibility(View.GONE);
                    page = 2;
                }
                sc3.setVisibility(View.GONE);
                bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                break;
            case 4:
                if (start == 0) {
                    sc1.setVisibility(View.GONE);
                    sc2.setVisibility(View.VISIBLE);
                    if (count2[0] == 0) {
                        c1.setVisibility(View.VISIBLE);
                    }
                    if (count2[1] == 0) {
                        c2.setVisibility(View.VISIBLE);
                    }
                    if (count2[2] == 0) {
                        c3.setVisibility(View.VISIBLE);
                    }
                    if (count2[3] == 0) {
                        c4.setVisibility(View.VISIBLE);
                    }
                    if (count2[4] == 0) {
                        c5.setVisibility(View.VISIBLE);
                    }
                    if (count2[5] == 0) {
                        c6.setVisibility(View.VISIBLE);
                    }
                    c20.setVisibility(View.INVISIBLE);
                    c21.setVisibility(View.INVISIBLE);
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);
                    c10.setVisibility(View.GONE);
                    c19.setVisibility(View.GONE);
                    hc.setVisibility(View.GONE);
                    hc1.setVisibility(View.GONE);
                    hc2.setVisibility(View.GONE);
                    hc3.setVisibility(View.GONE);
                    hc4.setVisibility(View.GONE);
                    hc5.setVisibility(View.GONE);
                    hc6.setVisibility(View.GONE);
                    page = 1;
                } else if (start == 3) {
                    c21.setVisibility(View.VISIBLE);
                    a1.setVisibility(View.VISIBLE);
                    a2.setVisibility(View.VISIBLE);
                    a3.setVisibility(View.VISIBLE);
                    a4.setVisibility(View.VISIBLE);
                    a5.setVisibility(View.VISIBLE);
                    a6.setVisibility(View.VISIBLE);
                    a7.setVisibility(View.VISIBLE);
                    a8.setVisibility(View.VISIBLE);
                    a9.setVisibility(View.VISIBLE);
                    c20.setVisibility(View.VISIBLE);

                    page = 2;
                } else {
                    if (count2[0] == 0) {
                        c1.setVisibility(View.VISIBLE);
                    }
                    if (count2[1] == 0) {
                        c2.setVisibility(View.VISIBLE);
                    }
                    if (count2[2] == 0) {
                        c3.setVisibility(View.VISIBLE);
                    }
                    if (count2[3] == 0) {
                        c4.setVisibility(View.VISIBLE);
                    }
                    if (count2[4] == 0) {
                        c5.setVisibility(View.VISIBLE);
                    }
                    if (count2[5] == 0) {
                        c6.setVisibility(View.VISIBLE);
                    }
                    if (count2[0] == 0 || count2[1] == 0 || count2[2] == 0 || count2[3] == 0 || count2[4] == 0 || count2[5] == 0) {
                        c20.setVisibility(View.VISIBLE);
                        c21.setVisibility(View.VISIBLE);
                    } else {
                        c20.setVisibility(View.INVISIBLE);
                        c21.setVisibility(View.INVISIBLE);
                    }
                    c7.setVisibility(View.GONE);
                    c8.setVisibility(View.GONE);
                    c9.setVisibility(View.GONE);
                    c10.setVisibility(View.GONE);
                    c19.setVisibility(View.GONE);
                    hc.setVisibility(View.GONE);
                    hc1.setVisibility(View.GONE);
                    hc2.setVisibility(View.GONE);
                    hc3.setVisibility(View.GONE);
                    hc4.setVisibility(View.GONE);
                    hc5.setVisibility(View.GONE);
                    hc6.setVisibility(View.GONE);
                    page = 2;
                }
                sc3.setVisibility(View.GONE);
                bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                break;
            case 5:

                c1.setVisibility(View.GONE);
                c2.setVisibility(View.GONE);
                c3.setVisibility(View.GONE);
                c4.setVisibility(View.GONE);
                c5.setVisibility(View.GONE);
                c6.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a9.setVisibility(View.GONE);
                sc1.setVisibility(View.GONE);
                sc3.setVisibility(View.GONE);
                sc2.setVisibility(View.VISIBLE);
                c20.setVisibility(View.INVISIBLE);
                c21.setVisibility(View.INVISIBLE);
                page = 1;
                start = 0;
                bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                break;
            case 99:
                Toast.makeText(context, "Press back again to end session", Toast.LENGTH_SHORT).show();
                page = 5;
                break;
        }
    }

    public static boolean setNumberPickerTextColor(NumberPicker numberPicker) {
        final int count = numberPicker.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = numberPicker.getChildAt(i);
            if (child instanceof EditText) {
                try {
                    Field selectorWheelPaintField = numberPicker.getClass()
                            .getDeclaredField("mSelectorWheelPaint");
                    selectorWheelPaintField.setAccessible(true);
                    ((Paint) selectorWheelPaintField.get(numberPicker)).setColor(Color.DKGRAY);
                    ((EditText) child).setTextColor(Color.DKGRAY);
                    numberPicker.invalidate();
                    return true;
                } catch (NoSuchFieldException e) {} catch (IllegalAccessException e) {} catch (IllegalArgumentException e) {}
            }
        }
        return false;
    }
}