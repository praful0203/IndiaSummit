package com.prafulmishra.indiasummit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prafulmishra.indiasummit.data.Participant;
import com.prafulmishra.indiasummit.data.WomenInTech;
import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WomenActivity extends AppCompatActivity {
Button btnApply;
    EditText txtName,txtCity,txtCol_org,txtMob,txtMail,txtOtherskill,txtWomenintech;
    String name,city,col_org,date,mobile_no,mail_id,other_skills,word_aboutwitech,html_knowledge,join_indiasummi,practice,stipend,uid="",time_added;
    float tech_skills;
    RadioGroup rdGroupHtml,rdGroupdates,rdGroupPractice,rdGroupStipend;
    RatingBar rtTechskills;
    List<Integer> ImageList = new ArrayList<>();
    Handler mHandler;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseWomen,databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseWomen = FirebaseDatabase.getInstance().getReference("women_in_tech");

        rtTechskills = (RatingBar)findViewById(R.id.rtTechskills);

        txtName = (EditText) findViewById(R.id.txtName);
        txtCity = (EditText) findViewById(R.id.txtCity);
        txtCol_org = (EditText) findViewById(R.id.txtCol_org);
        txtMob = (EditText) findViewById(R.id.txtMob);
        txtMail = (EditText) findViewById(R.id.txtMail);
        txtOtherskill = (EditText) findViewById(R.id.txtOtherskill);
        txtWomenintech = (EditText) findViewById(R.id.txtWomenintech);

        ImageList.add(R.drawable.gs_progress);
        ImageList.add(R.drawable.gs_progress1);

        rdGroupHtml = (RadioGroup)findViewById(R.id.rgHtml);
        rdGroupdates = (RadioGroup)findViewById(R.id.rgdates);
        rdGroupPractice = (RadioGroup)findViewById(R.id.rgPractice);
        rdGroupStipend = (RadioGroup)findViewById(R.id.rgStipend);

        databaseReference = FirebaseDatabase.getInstance().getReference("women_in_tech");
        firebaseAuth = FirebaseAuth.getInstance();

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                // This is where you do your work in the UI thread.
                // Your worker tells you in the message what to do.
                Toast.makeText(WomenActivity.this, "Registration Successful !\nFor further queries visit https://gsindiasummit.com", Toast.LENGTH_LONG).show();
            }
        };

        btnApply = (Button)findViewById(R.id.btnApplywomen);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataWomen();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void getDataWomen() {
        name = txtName.getText().toString();
        city = txtCity.getText().toString();
        col_org = txtCol_org.getText().toString();
        mobile_no = txtMob.getText().toString();
        mail_id = txtMail.getText().toString();
        other_skills = txtOtherskill.getText().toString();
        word_aboutwitech = txtWomenintech.getText().toString();
        tech_skills = rtTechskills.getRating();
        time_added = Calendar.getInstance().getTime().toString();
        android.icu.util.Calendar calendar = android.icu.util.Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MM-yyyy");
        date = mdformat.format(calendar.getTime());


        boolean failFlag = false;

        if( name.length() == 0 )
        {
            failFlag = true;
            txtName.setError( "Field cannot be empty" );
            txtName.requestFocus();
        }
        if( city.trim().length() == 0 )
        {
            failFlag = true;
            txtCity.setError( "Field cannot be empty" );
            txtCity.requestFocus();
        }
        if( col_org.length() == 0 )
        {
            failFlag = true;
            txtCol_org.setError( "Field cannot be empty" );
            txtCol_org.requestFocus();
        }
        if( mobile_no.length() == 0 )
        {
            failFlag = true;
            txtMob.setError( "Field cannot be empty" );
            txtMob.requestFocus();
        }
        if(!isValidEmail(mail_id))
        {
                failFlag = true;
                txtMail.setError( "Enter a valid email ID" );
                txtMail.requestFocus();

        }
        if( other_skills.length() == 0 )
        {
            failFlag = true;
            txtOtherskill.setError( "Field cannot be empty" );
            txtOtherskill.requestFocus();
        }
        if( word_aboutwitech.length() == 0 )
        {
            failFlag = true;
            txtWomenintech.setError( "Field cannot be empty" );
            txtWomenintech.requestFocus();
        }
        // if all are fine
        if (!failFlag) {
            showFlipProgressDialog();
            uid = firebaseAuth.getCurrentUser().getUid();
            WomenInTech womenInTech = new WomenInTech(name,city,col_org,mobile_no,mail_id,other_skills,word_aboutwitech,html_knowledge,join_indiasummi,practice,stipend,tech_skills,time_added);
            databaseWomen.child(date).child(uid).child(womenInTech.getMobile_no()).setValue(womenInTech);
        }
    }

    private void showInfo() {
        final AlertDialog alertDialog = new AlertDialog.Builder(WomenActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Women World Record Registration");

        // Setting Dialog Message
        alertDialog.setMessage(getString(R.string.women_info));

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.button);

        //sets the property that the dialog can be cancelled or not

        alertDialog.setCancelable(false);
        // Setting OK Button
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // continue with discard
                alertDialog.dismiss();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }

    private void showFlipProgressDialog() {
        final FlipProgressDialog flip = new FlipProgressDialog();
        flip.setImageList(ImageList);
        flip.setBackgroundAlpha(1.0f);
        flip.setBackgroundColor(Color.parseColor("#FFDD2C00"));
        flip.setDimAmount(0.8f);
        flip.setCancelable(false);
        flip.setCornerRadius(200);
        flip.setDuration(800);
        flip.show(getFragmentManager(),"");
        long delayInMillis = 5000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                flip.dismiss();
                Message message = mHandler.obtainMessage();
                message.sendToTarget();
                Intent intent = new Intent(getApplicationContext(),ApplyActivity.class);
                startActivity(intent);
            }
        }, delayInMillis);
    }

    public void rbClickJoinIS(View v)
    {
        int rbuttonId = rdGroupdates.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(rbuttonId);
        join_indiasummi = rb.getText().toString();
    }

    public  void rbClickHtml(View v){
        int rbuttonId = rdGroupHtml.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(rbuttonId);
        html_knowledge = rb.getText().toString();
    }

    public void rbClickPractice(View v) {
            int rbuttonId = rdGroupPractice.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton)findViewById(rbuttonId);
            practice = rb.getText().toString();
    }

    public void rbClickStipend(View v) {
            int rbuttonId = rdGroupStipend.getCheckedRadioButtonId();
            RadioButton rb4 = (RadioButton)findViewById(rbuttonId);
            stipend = rb4.getText().toString();
    }

    // validating email id

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
