package br.com.gabrieldelfino.appcalculadora;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvResultado = findViewById(R.id.tvResultado);
        EditText etNum1 = findViewById(R.id.etNum);
        EditText etNum2 = findViewById(R.id.etNum2);
        EditText etOp = findViewById(R.id.etOp);

        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(click -> realizarCalculo(etNum1, etOp, etNum2, tvResultado));
    }

    private void realizarCalculo(EditText etNum1, EditText etOp, EditText etNum2, TextView tvResultado) {
        if(String.valueOf(etNum1.getText()).equals("") || String.valueOf(etNum2.getText()).equals("") || String.valueOf(etOp.getText()).equals("") ) {
            Toast.makeText(this, getString(R.string.camposVazios), Toast.LENGTH_SHORT).show();
        }else {
            int resultado = 0;
            int num1 = Integer.parseInt(etNum1.getText().toString());
            int num2 = Integer.parseInt(etNum2.getText().toString());

            switch (etOp.toString()) {
                case "+" :
                    resultado = num1 + num2;
                    break;
                case "-" :
                    resultado = num1 - num2;
                    break;
                case "*" :
                    resultado = num1 * num2;
                    break;
                case "/" :
                    resultado = num1 / num2;
                    break;
                default:
                    Toast.makeText(this, getString(R.string.erroOperacao), Toast.LENGTH_SHORT).show();
                    break;
            }
            
            tvResultado.setText(String.valueOf(resultado));
        }
    }

}