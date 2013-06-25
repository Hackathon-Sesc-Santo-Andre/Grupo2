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

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AdmSenhaActivity extends Activity {
	
	AQuery a;
	private Spinner spn1;
	private List<String> tipoServico = new ArrayList<String>();
	private Map<String, Integer> modelTpFila = new HashMap<String, Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adm_senha);
		
		a = new AQuery(this);
		
		tipoServico.add("");
		
		getJsonTipoServico();
        
		spn1 = (Spinner) findViewById(R.id.spnAdmSenhaTipoServico);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipoServico);
		ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spn1.setAdapter(spinnerArrayAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adm_senha, menu);
		return true;
	}
	
	
	public void getJsonTipoServico(){
		String url = "http://api.androidhive.info/contacts/";
		a.ajax(url, JSONObject.class, this, "retornoJsonTipoServico");
		
	}
	public void retornoJsonTipoServico(String url, JSONObject json, AjaxStatus status) throws JSONException{
		if(json != null){
			JSONArray array = json.getJSONArray("contacts");
			for(int i=0; i < array.length(); i++){
				String name = array.getJSONObject(i)
						.getString("name");
				tipoServico.add(name);
				//modelTpFila.put(c.getString("name"), c.getInt(""));
		        modelTpFila.put(name, i);
			}
		}
	}

}
