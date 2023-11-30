package com.example.listasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;  // Importación necesaria para List
import java.util.List;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public EditText txtnumerosig;
    public Button button;
    public TextView txtLista;

    public List<Integer> numerosList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnumerosig = findViewById(R.id.txtnumerosig);
        button = findViewById(R.id.button);
        txtLista = findViewById(R.id.txtLista);

        numerosList = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero();
    }
});
    }

    public void agregarNumero() {
        String numeroIngresadoStr = txtnumerosig.getText().toString();

        if (!numeroIngresadoStr.isEmpty()) {
            int numeroIngresado = Integer.parseInt(numeroIngresadoStr);
            numerosList.add(numeroIngresado);

            actualizarLista();
        }
    }

    public void actualizarLista() {
        StringBuilder listaTexto = new StringBuilder();

        for (int numero : numerosList) {
            listaTexto.append(numero).append(", ");
        }

        // Elimina la coma y el espacio extra al final
        if (listaTexto.length() > 1) {
            listaTexto.deleteCharAt(listaTexto.length() - 1);
            listaTexto.deleteCharAt(listaTexto.length() - 1);
        }

        txtLista.setText(listaTexto.toString());
        txtnumerosig.setText(""); // Limpia el EditText después de agregar el número
    }
}
