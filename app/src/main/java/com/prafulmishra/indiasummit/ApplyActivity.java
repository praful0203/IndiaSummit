package com.prafulmishra.indiasummit;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.icu.text.StringPrepParseException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.morsebyte.shailesh.twostagerating.TwoStageRate;

import static java.lang.Float.valueOf;

public class ApplyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button btnPrtpnt, btnVolunteer, btnOn21, btnWomen;
    ImageButton imgQ1, imgQ2, imgQ3, imgQ4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        btnPrtpnt = (Button) findViewById(R.id.btnPrtpnt);
        btnVolunteer = (Button) findViewById(R.id.btnVolunteer);
        btnOn21 = (Button) findViewById(R.id.btnOn21);
        btnWomen = (Button) findViewById(R.id.btnWomen);
        imgQ1 = (ImageButton) findViewById(R.id.imgQ1);
        imgQ2 = (ImageButton) findViewById(R.id.imgQ2);
        imgQ3 = (ImageButton) findViewById(R.id.imgQ3);
        imgQ4 = (ImageButton) findViewById(R.id.imgQ4);

        Typeface blockFonts = Typeface.createFromAsset(getAssets(),"fonts/gs_font.ttf");
        TextView txtSampleTxt = (TextView) findViewById(R.id.txtAppname);
        txtSampleTxt.setTypeface(blockFonts);

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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.apply, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_aboutus) {
            Intent i = new Intent(getApplicationContext(), AboutUs.class);
            startActivity(i);

        } else if (id == R.id.nav_contactus) {
            Intent i = new Intent(getApplicationContext(), ContactUs.class);
            startActivity(i);
            Toast.makeText(ApplyActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ourteam) {
            Intent i = new Intent(getApplicationContext(), OurTeam.class);
            startActivity(i);
            Toast.makeText(ApplyActivity.this, "Our Team", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_rate) {
           try {
               startActivity(new Intent(Intent.ACTION_VIEW,
                       Uri.parse("market://details?id=santase.radefffactory")));
           }
           catch (ActivityNotFoundException e)
           {
               startActivity(new Intent(Intent.ACTION_VIEW,
                       Uri.parse("https://play.google.com/store/app/details?id=santase.radefffactory")));
           }

        } else if (id == R.id.nav_register) {
            Intent i = new Intent(getApplicationContext(), ApplyActivity.class);
            startActivity(i);
            Toast.makeText(ApplyActivity.this, "Register", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
