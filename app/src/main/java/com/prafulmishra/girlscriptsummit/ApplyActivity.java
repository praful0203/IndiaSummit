package com.prafulmishra.girlscriptsummit;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static java.lang.Float.valueOf;

public class ApplyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button btnPrtpnt, btnOn21, btnWomen;
    ImageButton imgQ1, imgQ2, imgQ3;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.prafulmishra.girlscriptsummit.R.layout.activity_apply);
        Toolbar toolbar = (Toolbar) findViewById(com.prafulmishra.girlscriptsummit.R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null)
                {
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        };


        DrawerLayout drawer = (DrawerLayout) findViewById(com.prafulmishra.girlscriptsummit.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, com.prafulmishra.girlscriptsummit.R.string.navigation_drawer_open, com.prafulmishra.girlscriptsummit.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        btnPrtpnt = (Button) findViewById(com.prafulmishra.girlscriptsummit.R.id.btnPrtpnt);
        btnOn21 = (Button) findViewById(com.prafulmishra.girlscriptsummit.R.id.btnOn21);
        btnWomen = (Button) findViewById(com.prafulmishra.girlscriptsummit.R.id.btnWomen);
        imgQ1 = (ImageButton) findViewById(com.prafulmishra.girlscriptsummit.R.id.imgQ1);
        imgQ2 = (ImageButton) findViewById(com.prafulmishra.girlscriptsummit.R.id.imgQ3);
        imgQ3 = (ImageButton) findViewById(com.prafulmishra.girlscriptsummit.R.id.imgQ4);

        /*Typeface blockFonts = Typeface.createFromAsset(getAssets(),"fonts/roboto.ttf");
        TextView txtSampleTxt = (TextView) findViewById(R.id.txtAppname);
        txtSampleTxt.setTypeface(blockFonts);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/graveside.ttf");
        btnPrtpnt.setTypeface(typeface);
        btnOn21.setTypeface(typeface);
        btnWomen.setTypeface(typeface);*/

        NavigationView navigationView = (NavigationView) findViewById(com.prafulmishra.girlscriptsummit.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        btnPrtpnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prtpntReg();
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
    }

    Boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();

            System.exit(0);

            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click Back again to exit",
                Toast.LENGTH_SHORT).show();

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.apply, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.prafulmishra.girlscriptsummit.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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



    private void img1() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Participant");

        // Setting Dialog Message
        alertDialog.setMessage(getString(com.prafulmishra.girlscriptsummit.R.string.parti_short));

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


    private void img2() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("21 ON 21 Awards");

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

    private void img3() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ApplyActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Women World Record");

        // Setting Dialog Message
        alertDialog.setMessage(getString(com.prafulmishra.girlscriptsummit.R.string.women_short));

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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == com.prafulmishra.girlscriptsummit.R.id.nav_aboutus) {
            Intent i = new Intent(getApplicationContext(), AboutUs.class);
            startActivity(i);

        } else if (id == com.prafulmishra.girlscriptsummit.R.id.nav_contactus) {
            Intent i = new Intent(getApplicationContext(), ContactUs.class);
            startActivity(i);

        } else if (id == com.prafulmishra.girlscriptsummit.R.id.nav_ourteam) {
            Intent i = new Intent(getApplicationContext(), OurTeam.class);
            startActivity(i);

        } else if (id == com.prafulmishra.girlscriptsummit.R.id.nav_spread) {
           Intent i = new Intent(getApplicationContext(), SocialHandle.class);
           startActivity(i);

       } else if (id == com.prafulmishra.girlscriptsummit.R.id.nav_rate) {
           /*try {
               startActivity(new Intent(Intent.ACTION_VIEW,
                       Uri.parse("http://play.google.com/store/apps/details?id=com.tdx.evan.zwskin.minimalist")));
           }
           catch (ActivityNotFoundException e)
           {
              startActivity(new Intent(Intent.ACTION_VIEW,
                       Uri.parse("http://play.google.com/store/apps/details?id=com.tdx.evan.zwskin.minimalist")));
               Toast.makeText(this, "Dummy Link!", Toast.LENGTH_SHORT).show();
           }*/
           final String appPackageName = "com.tdx.evan.zwskin.minimalist"; // getPackageName() from Context or Activity object
           try {
               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
           } catch (android.content.ActivityNotFoundException anfe) {
               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
           }


       }
        else if (id == com.prafulmishra.girlscriptsummit.R.id.nav_logout) {
           mAuth.signOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.prafulmishra.girlscriptsummit.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
