package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonIgual;
    private Double resultado = 0.0;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;
    private Button numero0, numero1, numero2, numero3, numero4, numero5, numero6, numero7, numero8, numero9,
            virgula, soma, subtracao, multiplicacao, divisao, porcentagem, igual, botao_limpar, botao_apagar;

    //    private TextView txtExpressao, txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        IniciarComponentes();
        numero0.setOnClickListener(this);
        numero1.setOnClickListener(this);
        numero2.setOnClickListener(this);
        numero3.setOnClickListener(this);
        numero4.setOnClickListener(this);
        numero5.setOnClickListener(this);
        numero6.setOnClickListener(this);
        numero7.setOnClickListener(this);
        numero8.setOnClickListener(this);
        numero9.setOnClickListener(this);
        virgula.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        porcentagem.setOnClickListener(this);

        igual = findViewById(R.id.buttonIgualID);
        igual.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (view.getId() == R.id.buttonIgualID) {
                     String expressao = textViewUltimaExpressao.getText().toString();
                     try {
                         Calculable calculadora = new ExpressionBuilder(expressao).build();

                         resultado = calculadora.calculate();
                         textViewResultado.setText(resultado.toString());
                     } catch (Exception e) {

                     }
                 }
             }
         });

        botao_apagar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textViewResultado.setText("");
                textViewUltimaExpressao.setText("");
            }
        });

        botao_limpar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.textViewUltimaExpressaoID);
                String string = expressao.getText().toString();

                if(!string.isEmpty()) {

                    byte varByte = 0;
                    int var1 = string.length()-1;

                   String textViewUltimaExpressao1 = string.substring(varByte, var1);
                   expressao.setText(textViewUltimaExpressao1);
                }
                textViewResultado.setText("");
            }
        });
    }
    // método para inicar componentes pelo ID

    private void IniciarComponentes() {
        numero0 = findViewById(R.id.buttonZeroID);
        numero1 = findViewById(R.id.buttonUmID);
        numero2 = findViewById(R.id.buttonDoisID);
        numero3 = findViewById(R.id.buttonTresID);
        numero4 = findViewById(R.id.buttonQuatroID);
        numero5 = findViewById(R.id.buttonCincoID);
        numero6 = findViewById(R.id.buttonSeisID);
        numero7 = findViewById(R.id.buttonSeteID);
        numero8 = findViewById(R.id.buttonOitoID);
        numero9 = findViewById(R.id.buttonNoveID);
        virgula = findViewById(R.id.buttonVirgulaID);
        soma = findViewById(R.id.buttonSomaID);
        subtracao = findViewById(R.id.buttonSubtracaoID);
        multiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        divisao = findViewById(R.id.buttonDivisaoID);
        porcentagem = findViewById(R.id.buttonPorcentoID);
        igual = findViewById(R.id.buttonIgualID);
        botao_limpar = findViewById(R.id.buttonResetID);
        botao_apagar = findViewById(R.id.buttonDeleteID);
        igual = findViewById(R.id.buttonIgualID);
    }

    public void AcrescentarExpressao(String string, boolean limpar_dados) {
        if(textViewResultado.getText().equals("")) {
            textViewUltimaExpressao.setText("");
        }

        if(limpar_dados) {
            textViewResultado.setText(" ");
            textViewUltimaExpressao.append(string);
        } else {
            textViewUltimaExpressao.append(textViewResultado.getText());
            textViewUltimaExpressao.append(string);
            textViewResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonZeroID:
                AcrescentarExpressao("0", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonUmID:
                AcrescentarExpressao("1", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonDoisID:
                AcrescentarExpressao("2", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonTresID:
                AcrescentarExpressao("3", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonQuatroID:
                AcrescentarExpressao("4", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonCincoID:
                AcrescentarExpressao("5", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonSeisID:
                AcrescentarExpressao("6", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonSeteID:
                AcrescentarExpressao("7", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonOitoID:
                AcrescentarExpressao("8", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonNoveID:
                AcrescentarExpressao("9", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonVirgulaID:
                AcrescentarExpressao(",", true);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonSomaID:
            AcrescentarExpressao("+", false);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonSubtracaoID:
            AcrescentarExpressao("-", false);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonMultiplicacaoID:
            AcrescentarExpressao("*", false);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonDivisaoID:
            AcrescentarExpressao("/", false);

                break;
        }

        switch (view.getId()) {
            case R.id.buttonPorcentoID:
                AcrescentarExpressao("%", true);

                break;
        }
    }
}