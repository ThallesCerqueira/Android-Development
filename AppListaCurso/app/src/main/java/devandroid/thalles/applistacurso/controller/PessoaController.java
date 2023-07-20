package devandroid.thalles.applistacurso.controller;

import android.content.SharedPreferences;
import devandroid.thalles.applistacurso.model.Pessoa;
import devandroid.thalles.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences( NOME_PREFERENCES, 0 );
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa pessoa) {

        listaVip.putString( "primeiroNome", pessoa.getNome() );
        listaVip.putString( "sobrenome", pessoa.getSobrenome() );
        listaVip.putString( "cursoDesejado", pessoa.getCursoDesejado() );
        listaVip.putString( "telefoneContato", pessoa.getTelefoneContato() );
        listaVip.apply();

    }

    public Pessoa buscar( Pessoa pessoa ) {

        pessoa.setNome( preferences.getString( "primeiroNome", "" ) );
        pessoa.setSobrenome( preferences.getString( "sobrenome", "" ) );
        pessoa.setCursoDesejado( preferences.getString( "cursoDesejado", "" ) );
        pessoa.setTelefoneContato( preferences.getString( "telefoneContato", "" ) );

        return pessoa;

    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}
