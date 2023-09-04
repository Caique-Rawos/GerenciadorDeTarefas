package org.example.model.DAO;

import org.example.conexao.Conexao;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author Caique Rawos.
 */

public class UsuarioDAO {
    Connection conn;

    public UsuarioDAO() {
    }

    public void inserirUsuario(Usuario u){
        try{
            this.conn = (new Conexao()).getConnection();
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO Usuario (login, senha, cadastro) VALUES (?, ?, ?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setLong(3, u.dataParaEpoch(LocalDateTime.now()));
            stmt.execute();
            stmt.close();
            this.conn.close();
        }catch (SQLException e){
            System.out.println("erro ao inserir Usuario: " + e.getMessage());
        }

    }

    public int buscarUsuario(Usuario u){
        int id = 0;

        try{
            this.conn = (new Conexao()).getConnection();
            PreparedStatement stmt = this.conn.prepareStatement("SELECT id_usuario FROM usuarios where login = ? and senha = ?;");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.stringParaMD5(u.getSenha().toString()));
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                id = rs.getInt("id_usuario");
            }
        }catch (SQLException e){
            System.out.println("erro ao buscar usuario: " + e.getMessage());
        }

        return id;
    }
}
