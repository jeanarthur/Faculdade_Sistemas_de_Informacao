package services;

import models.PessoaFisica;
import models.PessoaJuridica;

import java.util.ArrayList;

public class PessoaJuridicaService {

    private static ArrayList<PessoaJuridica> dados;

    public PessoaJuridicaService(){
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    public void create(PessoaJuridica pessoaJuridica){
        dados.add(pessoaJuridica.clone());
    }

    public ArrayList<PessoaJuridica> read(){
        return new ArrayList<>(dados);
    }

    public PessoaJuridica read(String cnpj){
        for (PessoaJuridica pessoaJuridica : dados){
            if (pessoaJuridica.getCnpj().equals(cnpj)){
                return pessoaJuridica;
            }
        }
        return null;
    }

    public boolean delete(String cnpj){
        for (PessoaJuridica pessoaJuridica : new ArrayList<>(dados)){
            if (pessoaJuridica.getCnpj().equals(cnpj)){
                dados.remove(pessoaJuridica);
                return true;
            }
        }
        return false;
    }

    public boolean update(PessoaJuridica pessoaJuridica){
        for (PessoaJuridica pJ : new ArrayList<>(dados)){
            if (pJ.equals(pessoaJuridica)){
                delete(pessoaJuridica.getCnpj());
                create(pessoaJuridica);
                return true;
            }
        }
        return false;
    }

}
