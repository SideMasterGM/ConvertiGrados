package com.community.sidemaster.convertigrados;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;


public class FarenToCelAndCelToFaren extends ActionBarActivity {

    private EditText TextBox_Cantidad;
    private TextView label_resultado;
    private RadioButton CelToFaren, FarenToCel;
    private Button Button_Convertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faren_to_cel_and_cel_to_faren);

        TextBox_Cantidad = (EditText) findViewById(R.id.TextBox_Cantidad);
        label_resultado = (TextView) findViewById(R.id.label_resultado);
        CelToFaren = (RadioButton) findViewById(R.id.CelToFaren);
        FarenToCel = (RadioButton) findViewById(R.id.FarenToCel);
        Button_Convertir = (Button) findViewById(R.id.Button_Convertir);
        Button_Convertir.setOnClickListener(OkListener);

    }

    private View.OnClickListener OkListener = new View.OnClickListener(){
        public void onClick(View view){
            operar();
        }
    };

    public void operar(){

        if(TextBox_Cantidad.getText().toString().length() == 0) {
            Toast.makeText(getBaseContext(), "Debe agregar un valor", Toast.LENGTH_LONG).show();
            return ;
        }

        String valor = TextBox_Cantidad.getText().toString();
        double cantidad = Double.parseDouble(valor);

        if (CelToFaren.isChecked() == true){
            double res_f = 1.8 * cantidad + 32;
            String resultado = cantidad + " grados Celcius son "  + String.valueOf(res_f) + " grados Farenheit";
            label_resultado.setText(resultado);
        } else if (FarenToCel.isChecked() == true) {
            double res_c = 0.5555 * cantidad - 32;
            String resultado = cantidad + " grados Farenheit son " + String.valueOf(res_c) + " grados Celcius";
            label_resultado.setText(resultado);
        }

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
}