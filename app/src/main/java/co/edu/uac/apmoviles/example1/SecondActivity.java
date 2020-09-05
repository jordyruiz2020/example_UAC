package co.edu.uac.apmoviles.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;



import org.w3c.dom.Text;

import static android.icu.lang.UCharacter.toLowerCase;
import static android.icu.lang.UCharacter.toUpperCase;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText p1, p2;
    Button mayor, vocal, invertir, longitud,ocultar;
    CheckBox m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addListenerOnButtonClick();
        Intent i = getIntent();
        String user = i.getStringExtra("Usuario");
        texto = findViewById(R.id.texto);
        texto.setText(texto.getText().toString() + " " + user);
        p1 = findViewById(R.id.edtp1);
        p2 = findViewById(R.id.edtp2);
        mayor = findViewById(R.id.btnmayor);
        vocal = findViewById(R.id.btnvocales);
        invertir = findViewById(R.id.btninvertir);
        longitud = findViewById(R.id.btnlongitud);
        ocultar=findViewById(R.id.ocultar);
        m=(CheckBox)findViewById(R.id.maxiymini);


        longitud.setOnClickListener(this);
        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
                }
                else{
                    if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())>0){
                        Toast.makeText(getApplicationContext(),"P1 es mayor que P2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())<0){
                            Toast.makeText(getApplicationContext(),"P1 es menor que P2", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

        vocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
                }
                else {
                    String textOne = remover(p1.getText().toString());
                    String textTwo = remover(p2.getText().toString());
                    p1.setText(textOne);
                    p2.setText(textTwo);
                }
            }
        });

        

        ocultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vocal.getVisibility() == View.INVISIBLE){
                    vocal.setVisibility(View.VISIBLE);
                    longitud.setVisibility(View.VISIBLE);
                    invertir.setVisibility(View.VISIBLE);
                    mayor.setVisibility(View.VISIBLE);
                    m.setVisibility(View.VISIBLE);
                }else{
                    vocal.setVisibility(View.INVISIBLE);
                    longitud.setVisibility(View.INVISIBLE);
                    invertir.setVisibility(View.INVISIBLE);
                    mayor.setVisibility(View.INVISIBLE);
                    m.setVisibility(View.INVISIBLE);
                }
            }
        });


        invertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
                }
                else {
                    new StringBuilder();
                    String textOne = p1.getText().toString();
                    String textTwo = p2.getText().toString();
                    String offsetTextOne = "";
                    String offsetTextTwo = "";

                    for (int i = textOne.length() - 1; i >= 0; i--) {
                        offsetTextOne = offsetTextOne + String.valueOf(textOne.charAt(i));
                    }

                    for (int i = textTwo.length() - 1; i >= 0; i--) {
                        offsetTextTwo = offsetTextTwo + String.valueOf(textTwo.charAt(i));
                    }

                    p1.setText(offsetTextOne);
                    p2.setText(offsetTextTwo);
                }
            }
        });







    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlongitud: int l1 = p1.getText().toString().length();
                int l2 = p2.getText().toString().length();
                Toast.makeText(getApplicationContext(),"L1=" + l1 + " L2=" + l2, Toast.LENGTH_LONG).show();
                break;
            case R.id.btninvertir:
                break;

            case R.id.btnvocales:
                break;
        }
    }


    public String remover(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    public void addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        m = (CheckBox) findViewById(R.id.maxiymini);

        //Applying the Listener on the Button click
        m.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int totalamount = 0;
                StringBuilder result = new StringBuilder();
               


                if (m.isChecked()) {

                    String textOne = p1.getText().toString();
                    String textTwo = p2.getText().toString();

                    String a = toLowerCase(textOne);
                    String c = toLowerCase(textTwo);
                    String b = toUpperCase(textOne);
                    String d = toUpperCase(textTwo);
                    if (textOne == a && textTwo == c) {
                        result.append("\n Es Minuscula");

                    }
                    if (textOne == b && textTwo == d) {
                        result.append("\n Es Mayuscula");
                    }
                    if (textOne == a && textTwo == d) {
                        result.append("\n P1 es minuscula y P2 Es Mayuscula");
                    }
                    if (textOne == b && textTwo == c) {
                        result.append("\n P1 es Mayuscula y P2 Es Minuscula");
                    }


                }

                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });


    }
}
