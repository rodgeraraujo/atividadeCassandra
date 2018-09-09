package com.rodger.atividadeCassandra.dao;

import com.rodger.atividadeCassandra.model.Pessoa;

import java.util.List;

public interface PessoaDao {

    public List<Pessoa> listar();
    public Pessoa buscarPorCpf(String cpf);
    public boolean deletarPorCpf(String cpf);
    public boolean atualizar(Pessoa p);

}
