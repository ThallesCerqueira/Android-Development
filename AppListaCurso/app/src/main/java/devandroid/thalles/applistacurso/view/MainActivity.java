package devandroid.thalles.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.thalles.applistacurso.R;
import devandroid.thalles.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    String dadosPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setNome( "Thalles" );
        pessoa.setSobrenome( "Cerqueira" );
        pessoa.setCursoDesejado( "Android Development" );
        pessoa.setTelefoneContato( "73991556511" );

        dadosPessoa = "Nome: " + pessoa.getNome();
        dadosPessoa += ", Sobrenome: " + pessoa.getSobrenome();
        dadosPessoa += ", Curso desejado: " + pessoa.getCursoDesejado();
        dadosPessoa += ", Telefone: " + pessoa.getTelefoneContato();

    }
}