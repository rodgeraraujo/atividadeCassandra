package com.rodger.atividadeCassandra.dao.impl;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.rodger.atividadeCassandra.factory.CassandraConnection;
import com.rodger.atividadeCassandra.dao.VendaDao;
import com.rodger.atividadeCassandra.model.ItemVenda;
import com.rodger.atividadeCassandra.model.Produto;
import com.rodger.atividadeCassandra.model.Venda;

import java.util.ArrayList;
import java.util.List;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;


public class VendaDaoBD implements VendaDao {

    private Session session;

    public VendaDaoBD(){

    }

    //salvar vendas
    public boolean salvar_venda(Venda venda){
        session = CassandraConnection.getConnection();

        PreparedStatement stmt = session.prepare("INSERT INTO venda (codigo, itens, datahora) VALUES (?,?,?)");

        BoundStatement bound = stmt.bind(venda.getCodigo(), venda.getItens()+"" + "", venda.getDataHora());

        ResultSet rs = session.execute(bound);

        CassandraConnection.closeConnection();
        session.close();

        return rs.wasApplied();
    }

    public List<Venda> listar_venda(){
        session = CassandraConnection.getConnection();

        Statement stmt = QueryBuilder.select().all().from("venda");

        ResultSet rs = session.execute(stmt);

        List<Row> linhas = rs.all();

        for(Row r : linhas){
            System.out.printf("TABELA venda\nCodigo | DataHora                | Itens\n");
            System.out.printf(String.valueOf(r.getInt("codigo"))+"        " +
                    ""+r.getString("datahora")+"   "+r.getString("itens"));
        }


        CassandraConnection.closeConnection();
        session.close();

        return null;
    }

    public Venda buscar_venda(int codigo) {
        session = CassandraConnection.getConnection();

        Statement stmt = QueryBuilder.select().all().from("venda").where(eq("codigo",codigo));

        ResultSet rs = session.execute(stmt);

        if (rs.wasApplied()) {
            List<Row> linhas = rs.all();

            for (Row r : linhas) {
                System.out.printf("TABELA venda\nCodigo | DataHora                | Itens\n");
                System.out.printf(String.valueOf(r.getInt("codigo")) + "        " +
                        "" + r.getString("datahora") + "   " + r.getString("itens"));
            }
        }
        System.out.println("Venda não encontrada ou não existe.");

        CassandraConnection.closeConnection();
        session.close();

        return null;
    }

    public boolean deletar_venda(int codigo) {
        session = CassandraConnection.getConnection();

        Statement stmt = QueryBuilder.delete().from("venda").where(eq("codigo",codigo));
        session.execute(stmt);

        ResultSet rs = session.execute(stmt);

        CassandraConnection.closeConnection();
        session.close();

        return rs.wasApplied();
    }

    public boolean insereItem_venda(int codigo, ItemVenda item) {
        return false;
    }

    @Override
    public boolean salvar_produto(Produto produto) {
        session = CassandraConnection.getConnection();

        PreparedStatement stmt = session.prepare("INSERT INTO produto (codigo, descricao, preco) VALUES (?,?,?)");

        BoundStatement bound = stmt.bind(produto.getCodigo(),produto.getDescricao(),produto.getPreco());

        ResultSet rs = session.execute(bound);

        CassandraConnection.closeConnection();
        session.close();

        return rs.wasApplied();
    }
}
