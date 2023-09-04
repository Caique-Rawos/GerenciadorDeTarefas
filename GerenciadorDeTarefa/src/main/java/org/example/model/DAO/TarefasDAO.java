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

    public void inserirTarefa(Tarefas tf){
        try{
            this.conn = (new Conexao()).getConnection();
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO tarefas (descricao, data_inicial, data_final) VALUES (?, ?, ?)");
            stmt.setString(1, tf.getDescricao());
            stmt.setLong(2, tf.getDataHoraInicio());
            stmt.setLong(3, tf.getDataHoraFim());
            stmt.execute();
            stmt.close();
            this.conn.close();
        }catch (SQLException e){
            System.out.println("erro ao inserir tarefa: " + e.getMessage());
        }

    }

    public ArrayList<Tarefas> buscarTarefas(){
        ArrayList<Tarefas> lista = new ArrayList();

        try{
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
        }catch (SQLException e){
            System.out.println("erro ao buscar tarefas: " + e.getMessage());
        }

        return lista;
    }

    public void excluir(int id){
        try{
            this.conn = (new Conexao()).getConnection();
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM tarefas WHERE id_tarefa = ?;");
            stmt.setInt(1,id);
            stmt.execute();
            stmt.close();
            this.conn.close();
        }catch(SQLException e ){
            System.out.println("erro ao excluir tarefa: " + e.getMessage());
        }


    }
}
