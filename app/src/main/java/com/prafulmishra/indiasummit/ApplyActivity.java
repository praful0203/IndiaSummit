package com.prafulmishra.indiasummit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ApplyActivity extends AppCompatActivity {
Button btnPrtpnt, btnVolunteer, btnOn21, btnWomen;
ImageButton imgQ1,imgQ2,imgQ3,imgQ4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        btnPrtpnt = (Button)findViewById(R.id.btnPrtpnt);
        btnVolunteer = (Button)findViewById(R.id.btnVolunteer);
        btnOn21 = (Button)findViewById(R.id.btnOn21);
        btnWomen = (Button)findViewById(R.id.btnWomen);
        imgQ1 = (ImageButton)findViewById(R.id.imgQ1);
        imgQ2 = (ImageButton)findViewById(R.id.imgQ2);
        imgQ3 = (ImageButton)findViewById(R.id.imgQ3);
        imgQ4 = (ImageButton)findViewById(R.id.imgQ4);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnPrtpnt.setTypeface(typeface);
        btnVolunteer.setTypeface(typeface);
        btnOn21.setTypeface(typeface);
        btnWomen.setTypeface(typeface);

        btnPrtpnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prtpntReg();
            }
        });



        imgQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1();
            }
        });

        imgQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img2();
            }
        });

        imgQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img3();
            }
        });

        imgQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img4();
            }
        });
    }

    private void prtpntReg() {

        Intent intent = new Intent(getApplicationContext(),ParticipantActivity.class);
        startActivity(intent);

    }

    private void img1() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Participant");

        // Setting Dialog Message
        alertDialog.setMessage("Attend the Girlscript\'s 1st India Summit 2K17 at Ahmedabad!");

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

    private void img2() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Volunteer");

        // Setting Dialog Message
        alertDialog.setMessage("Become a Volunteer and contribute to India's 1st Women-oriented fest!");

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

    private void img3() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("21 ON 21");

        // Setting Dialog Message
        alertDialog.setMessage("If you are under age of 21 and achieved something great, then nominate yourself!");

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

    private void img4() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Women World Record");

        // Setting Dialog Message
        alertDialog.setMessage("Be a part of World Record! Come and join with us! (Only for women)");

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

