package br.org.esperemenos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdmActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adm);
		
		Button bntEntrar = (Button) findViewById(R.id.bntEntrar);
		bntEntrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Validar com o webservice se usuario esta ativo 
				Intent intent = new Intent();
                intent.setClass(AdmActivity.this, AdmSenhaActivity.class);
                startActivity(intent);
                finish();
				
			}
		});
		
		Button bntCancelar = (Button) findViewById(R.id.bntCancelar);
		bntCancelar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(AdmActivity.this, SenhaActivity.class);
                startActivity(intent);
                finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_adm, menu);
		return true;
	}

}
