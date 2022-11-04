package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.sql.Struct;

import javax.xml.xpath.XPathExpression;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btZero, btUm, btDois, btTres, btQuatro, btCinco,
            btSeis, btSete, btOito, btNove, btPonto, btIgual, btSoma,
            btSubtracao, btMultiplicacao, btDivisao, btRaiz, btPotencia, btLimpar;
    private TextView txtExpressao, txtResultado;
    private ImageView btBackspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar();
        IniciarComponentes();

        btZero.setOnClickListener(this);
        btUm.setOnClickListener(this);
        btDois.setOnClickListener(this);
        btTres.setOnClickListener(this);
        btQuatro.setOnClickListener(this);
        btCinco.setOnClickListener(this);
        btSeis.setOnClickListener(this);
        btSete.setOnClickListener(this);
        btOito.setOnClickListener(this);
        btNove.setOnClickListener(this);
        btPonto.setOnClickListener(this);
        btSoma.setOnClickListener(this);
        btSubtracao.setOnClickListener(this);
        btMultiplicacao.setOnClickListener(this);
        btDivisao.setOnClickListener(this);
        btPotencia.setOnClickListener(this);
        btRaiz.setOnClickListener(this);

        btLimpar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtExpressao.setText("");
                        txtResultado.setText("");
                    }
                }
        );
        btBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if (!string.isEmpty()) {
                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtExpressao = string.substring(var0, var1);

                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        btIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;
                    if(resultado == (double) longResult){
                        txtResultado.setText((CharSequence)
                                String.valueOf(longResult) );
                    }else{
                        txtResultado.setText((CharSequence)String.valueOf(resultado));
                    }
                }catch (Exception e){
                }
            }
        });
    }

    private void IniciarComponentes() {
        btZero = findViewById(R.id.bt_zero);
        btUm = findViewById(R.id.bt_um);
        btDois = findViewById(R.id.bt_dois);
        btTres = findViewById(R.id.bt_tres);
        btQuatro = findViewById(R.id.bt_quatro);
        btCinco = findViewById(R.id.bt_cinco);
        btSeis = findViewById(R.id.bt_seis);
        btSete = findViewById(R.id.bt_sete);
        btOito = findViewById(R.id.bt_oito);
        btNove = findViewById(R.id.bt_nove);

        btPonto = findViewById(R.id.ponto);
        btIgual = findViewById(R.id.igual);
        btSoma = findViewById(R.id.soma);
        btSubtracao = findViewById(R.id.subtracao);
        btMultiplicacao = findViewById(R.id.multiplicacao);
        btDivisao = findViewById(R.id.divisao);
        btRaiz = findViewById(R.id.raiz);
        btPotencia = findViewById(R.id.potencia);
        btLimpar = findViewById(R.id.limpar);
    }

    public void newExpression(String string, boolean limpar_dados) {
        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }
        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_zero:
                newExpression("0", true);
                break;
            case R.id.bt_um:
                newExpression("1", true);
                break;
            case R.id.bt_dois:
                newExpression("2", true);
                break;
            case R.id.bt_tres:
                newExpression("3", true);
                break;
            case R.id.bt_quatro:
                newExpression("4", true);
                break;
            case R.id.bt_cinco:
                newExpression("5", true);
                break;
            case R.id.bt_seis:
                newExpression("6", true);
                break;
            case R.id.bt_sete:
                newExpression("7", true);
                break;
            case R.id.bt_oito:
                newExpression("8", true);
                break;
            case R.id.bt_nove:
                newExpression("9", true);
                break;
            case R.id.soma:
                newExpression("+", true);
                break;
            case R.id.subtracao:
                newExpression("-", true);
                break;
            case R.id.multiplicacao:
                newExpression("*", true);
                break;
            case R.id.divisao:
                newExpression("/", true);
                break;
            case R.id.ponto:
                newExpression(".", true);
                break;
            case R.id.potencia:
                newExpression("Math.pow(newExpression, newExpression)", true);
                break;
            case R.id.raiz:
                newExpression("math.sqrt(newExpression));", true);
                break;
        }
    }
}
