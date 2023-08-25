package org.example.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.example.conexao.Conexao;
import org.example.model.Tarefas;


/**
 *
 * @author Caique Rawos.
 */

public class TarefasDAO {

    Connection conn;

    public TarefasDAO() {
    }

    public void inserirTarefa(Tarefas tf) throws SQLException {
        this.conn = (new Conexao()).getConnection();
        String sql = "INSERT INTO tarefas (descricao, data_inicial, data_final) VALUES (" + tf.getDescricao() + "', '" + tf.getDataHoraInicio() + "', '" + tf.getDataHoraFim() + ")";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        this.conn.close();
    }

    public ArrayList<Tarefas> buscarTarefas() throws SQLException {
        ArrayList<Tarefas> lista = new ArrayList();
        this.conn = (new Conexao()).getConnection();
        String sql = "SELECT * FROM tarefas;";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            boolean concluido = false;

            int id = rs.getInt("id_tarefa");
            String descricao = rs.getString("descricao");
            long data_inicial = rs.getLong("data_inicial");
            long data_final = rs.getLong("data_final");
            int concluido_banco = rs.getInt("concluido");

            if(concluido_banco == 1){
                concluido = true;
            }

            Tarefas tf2 = new Tarefas(id, descricao, data_inicial, data_final, concluido);
            lista.add(tf2);
        }

        stmt.close();
        this.conn.close();
        return lista;
    }

    public void excluir(int id) throws SQLException {
        this.conn = (new Conexao()).getConnection();
        String sql = "DELETE FROM tarefas WHERE id_tarefa = " + id;
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        this.conn.close();
    }
}
