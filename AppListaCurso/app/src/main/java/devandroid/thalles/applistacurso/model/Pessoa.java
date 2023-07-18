package devandroid.thalles.applistacurso.model;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String cursoDesejado;
    private String telefoneContato;

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome = '" + nome + '\'' +
                ", Sobrenome = '" + sobrenome + '\'' +
                ", Curso Desejado = '" + cursoDesejado + '\'' +
                ", Contato = '" + telefoneContato + '\'' +
                '}';
    }
}
