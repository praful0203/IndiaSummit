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

public class VolunteerActivity extends AppCompatActivity {
Button btnApply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnApply = (Button)findViewById(R.id.btnApplyvol);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoVol();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showInfoVol() {
            final AlertDialog alertDialog = new AlertDialog.Builder(VolunteerActivity.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Volunteer Registration");

            // Setting Dialog Message
            alertDialog.setMessage(getString(R.string.volunteership));

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
