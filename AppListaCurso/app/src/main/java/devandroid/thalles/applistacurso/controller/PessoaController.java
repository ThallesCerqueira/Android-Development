package devandroid.thalles.applistacurso.controller;

import android.util.Log;
import devandroid.thalles.applistacurso.model.Pessoa;

public class PessoaController {

    public void salvar(Pessoa pessoa) {
        Log.i( "MVC_Controller", "Salvo: " + pessoa.toString() );

    }
}
