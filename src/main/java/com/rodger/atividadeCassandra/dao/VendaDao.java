package com.rodger.atividadeCassandra.dao;

import com.rodger.atividadeCassandra.model.ItemVenda;
import com.rodger.atividadeCassandra.model.Produto;
import com.rodger.atividadeCassandra.model.Venda;

import java.util.List;

public interface VendaDao {

    public boolean salvar_venda(Venda venda);
    public List<Venda> listar_venda();
    public Venda buscar_venda(int codigo);
    public boolean deletar_venda(int codigo);
    public boolean insereItem_venda(int codigo, ItemVenda item);
    public boolean salvar_produto(Produto produto);
}
