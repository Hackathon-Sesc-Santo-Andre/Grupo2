package br.org.esperemenos;

import java.util.Timer;
import java.util.TimerTask;

import com.androidquery.AQuery;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends RoboActivity {
	
	AQuery a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		a = new AQuery(this);
		a.id(R.id.logo).animate(R.anim.caindo);
		
		new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, SenhaActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3500);
	}
	
}
