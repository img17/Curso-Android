package com.curso.app;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.view.View.OnClickListener;




/**
 * Created by IvanG on 02/01/14.
 */
public class Calculadora extends Activity implements OnClickListener{

    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;
    Button boton5;
    Button boton6;
    Button boton7;
    Button boton8;
    Button boton9;
    Button boton0;
    Button botonSuma;
    Button botonResta;
    Button botonIgual;
    Button botonBorra;
    Button botonMulti;
    Button botonDivide;
    TextView respuesta;
    boolean band=true,bandOper=true;
    String num, num2,val1="0",val2="0",oper;
    Integer total=0,valor1=0,valor2=0;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.boton0 = (Button)findViewById(R.id.button0);
        boton0.setOnClickListener(this);
        this.boton1 = (Button)findViewById(R.id.button1);
        boton1.setOnClickListener(this);
        this.boton2 = (Button)findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        this.boton3 = (Button)findViewById(R.id.button3);
        boton3.setOnClickListener(this);
        this.boton4 = (Button)findViewById(R.id.button4);
        boton4.setOnClickListener(this);
        this.boton5 = (Button)findViewById(R.id.button5);
        boton5.setOnClickListener(this);
        this.boton6 = (Button)findViewById(R.id.button6);
        boton6.setOnClickListener(this);
        this.boton7 = (Button)findViewById(R.id.button7);
        boton7.setOnClickListener(this);
        this.boton8 = (Button)findViewById(R.id.button8);
        boton8.setOnClickListener(this);
        this.boton9 = (Button)findViewById(R.id.button9);
        boton9.setOnClickListener(this);
        this.botonResta = (Button)findViewById(R.id.buttonResta);
        botonResta.setOnClickListener(this);
        this.botonSuma = (Button)findViewById(R.id.buttonSuma);
        botonSuma.setOnClickListener(this);
        this.botonMulti = (Button)findViewById(R.id.buttonMultiplicacion);
        botonMulti.setOnClickListener(this);
        this.botonIgual = (Button)findViewById(R.id.buttonIgual);
        botonIgual.setOnClickListener(this);
        this.botonBorra = (Button)findViewById(R.id.buttonBorrar);
        botonBorra.setOnClickListener(this);
        this.botonDivide = (Button)findViewById(R.id.buttonDivision);
        botonDivide.setOnClickListener(this);
        this.respuesta = (TextView) findViewById(R.id.textViewResult);

    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        String numero;

        if (b.getText()==boton0.getText()  ||b.getText()==boton1.getText()||b.getText()==boton2.getText()||b.getText()==boton3.getText()||b.getText()==boton4.getText()
                ||b.getText()==boton5.getText()||b.getText()==boton6.getText()||b.getText()==boton7.getText()||b.getText()==boton8.getText()||b.getText()==boton9.getText()){
            if (bandOper==false) {
                respuesta.setText("");
                bandOper=true;
            }
            numero = (String) b.getText();
            cargarnumero(numero);
        }

        if(b.getId()==findViewById(R.id.buttonBorrar).getId()) {
            respuesta.setText("0");
            band=true;
            val1 = "0";
            val2 = "0";
            total = 0;
            oper ="";
        }

        if(b.getId()==findViewById(R.id.buttonSuma).getId()) {
            val1 = respuesta.getText().toString();
            bandOper = false;
            oper = b.getText().toString();
        }

        if(b.getId()==findViewById(R.id.buttonResta).getId()) {
            val1 = respuesta.getText().toString();
            bandOper = false;
            oper = b.getText().toString();
        }

        if(b.getId()==findViewById(R.id.buttonMultiplicacion).getId()) {
            val1 = respuesta.getText().toString();
            bandOper = false;
            oper = b.getText().toString();
        }

        if(b.getId()==findViewById(R.id.buttonDivision).getId()) {
            val1 = respuesta.getText().toString();
            bandOper = false;
            oper = b.getText().toString();
        }

        if(b.getId()==findViewById(R.id.buttonIgual).getId()) {
            val2 = respuesta.getText().toString();
            valor1 = Integer.parseInt(val1);
            valor2 = Integer.parseInt(val2);
            if (oper.equals("+")) total = suma(valor1, valor2);
            if (oper.equals("-")) total = resta(valor1, valor2);
            if (oper.equals("x")) total = multiplicacion(valor1, valor2);
            if (oper.equals("/")) total = division(valor1, valor2);
            respuesta.setText(Integer.toString(total));
            val1 = respuesta.getText().toString();
            val2 = respuesta.getText().toString();
        }

    }

    public void cargarnumero(String numero1){
        if (band==false){
            num=respuesta.getText().toString();
            num2=num.concat(numero1);
            respuesta.setText(String.valueOf(num2));
        }
        if(band){
            respuesta.setText(String.valueOf(numero1));
            band=false;
        }
    }

    public int suma(int n1, int n2){
        int op;
        op = n1 + n2;
        return op;
    }

    public int resta (int n1, int n2){
        int op;
        op = n1 - n2;
        return op;
    }

    public int multiplicacion(int n1, int n2){
        int op;
        op = n1 * n2;
        return op;
    }

    public int division(int n1, int n2){
        int op;
        op = n1 / n2;
        return op;
    }

}



