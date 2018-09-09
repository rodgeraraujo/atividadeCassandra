package com.rodger.atividadeCassandra.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int codigo;
    private List<ItemVenda> itens;
    private String dataHora;

    public Venda() {
        itens = new ArrayList<>();
        dataHora = "" + LocalDateTime.now();
    }

    public Venda(int codigo, List<ItemVenda> itens, String dataHora) {
        this.codigo = codigo;
        this.itens = itens;
        this.dataHora = dataHora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "codigo=" + codigo +
                ", itens=" + itens +
                ", dataHora=" + dataHora +
                '}';
    }

}
