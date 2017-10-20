package com.prafulmishra.indiasummit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prafulmishra.indiasummit.data.Participant;
import com.prafulmishra.indiasummit.data.WomenInTech;

public class WomenActivity extends AppCompatActivity {
Button btnApply;
    EditText txtName,txtCity,txtCol_org,txtMob,txtMail,txtOtherskill,txtWomenintech;
    String name,city,col_org,mobile_no,mail_id,other_skills,word_aboutwitech,html_knowledge,join_indiasummi,practice,stipend;
    float tech_skills;
    RadioGroup rdGroupHtml,rdGroupdates,rdGroupPractice,rdGroupStipend;
    RatingBar rtTechskills;

    DatabaseReference databaseWomen;
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

        rdGroupHtml = (RadioGroup)findViewById(R.id.rgHtml);
        rdGroupdates = (RadioGroup)findViewById(R.id.rgdates);
        rdGroupPractice = (RadioGroup)findViewById(R.id.rgPractice);
        rdGroupStipend = (RadioGroup)findViewById(R.id.rgStipend);

        btnApply = (Button)findViewById(R.id.btnApplywomen);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataWomen();
               Toast.makeText(WomenActivity.this, name+" "+city+" "+col_org+" "+mobile_no+" "+mail_id+" "+other_skills+" "+word_aboutwitech+" "+tech_skills+" "+html_knowledge+" "+stipend+" "+practice+" "+join_indiasummi, Toast.LENGTH_SHORT).show();
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

        boolean failFlag = false;

        if( name.length() == 0 )
        {
            failFlag = true;
            txtName.setError( "Field cannot be empty" );
        }
        if( city.trim().length() == 0 )
        {
            failFlag = true;
            txtCity.setError( "Field cannot be empty" );
        }
        if( col_org.length() == 0 )
        {
            failFlag = true;
            txtCol_org.setError( "Field cannot be empty" );
        }
        if( mobile_no.length() == 0 )
        {
            failFlag = true;
            txtMob.setError( "Field cannot be empty" );
        }
        if( mail_id.length() == 0 )
        {
            failFlag = true;
            txtMail.setError( "Field cannot be empty" );
        }
        if( other_skills.length() == 0 )
        {
            failFlag = true;
            txtOtherskill.setError( "Field cannot be empty" );
        }
        if( word_aboutwitech.length() == 0 )
        {
            failFlag = true;
            txtWomenintech.setError( "Field cannot be empty" );
        }
        // if all are fine
        if (!failFlag) {
            String id = databaseWomen.push().getKey();
            WomenInTech womenInTech = new WomenInTech(name,city,col_org,mobile_no,mail_id,other_skills,word_aboutwitech,html_knowledge,join_indiasummi,practice,stipend,tech_skills);
            databaseWomen.child(id).setValue(womenInTech);
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
}
