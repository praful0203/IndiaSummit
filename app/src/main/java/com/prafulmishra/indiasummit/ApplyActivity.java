package com.prafulmishra.indiasummit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class ApplyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button btnPrtpnt, btnVolunteer, btnOn21, btnWomen;
    ImageButton imgQ1, imgQ2, imgQ3, imgQ4;
    TextView nav_headtitle;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);



        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout1);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);


        mtoolbar = (Toolbar) findViewById(R.id.nav_action);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mToggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorWhite));
        } else {
            mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        }
        setSupportActionBar(mtoolbar);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnPrtpnt = (Button) findViewById(R.id.btnPrtpnt);
        btnVolunteer = (Button) findViewById(R.id.btnVolunteer);
        btnOn21 = (Button) findViewById(R.id.btnOn21);
        btnWomen = (Button) findViewById(R.id.btnWomen);
        imgQ1 = (ImageButton) findViewById(R.id.imgQ1);
        imgQ2 = (ImageButton) findViewById(R.id.imgQ2);
        imgQ3 = (ImageButton) findViewById(R.id.imgQ3);
        imgQ4 = (ImageButton) findViewById(R.id.imgQ4);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnPrtpnt.setTypeface(typeface);
        btnVolunteer.setTypeface(typeface);
        btnOn21.setTypeface(typeface);
        btnWomen.setTypeface(typeface);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btnPrtpnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prtpntReg();
            }
        });

        btnVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volntrReg();
            }
        });


        btnOn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twentyonReg();
            }
        });


        btnWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                womenReg();
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


    private void womenReg() {

        Intent intent = new Intent(getApplicationContext(), WomenActivity.class);
        startActivity(intent);
    }

    private void twentyonReg() {

        Intent intent = new Intent(getApplicationContext(), TwentyoneActivity.class);
        startActivity(intent);
    }


    private void prtpntReg() {

        Intent intent = new Intent(getApplicationContext(), ParticipantActivity.class);
        startActivity(intent);

    }


    private void volntrReg() {

        Intent intent = new Intent(getApplicationContext(), VolunteerActivity.class);
        startActivity(intent);

    }


    private void img1() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Participant");

        // Setting Dialog Message
        alertDialog.setMessage(getString(R.string.parti_short));

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
        alertDialog.setMessage(getString(R.string.volun_short));

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
        alertDialog.setTitle("21 ON 21 Awards");

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

    private void img4() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Women World Record");

        // Setting Dialog Message
        alertDialog.setMessage(getString(R.string.women_short));

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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home: {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                Toast.makeText(ApplyActivity.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.nav_aboutus: {
                Intent in = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(in);
                Toast.makeText(ApplyActivity.this, "About", Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                Toast.makeText(this, "Not Working", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}

