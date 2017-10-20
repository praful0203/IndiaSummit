package com.prafulmishra.indiasummit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prafulmishra.indiasummit.data.Participant;

public class ParticipantActivity extends AppCompatActivity {

    Button btnApply;
    EditText partpntName,txtCity,txtCol_org,txtMob,txtMail,txtExpect,txtEvent,txtAltitude;
    RatingBar rtTech,rtLead;
    RadioGroup rdGroup;
    RadioButton rb;
    String name,city,college_org,mobile,mailid,expect,events_attended,next_5years,attend_event;
    Float tech_skills,lead_skills;

   DatabaseReference databaseParticipant;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseParticipant = FirebaseDatabase.getInstance().getReference("participants");

        partpntName = (EditText)findViewById(R.id.partpntName);
        txtCity = (EditText)findViewById(R.id.txtCity);
        txtCol_org = (EditText)findViewById(R.id.txtCol_org);
        txtMob = (EditText)findViewById(R.id.txtMob);
        txtMail = (EditText)findViewById(R.id.txtMail);
        txtExpect = (EditText)findViewById(R.id.txtExpect);
        txtEvent = (EditText)findViewById(R.id.txtEvent);
        txtAltitude = (EditText)findViewById(R.id.txtAltitude);

        rdGroup = (RadioGroup)findViewById(R.id.rdGroup);


        rtLead = (RatingBar)findViewById(R.id.rtLead);
        rtTech = (RatingBar)findViewById(R.id.rtTech);
        btnApply = (Button)findViewById(R.id.btnApplypart);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextData();
               // Toast.makeText(ParticipantActivity.this, name+" "+city+" "+college_org+" "+mobile+" "+mailid+" "+expect+" "+events_attended+" "+next_5years+" "+attend_event+" "+tech_skills+" "+lead_skills , Toast.LENGTH_SHORT).show();
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
           String id = databaseParticipant.push().getKey();
            Participant participant = new Participant(name,city,college_org,mobile,mailid,expect,events_attended,tech_skills,lead_skills,next_5years,attend_event);
            databaseParticipant.child(id).setValue(participant);
            Toast.makeText(this, "Registration Done!\nFor further queries visit https://gsindiasummit.com", Toast.LENGTH_SHORT).show();
        }
    }

    private void showInfo() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ParticipantActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Participation Registration");

        // Setting Dialog Message
        alertDialog.setMessage(getString(R.string.participant));

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
