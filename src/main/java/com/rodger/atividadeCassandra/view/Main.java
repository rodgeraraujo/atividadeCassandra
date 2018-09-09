package com.rodger.atividadeCassandra.view;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.Session;
import com.rodger.atividadeCassandra.factory.CassandraConnection;
import com.rodger.atividadeCassandra.dao.impl.VendaDaoBD;
import com.rodger.atividadeCassandra.model.ItemVenda;
import com.rodger.atividadeCassandra.model.Produto;
import com.rodger.atividadeCassandra.model.Venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        VendaDaoBD dao = new VendaDaoBD();

        //PARTE 1 - salva os itens na "tabela" Venda
        Produto produto1 = new Produto(1, "Teclado", 30);
        Produto produto2 = new Produto(2, "Mouse", 20);
        Produto produto3 = new Produto(3, "Monitor", 20);

        ItemVenda item1 = new ItemVenda(produto1, 1);
        ItemVenda item2 = new ItemVenda(produto2, 2);
        ItemVenda item3 = new ItemVenda(produto3, 3);

        List<ItemVenda> itens = new ArrayList<>();
        List<ItemVenda> itens2 = new ArrayList<>();

        itens.add(item1);
        itens.add(item2);

        itens2.add(item1);
        itens2.add(item3);

        Venda venda = new Venda(1, itens, ""+LocalDateTime.now());
        Venda venda2 = new Venda(2, itens, ""+LocalDateTime.now());

//        dao.salvar_venda(venda);
//        dao.salvar_venda(venda2);

        //PARTE 2 - deletar item por codigo
//        dao.deletar_venda(1);

        //PARTE 3 - listar todos todos os pedidos
//        System.out.println(dao.listar_venda());

        //PARTE 3 - buscar item por codigo
        dao.buscar_venda(1);


    }

}
