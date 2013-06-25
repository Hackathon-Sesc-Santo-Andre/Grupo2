package br.org.esperemenos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import br.org.esperemenos.ws.WebService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SenhaActivity extends Activity {

	AQuery a;
	Spinner spn1;
	EditText txtSenha;
	Button bntAdm, bntEnviar;
	private List<String> tipoServico = new ArrayList<String>();
	private Map<String, Integer> modelTpFila = new HashMap<String, Integer>();
	
		
	@Override
	//@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_senha);
		
		a = new AQuery(this);
		
		
		getJsonTipoServico();
        
		spn1 = (Spinner) findViewById(R.id.spnTipoServico);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipoServico);
		ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spn1.setAdapter(spinnerArrayAdapter);
		spn1.setSelection(-1);
		
		//Método do Spinner para capturar o item selecionado
		/*spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
 
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
		});*/
			
	    txtSenha = (EditText) findViewById(R.id.txtSenha);
	   
				
		bntAdm = (Button)findViewById(R.id.bntAdm);
		bntAdm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(SenhaActivity.this, AdmActivity.class);
                startActivity(intent);
                finish();
			}
		});
		
		bntEnviar = (Button)findViewById(R.id.bntEnviar);
		bntEnviar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if( txtSenha.getText().toString().length() <= 0) {
				    txtSenha.setError("Campo Obrigatorio");
					txtSenha.requestFocus();
				}
				
			}
		});
		
		
	}
	
	public void getJsonTipoServico(){
		String url = "http://api.androidhive.info/contacts/";
		a.ajax(url, JSONObject.class, this, "retornoJsonTipoServico");
		
	}
	public void retornoJsonTipoServico(String url, JSONObject json, AjaxStatus status) throws JSONException{
		if(json != null){
			JSONArray array = json.getJSONArray("contacts");
			//Log.e("WebService", array.toString());
			for(int i=0; i < array.length(); i++){
				String name = array.getJSONObject(i)
						//.getJSONObject("contacts")
						.getString("name");
				tipoServico.add(name);
	//			        //modelTpFila.put(c.getString("name"), c.getInt(""));
		        modelTpFila.put(name, i);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_senha, menu);
		return true;
	}

}
