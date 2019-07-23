package pablo.barrientos.utng.edu.mx.androidjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Defining views
    private EditText txtNombre;
    private EditText txtPuesto;
    private EditText txtSalario;

    private Button btnAgregar;
    private Button btnVisualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing views
        txtNombre = (EditText) findViewById(R.id.txt_nombre);
        txtPuesto = (EditText) findViewById(R.id.txt_puesto);
        txtSalario = (EditText) findViewById(R.id.txt_salario);

        btnAgregar = (Button) findViewById(R.id.btn_agregar);
        btnVisualizar = (Button) findViewById(R.id.btn_visualizar);

        //Setting listeners to button
        btnAgregar.setOnClickListener(this);
        btnVisualizar.setOnClickListener(this);
    }


    //Adding an employee
    private void addEmployee(){

        final String nombre = txtNombre.getText().toString().trim();
        final String puesto = txtPuesto.getText().toString().trim();
        final String salario = txtSalario.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,nombre);
                params.put(Config.KEY_EMP_DESG,puesto);
                params.put(Config.KEY_EMP_SAL,salario);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btnAgregar){
            addEmployee();
        }

        if(v == btnVisualizar){
            startActivity(new Intent(this,ViewAllEmployee.class));
        }
    }
}