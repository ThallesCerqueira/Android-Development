package devandroid.thalles.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import devandroid.thalles.applistacurso.R;
import devandroid.thalles.applistacurso.controller.PessoaController;
import devandroid.thalles.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaController pessoaController;
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editNumeroContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoaController = new PessoaController();
        preferences = getSharedPreferences( NOME_PREFERENCES, 0 );
        SharedPreferences.Editor listaVip = preferences.edit();

        editPrimeiroNome = findViewById( R.id.editPrimeiroNome );
        editSobrenome = findViewById( R.id.editSobrenome );
        editCursoDesejado = findViewById( R.id.editCursoDesejado );
        editNumeroContato = findViewById( R.id.editNumeroContato );

        btnLimpar = findViewById( R.id.btnLimpar );
        btnSalvar = findViewById( R.id.btnSalvar );
        btnFinalizar = findViewById( R.id.btnFinalizar );

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editCursoDesejado.setText("");
                editNumeroContato.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(editNumeroContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo: " + pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString( "primeiroNome", pessoa.getNome() );
                listaVip.putString( "sobrenome", pessoa.getSobrenome() );
                listaVip.putString( "cursoDesejado", pessoa.getCursoDesejado() );
                listaVip.putString( "telefoneContato", pessoa.getTelefoneContato() );
                listaVip.apply();

                pessoaController.salvar( pessoa );

            }

        });

    }

}