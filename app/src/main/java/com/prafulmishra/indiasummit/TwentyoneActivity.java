package com.prafulmishra.indiasummit;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prafulmishra.indiasummit.data.Twentyone;

import static com.prafulmishra.indiasummit.R.id.rdGroup;
import static com.prafulmishra.indiasummit.R.id.txtCity;

public class TwentyoneActivity extends AppCompatActivity {
Button btnApply,btnSetDate;

    EditText txtNominator,txtNominee,txtCity21,txtMob,txtMail,txtAchieve,txtProudyear,txtGet21,txtSociallinks,txtReference,txtSpeak,txtMessagetoYouth;
    String dob,nominator,nominee,city,mobile_21,mailid,achieve,proudyear,ifget21,social_link,references,speakat_event,messageto_youth,attend_event;
    RadioGroup rg21;
    RadioButton rbutton;
    DatabaseReference databaseTwentyone;
   int year, month, day;
    static final int DIALOG_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentyone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseTwentyone = FirebaseDatabase.getInstance().getReference("twentyone");

        btnSetDate = (Button)findViewById(R.id.btnSetDate);
        btnApply = (Button)findViewById(R.id.btnApplytwenty);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);
        btnSetDate.setTypeface(typeface);
        rg21 = (RadioGroup)findViewById(R.id.rgTwentyone);
        txtNominator = (EditText)findViewById(R.id.txtNominator);
        txtNominee = (EditText)findViewById(R.id.txtNominee);
        txtCity21  = (EditText)findViewById(R.id.txtCity21);
        txtMob = (EditText)findViewById(R.id.txtMob);
        txtMail = (EditText)findViewById(R.id.txtMail);
        txtAchieve = (EditText)findViewById(R.id.txtAchieve);
        txtProudyear = (EditText)findViewById(R.id.txtProudyear);
        txtGet21 = (EditText)findViewById(R.id.txtGet21);
        txtSociallinks = (EditText)findViewById(R.id.txtSociallinks);
        txtReference = (EditText)findViewById(R.id.txtReference);
        txtSpeak = (EditText)findViewById(R.id.txtSpeak);
        txtMessagetoYouth = (EditText)findViewById(R.id.txtMessagetoYouth);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo21();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });

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

        boolean failFlag = false;

        if( nominator.length() == 0 )
        {
            failFlag = true;
            txtNominator.setError( "Field cannot be empty" );
        }
        if( nominee.trim().length() == 0 )
        {
            failFlag = true;
            txtNominee.setError( "Field cannot be empty" );
        }
        if( city.trim().length() == 0 )
        {
            failFlag = true;
            txtCity21.setError( "Field cannot be empty" );
        }
        if( mobile_21.length() == 0 )
        {
            failFlag = true;
            txtMob.setError( "Field cannot be empty" );
        }
        if( mailid.length() == 0 )
        {
            failFlag = true;
            txtMail.setError( "Field cannot be empty" );
        }
        if( achieve.length() == 0 )
        {
            failFlag = true;
            txtAchieve.setError( "Field cannot be empty" );
        }
        if( proudyear.length() == 0 )
        {
            failFlag = true;
            txtProudyear.setError( "Field cannot be empty" );
        }
        if( ifget21.length() == 0 )
        {
            failFlag = true;
            txtGet21.setError( "Field cannot be empty" );
        }
        if( social_link.length() == 0 )
        {
            failFlag = true;
            txtSociallinks.setError( "Field cannot be empty" );
        }
        if( references.length() == 0 )
        {
            failFlag = true;
            txtReference.setError( "Field cannot be empty" );
        }
        if( speakat_event.length() == 0 )
        {
            failFlag = true;
            txtSpeak.setError( "Field cannot be empty" );
        }
        if( messageto_youth.length() == 0 )
        {
            failFlag = true;
            txtMessagetoYouth.setError( "Field cannot be empty" );
        }
        // if all are fine
        if (!failFlag) {
            String id = databaseTwentyone.push().getKey();
            Twentyone twentyone = new Twentyone(dob,nominator,nominee,city,mobile_21,mailid,achieve,proudyear,ifget21,social_link,references,speakat_event,messageto_youth,attend_event);
            databaseTwentyone.child(id).setValue(twentyone);
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
        alertDialog.setMessage(getString(R.string.twentyone));

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

    public void rbClicktwenty(View view) {
        int rbuttonId = rg21.getCheckedRadioButtonId();
        rbutton = (RadioButton)findViewById(rbuttonId);
        attend_event = rbutton.getText().toString();
    }
}
