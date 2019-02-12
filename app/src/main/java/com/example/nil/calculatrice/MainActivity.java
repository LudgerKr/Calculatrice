package com.example.nil.calculatrice;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity
{
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMoins;
    Button buttonDiv;
    Button buttonMul;
    Button buttonAC;
    Button buttonEgal;
    Button buttonPoint;
    Button buttonNegatif;
    Button buttonpourcentage;
    TextView ecran;

    private double chiffre1 = NaN;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button0 = (Button) findViewById(R.id.id_0);
        this.button1 = (Button) findViewById(R.id.id_1);
        this.button2 = (Button) findViewById(R.id.id_2);
        this.button3 = (Button) findViewById(R.id.id_3);
        this.button4 = (Button) findViewById(R.id.id_4);
        this.button5 = (Button) findViewById(R.id.id_5);
        this.button6 = (Button) findViewById(R.id.id_6);
        this.button7 = (Button) findViewById(R.id.id_7);
        this.button8 = (Button) findViewById(R.id.id_8);
        this.button9 = (Button) findViewById(R.id.id_9);
        this.buttonPoint = (Button) findViewById(R.id.id_virgule);
        this.buttonPlus = (Button) findViewById(R.id.id_plus);
        this.buttonMoins = (Button) findViewById(R.id.id_moins);
        this.buttonDiv = (Button) findViewById(R.id.id_division);
        this.buttonMul = (Button) findViewById(R.id.id_multiplier);
        this.buttonAC = (Button) findViewById(R.id.id_ac);
        this.buttonEgal = (Button) findViewById(R.id.id_egale);
        this.buttonNegatif = (Button) findViewById(R.id.id_negatif);
        this.buttonpourcentage = (Button) findViewById(R.id.id_pourcentage);
        this.ecran = (TextView) findViewById(R.id.idtext);

        this.buttonPlus.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        plusClick();
    }
});
        this.buttonMoins.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        moinsClick();
    }
});
        this.buttonDiv.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        divClick();
    }
});
        this.buttonMul.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        mulClick();
    }
});
        this.buttonAC.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        resetClick();
    }
});
        this.buttonEgal.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        egalClick();
    }
});
        this.buttonPoint.setOnClickListener(new View.OnClickListener() {public void onClick(View v){chiffreClick(".");}});
        this.buttonNegatif.setOnClickListener(new View.OnClickListener() {public void onClick(View v){chiffreClick("-");}});
        this.buttonpourcentage.setOnClickListener(new View.OnClickListener() {public void onClick(View v){chiffreClick("%");}});
        this.button0.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {chiffreClick("0");}});
        this.button1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("1");
    }
});
        this.button2.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("2");
    }
});
        this.button3.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("3");
    }
});
        this.button4.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("4");
    }
});
        this.button5.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("5");
    }
});
        this.button6.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("6");
    }
});
        this.button7.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("7");
    }
});
        this.button8.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("8");
    }
});
        this.button9.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        chiffreClick("9");
    }
});
}


    private boolean thereAreVirgule()   {
        String number = ecran.getText().toString();
        for (int i=0;i<number.length();i++)  {
            if (number.charAt(i) == '.')  {
                return true;
            }
        }
        return false;
    }

    public void chiffreClick(String str)
    {
        if (!str.equals(".") | (str.equals(".") & !thereAreVirgule())) {
            if (str.equals("."))  {
                if (ecran.getText().toString().length() > 0) {
                    if (ecran.getText().toString().charAt(ecran.getText().toString().length() - 1) == '.') {
                        return;
                    } else if (Double.isNaN(this.chiffre1) & ecran.getText().equals("0"))  {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (update) {
                update = false;
            } else {
                if (!ecran.getText().equals("0"))
                    str = ecran.getText() + str;

            }
            ecran.setText(str);
        }
    }
    public void plusClick()
    {
        if(clicOperateur)
        {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            try {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            } catch(NumberFormatException e) {
                this.msg("Erreur : ","Rentrez un chiffre avant de mettre un operateur");
            }
        }
        operateur = "+";
        update = true;
    }
    public void moinsClick()
    {
        if(clicOperateur)
        {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            try {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            } catch(NumberFormatException e) {
                this.msg("Erreur : ","Rentrez un chiffre avant de mettre un operateur");
            }
        }
        operateur = "-";
        update = true;
    }
    public void mulClick()
    {
        if(clicOperateur)
        {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            try {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            } catch(NumberFormatException e) {
                this.msg("Erreur : ","Rentrez un chiffre avant de mettre un operateur");
            }
        }
        operateur = "*";
        update = true;
    }
    public void divClick()
    {
        if(clicOperateur)
        {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            try {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            } catch(NumberFormatException e) {
                this.msg("Erreur : ","Rentrez un chiffre avant de mettre un operateur");
            }
        }
        operateur = "/";
        update = true;
    }
    public void egalClick()
    {
        calcul();
        update = true;
        clicOperateur = false;
    }
    public void resetClick()
    {
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        ecran.setText("");
    }
    private void calcul()
    {
        if(operateur.equals("+"))
        {
            chiffre1 = chiffre1 + Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("-"))
        {
            chiffre1 = chiffre1 - Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("*"))
        {
            chiffre1 = chiffre1 * Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("/"))
        {
            try{
                chiffre1 = chiffre1 / Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                ecran.setText("0");
            }
        }
    }
    private void msg(String title, String msg)  {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle(title);
        builder1.setMessage(msg);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}