package com.rodger.atividadeCassandra.dao.impl;

import com.rodger.atividadeCassandra.dao.PessoaDao;
import com.rodger.atividadeCassandra.model.Pessoa;

import java.util.List;


public class PessoaDaoBD implements PessoaDao {

    public List<Pessoa> listar() {
        return null;
    }

    public Pessoa buscarPorCpf(String cpf) {
        return null;
    }

    public boolean deletarPorCpf(String cpf) {
        return false;
    }

    public boolean atualizar(Pessoa p) {
        return false;
    }
}
