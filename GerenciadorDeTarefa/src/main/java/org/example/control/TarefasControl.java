package org.example.control;

import org.example.model.DAO.TarefasDAO;
import org.example.model.Tarefas;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Caique Rawos.
 */

public class TarefasControl {

    private ArrayList<Tarefas> listaTf = new ArrayList();

    public TarefasControl() {
    }

    public void cadastrarTarefas(String descricao, long dataHoraInicio, long dataHoraFim) throws SQLException {
        Tarefas tf = new Tarefas(descricao, dataHoraInicio, dataHoraFim);
        TarefasDAO tfDao = new TarefasDAO();
        tfDao.inserirTarefa(tf);
    }

    public ArrayList<Tarefas> buscarTodasTarefas() throws SQLException {
        TarefasDAO tfDao = new TarefasDAO();
        return tfDao.buscarTarefas();
    }

    public void excluirTarefas(int id) throws SQLException {
        TarefasDAO tfDao = new TarefasDAO();
        tfDao.excluir(id);
    }
}
