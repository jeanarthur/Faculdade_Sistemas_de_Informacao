package models;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getCnpj(){
        return this.cnpj;
    }

    @Override
    public boolean equals(Object obj) {
        PessoaJuridica pessoaJuridica = (PessoaJuridica) obj;
        return this.cnpj.equals(pessoaJuridica.cnpj);
    }

    public PessoaJuridica clone(){
        return new PessoaJuridica(this.nome, this.cnpj);
    }

}
