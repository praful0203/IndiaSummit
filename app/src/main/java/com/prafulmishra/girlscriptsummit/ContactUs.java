package com.prafulmishra.girlscriptsummit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {
    Button btnSubmit;
    EditText name,mail,subject,message;
    String ctname,ctmail,ctsub,ctmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.prafulmishra.girlscriptsummit.R.layout.activity_contact_us);

        btnSubmit = (Button)findViewById(com.prafulmishra.girlscriptsummit.R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.contactName);
                mail = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.contactMail);
                subject = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.contactSub);
                message = (EditText)findViewById(com.prafulmishra.girlscriptsummit.R.id.contactMsg);


                ctname = name.getText().toString();
                ctmail = mail.getText().toString();
                ctsub = subject.getText().toString();
                ctmsg = message.getText().toString();

                boolean failFlag = false;

                if( ctname.length() == 0 )
                {
                    failFlag = true;
                    name.setError( "Field cannot be empty" );
                    name.requestFocus();
                }
                if( ctsub.trim().length() == 0 )
                {
                    failFlag = true;
                    subject.setError( "Field cannot be empty" );
                    subject.requestFocus();
                }
                if(!isValidEmail(ctmail))
                {
                        failFlag = true;
                        mail.setError( "Enter a valid mail ID" );
                        mail.requestFocus();

                }
                if( ctmsg.length() == 0 )
                {
                    failFlag = true;
                    message.setError( "Field cannot be empty" );
                    message.requestFocus();
                }

                // if all are fine
                if (!failFlag) {
                    Intent sendEmail = new Intent(Intent.ACTION_SEND);
                    sendEmail.setData(Uri.parse("mailto:"));
                     sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"girlscriptfoundation@gmail.com","anubha.girlscript@gmail.com"});
                    sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT,""+ctsub);
                    sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                            "Name:"+ctname+"\n"+"Email ID:"+ctmail+"\n"+"Subject: "+ctsub+"\n"+"Message:"+'\n'+ctmsg);
                    sendEmail.setType("message/rfc2822");
            /* Send it off to the Activity-Chooser */
                    startActivity(Intent.createChooser(sendEmail, "Send mail..."));
                    Intent chooser = Intent.createChooser(sendEmail,"Send Email");
                    Toast.makeText(ContactUs.this, com.prafulmishra.girlscriptsummit.R.string.select_gmail, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    // validating email id

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
