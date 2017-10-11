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
import android.widget.Toast;

public class TwentyoneActivity extends AppCompatActivity {
Button btnApply,btnSetDate;
   int year, month, day;
    static final int DIALOG_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentyone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnSetDate = (Button)findViewById(R.id.btnSetDate);
        btnApply = (Button)findViewById(R.id.btnApplytwenty);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnApply.setTypeface(typeface);
        btnSetDate.setTypeface(typeface);

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
}
