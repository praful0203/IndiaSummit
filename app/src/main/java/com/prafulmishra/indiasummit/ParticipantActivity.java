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

public class ParticipantActivity extends AppCompatActivity {
    Button btnApply;
    EditText partpntName,txtCity,txtCol_org,txtMob,txtMail,txtExpect,txtEvent,txtAltitude;
    RatingBar rtTech,rtLead;
    RadioGroup rdGroup;
    RadioButton rbtnYes,rdbtnMaybe,rdbtnNo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        partpntName = (EditText)findViewById(R.id.partpntName);
        txtCity = (EditText)findViewById(R.id.txtCity);
        txtCol_org = (EditText)findViewById(R.id.txtCol_org);
        txtMob = (EditText)findViewById(R.id.txtMob);
        txtMail = (EditText)findViewById(R.id.txtMail);
        txtExpect = (EditText)findViewById(R.id.txtExpect);
        txtEvent = (EditText)findViewById(R.id.txtEvent);
        txtAltitude = (EditText)findViewById(R.id.txtAltitude);

        rdGroup = (RadioGroup)findViewById(R.id.rdGroup);
        rbtnYes = (RadioButton)findViewById(R.id.rbtnYes);
        rdbtnMaybe = (RadioButton)findViewById(R.id.rdbtnMaybe);
        rdbtnNo = (RadioButton)findViewById(R.id.rdbtnNo);

        rtLead = (RatingBar)findViewById(R.id.rtLead);
        rtTech = (RatingBar)findViewById(R.id.rtTech);
        btnApply = (Button)findViewById(R.id.btnApplypart);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ParticipantActivity.this, "Rating :"+rtTech.getRating(), Toast.LENGTH_SHORT).show();
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
}
