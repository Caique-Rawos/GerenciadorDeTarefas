package org.example.control;

import org.example.model.DAO.UsuarioDAO;
import org.example.model.Usuario;

/**
 *
 * @author Caique Rawos.
 */

public class UsuarioControl {

    public void cadastrarUsuario(String login, String senha){
        Usuario u = new Usuario(login, senha);
        UsuarioDAO usDao = new UsuarioDAO();
        usDao.inserirUsuario(u);
    }

    public int buscarUsuario(Usuario u){
        UsuarioDAO usDao = new UsuarioDAO();
        return usDao.buscarUsuario(u);
    }
}
