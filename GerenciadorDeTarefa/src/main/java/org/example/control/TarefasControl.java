package org.example.control;

import org.example.model.DAO.TarefasDAO;
import org.example.model.Tarefas;

import java.util.ArrayList;

/**
 *
 * @author Caique Rawos.
 */

public class TarefasControl {

    public TarefasControl() {
    }

    public void cadastrarTarefas(String descricao, long dataHoraInicio, long dataHoraFim){
        Tarefas tf = new Tarefas(descricao, dataHoraInicio, dataHoraFim);
        TarefasDAO tfDao = new TarefasDAO();
        tfDao.inserirTarefa(tf);
    }

    public ArrayList<Tarefas> buscarTodasTarefas(){
        TarefasDAO tfDao = new TarefasDAO();
        return tfDao.buscarTarefas();
    }

    public void excluirTarefas(int id){
        TarefasDAO tfDao = new TarefasDAO();
        tfDao.excluir(id);
    }
}
