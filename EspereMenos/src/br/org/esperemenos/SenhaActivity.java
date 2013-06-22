package br.org.esperemenos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.org.esperemenos.ws.WebService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SenhaActivity extends Activity {

	private Spinner spn1;
	private List<String> tipoServico = new ArrayList<String>();
	private Map<String, Integer> modelTpFila = new HashMap<String, Integer>();

	
		
	@Override
	//@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_senha);
		
		tipoServico.add("");
		//tipoServico.add("Atendimento");
		//tipoServico.add("Restaurante");
		
		WebService webService = new WebService();
		JSONObject json = webService.getJSONFromUrl("http://api.androidhive.info/contacts/");
		if(json == null){
			Toast.makeText(SenhaActivity.this, 
					   "erro no json", 
					   Toast.LENGTH_LONG).show();
		}else{
			JSONArray tipo = null;
			
			try {
			    // Getting Array of Contacts
				tipo = json.getJSONArray("contacts");
			     
			    // looping through All Contacts
			    for(int i = 0; i < tipo.length(); i++){
			        JSONObject c = tipo.getJSONObject(i);
			         
			        // Storing each json item in variable
			        tipoServico.add(c.getString("name"));
			        //modelTpFila.put(c.getString("name"), c.getInt(""));
			        modelTpFila.put(c.getString("name"), i);
			         
			    }
			} catch (JSONException e) {
			    e.printStackTrace();
			}
	        
			spn1 = (Spinner) findViewById(R.id.spnTipoServico);
			ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipoServico);
			ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
			spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
			spn1.setAdapter(spinnerArrayAdapter);
			//Método do Spinner para capturar o item selecionado
			spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	 
				@Override
				public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
					//pega nome pela posição
					String servico = parent.getItemAtPosition(posicao).toString();
					//imprime um Toast na tela com o nome que foi selecionado
					Toast.makeText(SenhaActivity.this, 
								   "Serviço Selecionado: " + servico +", Id Serviço: "+ modelTpFila.get(servico), 
								   Toast.LENGTH_LONG).show();
				}
	 
				@Override
				public void onNothingSelected(AdapterView<?> parent) {
	 
				}
			});
		}
				
		Button bntAdm = (Button)findViewById(R.id.bntAdm);
		bntAdm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(SenhaActivity.this, AdmActivity.class);
                startActivity(intent);
                finish();
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_senha, menu);
		return true;
	}

}
