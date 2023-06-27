package models;

public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    @Override
    public boolean equals(Object obj) {
        PessoaFisica pessoaFisica = (PessoaFisica) obj;
        return this.cpf.equals(pessoaFisica.cpf);
    }

    public PessoaFisica clone(){
        return new PessoaFisica(this.nome, this.cpf);
    }

}