package com.prafulmishra.indiasummit;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import static java.security.AccessController.getContext;

public class SocialHandle extends AppCompatActivity {
ImageButton imgFb,imgInsta,imgLinkedin,imgTwitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_handle);

        imgFb = (ImageButton)findViewById(R.id.imgFb);
        imgInsta = (ImageButton)findViewById(R.id.imgInsta);
        imgLinkedin = (ImageButton)findViewById(R.id.imgLinkedin);
        imgTwitter = (ImageButton)findViewById(R.id.imgTwitter);

        imgFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = openFacebook(SocialHandle.this);
                startActivity(facebookIntent);
            }
        });

        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twitterINtent = openTwitter(SocialHandle.this);
                startActivity(twitterINtent);
            }
        });

        imgInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instaIntent = openInsta(SocialHandle.this);
                startActivity(instaIntent);
            }
        });

        imgLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedIntent = openLinkedin(SocialHandle.this);
                startActivity(linkedIntent);
            }
        });
    }

    private Intent openLinkedin(Context context) {

        return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/13425352/"));
    }

    private Intent openInsta(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/_u/girlscript/"));
        } catch (Exception e){

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/girlscript/"));
        }
    }

    private Intent openTwitter(Context context) {
        try {
            // Get Twitter app
            context.getPackageManager()
                    .getPackageInfo("com.twitter.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?user_id=789085213766877185"));
        }
        // If no Twitter app found, open on browser

        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Girlscript1"));
        }
    }

    public static Intent openFacebook(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/1794087500862032"));
        } catch (Exception e){

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/Girlscript/"));
        }





    }
}
