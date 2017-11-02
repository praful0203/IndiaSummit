package com.prafulmishra.girlscriptsummit;

import android.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prafulmishra.girlscriptsummit.data.Participant;
import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ParticipantActivity extends AppCompatActivity {

    List<Integer> ImageList = new ArrayList<>();
    Button btnApply;
    EditText partpntName,txtCity,txtCol_org,txtMob,txtMail,txtExpect,txtEvent,txtAltitude;
    RatingBar rtTech,rtLead;
    RadioGroup rdGroup;
    Handler mHandler;
    RadioButton rb;
    String name,city,college_org,date,mobile,mailid,expect,events_attended,next_5years,attend_event,uid=" ",time_added;
    Float tech_skills,lead_skills;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference,databaseParticipant;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.prafulmishra.girlscriptsummit.R.layout.activity_participant);
        Toolbar toolbar = (Toolbar) findViewById(com.prafulmishra.girlscriptsummit.R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseParticipant = FirebaseDatabase.getInstance().getReference("participants");

        partpntName = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.partpntName);
        txtCity = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtCity);
        txtCol_org = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtCol_org);
        txtMob = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtMob);
        txtMail = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtMail);
        txtExpect = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtExpect);
        txtEvent = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtEvent);
        txtAltitude = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.txtAltitude);

        rdGroup = (RadioGroup)findViewById(com.prafulmishra.girlscriptsummit.R.id.rdGroup);

        ImageList.add(com.prafulmishra.girlscriptsummit.R.drawable.gs_progress);
        ImageList.add(com.prafulmishra.girlscriptsummit.R.drawable.gs_progress1);



        rtLead = (RatingBar)findViewById(com.prafulmishra.girlscriptsummit.R.id.rtLead);
        rtTech = (RatingBar)findViewById(com.prafulmishra.girlscriptsummit.R.id.rtTech);
        btnApply = (Button)findViewById(com.prafulmishra.girlscriptsummit.R.id.btnApplypart);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);

        databaseReference = FirebaseDatabase.getInstance().getReference("participants");
        firebaseAuth = FirebaseAuth.getInstance();

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                // This is where you do your work in the UI thread.
                // Your worker tells you in the message what to do.
                Toast.makeText(ParticipantActivity.this, "Registration Successful !\nFor further queries visit https://gsindiasummit.com", Toast.LENGTH_LONG).show();
            }
        };

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextData();
               // Toast.makeText(ParticipantActivity.this, name+" "+city+" "+college_org+" "+mobile+" "+mailid+" "+expect+" "+events_attended+" "+next_5years+" "+attend_event+" "+tech_skills+" "+lead_skills , Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.prafulmishra.girlscriptsummit.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void getTextData() {
        name = partpntName.getText().toString();
        city = txtCity.getText().toString();
        college_org = txtCol_org.getText().toString();
        mobile = txtMob.getText().toString();
        mailid = txtMail.getText().toString();
        expect = txtExpect.getText().toString();
        events_attended = txtEvent.getText().toString();
        next_5years = txtAltitude.getText().toString();
        tech_skills = rtTech.getRating();
        lead_skills = rtLead.getRating();
        time_added = Calendar.getInstance().getTime().toString();
        date = DateFormat.getDateInstance().format(new Date());

        boolean failFlag = false;

        if( name.length() == 0 )
        {
            failFlag = true;
            partpntName.setError( "Field cannot be empty" );
            partpntName.requestFocus();
        }
        if( city.trim().length() == 0 )
        {
            failFlag = true;
            txtCity.setError( "Field cannot be empty" );
            txtCity.requestFocus();
        }
        if( college_org.length() == 0 )
        {
            failFlag = true;
            txtCol_org.setError( "Field cannot be empty" );
            txtCol_org.requestFocus();
        }
        if( mobile.length() == 0 )
        {
            failFlag = true;
            txtMob.setError( "Field cannot be empty" );
            txtMob.requestFocus();
        }
        if(!isValidEmail(mailid))
        {
            failFlag = true;
            txtMail.setError( "Enter a valid email ID" );
            txtMail.requestFocus();
        }
        if( expect.length() == 0 )
        {
            failFlag = true;
            txtExpect.setError( "Field cannot be empty" );
            txtExpect.requestFocus();
        }
        if( next_5years.length() == 0 )
        {
            failFlag = true;
            txtAltitude.setError( "Field cannot be empty" );
            txtAltitude.requestFocus();
        }
        // if all are fine
        if (!failFlag) {
            showFlipProgressDialog();
            uid = firebaseAuth.getCurrentUser().getUid();
            Participant participant = new Participant(name,city,college_org,mobile,mailid,expect,events_attended,tech_skills,lead_skills,next_5years,attend_event,time_added);
            databaseParticipant.child(date).child(uid).child(participant.getMobile()).setValue(participant);
        }
    }

    private void showInfo() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ParticipantActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Participation Registration");

        // Setting Dialog Message
        alertDialog.setMessage(getString(com.prafulmishra.girlscriptsummit.R.string.participant));

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

    public void rbClick(View v)
    {
        int rbId = rdGroup.getCheckedRadioButtonId();
        rb = (RadioButton)findViewById(rbId);
        attend_event = rb.getText().toString();
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
