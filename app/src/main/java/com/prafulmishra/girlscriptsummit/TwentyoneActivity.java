package com.prafulmishra.girlscriptsummit;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prafulmishra.girlscriptsummit.data.Twentyone;
import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TwentyoneActivity extends AppCompatActivity {

    Button btnApply,btnSetDate;
    List<Integer> ImageList = new ArrayList<>();
    EditText txtNominator,txtNominee,txtCity21,txtMob,txtMail,txtAchieve,txtProudyear,txtGet21,txtSociallinks,txtReference,txtSpeak,txtMessagetoYouth;
    String uid=" ",date,dob,nominator,time_added,nominee,city,mobile_21,mailid,achieve,proudyear,ifget21,social_link,references,speakat_event,messageto_youth,attend_event;
    RadioGroup rg21;
    RadioButton rbutton;
    Handler mHandler;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseTwentyone,databaseReference;
   int year, month, day;
    static final int DIALOG_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.prafulmishra.girlscriptsummit.R.layout.activity_twentyone);
        Toolbar toolbar = (Toolbar) findViewById(com.prafulmishra.girlscriptsummit.R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseTwentyone = FirebaseDatabase.getInstance().getReference("twentyone");

        ImageList.add(com.prafulmishra.girlscriptsummit.R.drawable.gs_progress);
        ImageList.add(com.prafulmishra.girlscriptsummit.R.drawable.gs_progress1);

        btnSetDate = (Button)findViewById(com.prafulmishra.girlscriptsummit.R.id.btnSetDate);
        btnApply = (Button)findViewById(com.prafulmishra.girlscriptsummit.R.id.btnApplytwenty);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);
        btnSetDate.setTypeface(typeface);
        rg21 = (RadioGroup)findViewById(com.prafulmishra.girlscriptsummit.R.id.rgTwentyone);
        txtNominator = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtNominator);
        txtNominee = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtNominee);
        txtCity21  = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtCity21);
        txtMob = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtMob);
        txtMail = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtMail);
        txtAchieve = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtAchieve);
        txtProudyear = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtProudyear);
        txtGet21 = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtGet21);
        txtSociallinks = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtSociallinks);
        txtReference = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtReference);
        txtSpeak = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtSpeak);
        txtMessagetoYouth = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtMessagetoYouth);


        FloatingActionButton fab = (FloatingActionButton) findViewById(com.prafulmishra.girlscriptsummit.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo21();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final java.util.Calendar calendar = java.util.Calendar.getInstance();
        year = calendar.get(java.util.Calendar.YEAR);
        month = calendar.get(java.util.Calendar.MONTH);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("twentyone");
        firebaseAuth = FirebaseAuth.getInstance();

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                // This is where you do your work in the UI thread.
                // Your worker tells you in the message what to do.
                Toast.makeText(TwentyoneActivity.this, "Registration Successful !\nWe'll mail you further details soon\nFor further queries visit https://gsindiasummit.com", Toast.LENGTH_LONG).show();
            }
        };

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData21();

            }
        });
    }

    private void getData21() {
        nominator = txtNominator.getText().toString();
        nominee = txtNominee.getText().toString();
        city = txtCity21.getText().toString();
        mobile_21 = txtMob.getText().toString();
        mailid = txtMail.getText().toString();
        achieve = txtAchieve.getText().toString();
        proudyear = txtProudyear.getText().toString();
        ifget21 = txtGet21.getText().toString();
        social_link = txtSociallinks.getText().toString();
        references = txtReference.getText().toString();
        speakat_event = txtSpeak.getText().toString();
        messageto_youth = txtMessagetoYouth.getText().toString();
        time_added = java.util.Calendar.getInstance().getTime().toString();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        date = df.format(c.getTime());

        boolean failFlag = false;

        if( nominator.length() == 0 )
        {
            failFlag = true;
            txtNominator.setError( "Field cannot be empty" );
            txtNominator.requestFocus();
        }
        if( nominee.trim().length() == 0 )
        {
            failFlag = true;
            txtNominee.setError( "Field cannot be empty" );
            txtNominee.requestFocus();
        }
        if( city.trim().length() == 0 )
        {
            failFlag = true;
            txtCity21.setError( "Field cannot be empty" );
            txtCity21.requestFocus();
        }
        if( mobile_21.length() == 0 )
        {
            failFlag = true;
            txtMob.setError( "Field cannot be empty" );
            txtMob.requestFocus();
        }
        if(!isValidEmail(mailid) )
        {
            failFlag = true;
            txtMail.setError( "Enter a valid email ID" );
            txtMail.requestFocus();
        }
        if( achieve.length() == 0 )
        {
            failFlag = true;
            txtAchieve.setError( "Field cannot be empty" );
            txtAchieve.requestFocus();
        }
        if( proudyear.length() == 0 )
        {
            failFlag = true;
            txtProudyear.setError( "Field cannot be empty" );
            txtProudyear.requestFocus();
        }
        if( ifget21.length() == 0 )
        {
            failFlag = true;
            txtGet21.setError( "Field cannot be empty" );
            txtGet21.requestFocus();
        }
        if( social_link.length() == 0 )
        {
            failFlag = true;
            txtSociallinks.setError( "Field cannot be empty" );
            txtSociallinks.requestFocus();
        }
        if( references.length() == 0 )
        {
            failFlag = true;
            txtReference.setError( "Field cannot be empty" );
            txtReference.requestFocus();
        }
        if( speakat_event.length() == 0 )
        {
            failFlag = true;
            txtSpeak.setError( "Field cannot be empty" );
            txtSpeak.requestFocus();
        }
        if( messageto_youth.length() == 0 )
        {
            failFlag = true;
            txtMessagetoYouth.setError( "Field cannot be empty" );
            txtMessagetoYouth.requestFocus();
        }
        // if all are fine
        if (!failFlag) {
            showFlipProgressDialog();
            uid = firebaseAuth.getCurrentUser().getUid();
            Twentyone twentyone = new Twentyone(dob,nominator,nominee,city,mobile_21,mailid,achieve,proudyear,ifget21,social_link,references,speakat_event,messageto_youth,attend_event,time_added);
            databaseTwentyone.child(date).child(uid).child(twentyone.getMobile_21()).setValue(twentyone);
        }
    }




    @Override
    protected Dialog onCreateDialog(int id){

        if (id == DIALOG_ID)
        {
            return new DatePickerDialog(this, dpickListener, year, month, day);
        }
        else
            return null;
    }

    private DatePickerDialog.OnDateSetListener dpickListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int yearofmonth, int monthofyear, int dayofmonth) {
            year = yearofmonth;
            month = monthofyear+1;
            day = dayofmonth;
           // Toast.makeText(TwentyoneActivity.this, "The Date selceted is :"+day+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
            btnSetDate.setText(""+day+"/"+month+"/"+year);
            dob = btnSetDate.getText().toString();
        }
    };

    private void showInfo21() {
        final AlertDialog alertDialog = new AlertDialog.Builder(TwentyoneActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("21 ON 21 Awards Registration");

        // Setting Dialog Message
        alertDialog.setMessage(getString(com.prafulmishra.girlscriptsummit.R.string.twentyone));

        // Setting Icon to Dialog
        alertDialog.setIcon(com.prafulmishra.girlscriptsummit.R.drawable.button);

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

    public void rbClicktwenty(View view) {
        int rbuttonId = rg21.getCheckedRadioButtonId();
        rbutton = (RadioButton)findViewById(rbuttonId);
        attend_event = rbutton.getText().toString();
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
