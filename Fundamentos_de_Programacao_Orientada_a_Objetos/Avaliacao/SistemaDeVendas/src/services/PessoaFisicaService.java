package services;

import models.PessoaFisica;

import java.util.ArrayList;

public class PessoaFisicaService {

    private static ArrayList<PessoaFisica> dados;

    public PessoaFisicaService(){
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    public void create(PessoaFisica pessoaFisica){
        dados.add(pessoaFisica.clone());
    }

    public ArrayList<PessoaFisica> read(){
        return new ArrayList<>(dados);
    }

    public PessoaFisica read(String cpf){
        for (PessoaFisica pessoaFisica : dados){
            if (pessoaFisica.getCpf().equals(cpf)){
                return pessoaFisica;
            }
        }
        return null;
    }

    public boolean delete(String cpf){
        for (PessoaFisica pessoaFisica : new ArrayList<>(dados)){
            if (pessoaFisica.getCpf().equals(cpf)){
                dados.remove(pessoaFisica);
                return true;
            }
        }
        return false;
    }

    public boolean update(PessoaFisica pessoaFisica){
        for (PessoaFisica pJ : new ArrayList<>(dados)){
            if (pJ.equals(pessoaFisica)){
                delete(pessoaFisica.getCpf());
                create(pessoaFisica);
                return true;
            }
        }
        return false;
    }
    
}
