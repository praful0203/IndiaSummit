package com.prafulmishra.indiasummit;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
    }

    private Intent openTwitter(Context context) {
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
