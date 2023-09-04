package org.example.model;

/**
 *
 * @author Caique Rawos.
 */

public class Tarefas extends FuncoesGlobais{

    private int id;

    private long dataHoraInicio, dataHoraFim;

    private String descricao;

    private boolean concluido;

    public Tarefas(int id, String descricao, long dataHoraInicio, long dataHoraFim, boolean concluido) {
        this.id = id;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.concluido = concluido;
    }

    public Tarefas() {
    }

    public Tarefas(String descricao, long dataHoraInicio, long dataHoraFim) {
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
    }

    public Tarefas(String descricao, long dataHoraInicio, long dataHoraFim, boolean concluido) {
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.concluido = concluido;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getDataHoraInicio() {
        return dataHoraInicio;
    }
    public void setDataHoraInicio(long dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public long getDataHoraFim() {
        return dataHoraFim;
    }
    public void setDataHoraFim(long dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public boolean isConcluido() {
        return concluido;
    }
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

}
