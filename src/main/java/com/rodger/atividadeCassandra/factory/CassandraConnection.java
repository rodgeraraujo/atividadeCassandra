package com.rodger.atividadeCassandra.factory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnection {
    static private Cluster cluster = null;
    static private Session session = null;

    public static Session getConnection() {
        Cassandra c = new Cassandra();

        cluster = Cluster.builder()
                .addContactPoint(c.getServerIP())
                .withPort(c.getPort())

                .build();
        Session session = cluster.connect(c.getKeyspace());

        try {

            String produtoTipo = "CREATE TYPE IF NOT EXISTS atividadeCassandra.produto(\n" +
                    "   codigo INT,\n" +
                    "   descricao TEXT,\n" +
                    "   preco FLOAT\n" +
                    ");";
            session.execute(produtoTipo);

            String itemVendaTipo = "CREATE TYPE IF NOT EXISTS atividadeCassandra.itemVenda(\n" +
                    "\tproduto produto,\n" +
                    "\tquantidade int\n" +
                    ");";
            session.execute(itemVendaTipo);

            String venda = "CREATE TABLE IF NOT EXISTS atividadeCassandra.venda(\n" +
                    "    codigo INT PRIMARY KEY,\n" +
                    "    itens text,\n" +
                    "    dataHora TEXT\n" +
                    ");\n";
            session.execute(venda);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Connected!");
        return session;
    }

    public static void closeConnection() {
        cluster.close();
    }
}
