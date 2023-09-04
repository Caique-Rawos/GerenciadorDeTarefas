package org.example.model;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Caique Rawos.
 */

public class Usuario extends FuncoesGlobais{
    private int id;

    private String login, senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id) {
        this.id = id;
    }

    /**
     *  Conversor de String para MD5, para validacao de senhas
     * @param senha senha do usuario
     * @return (String) ja convertida para MD5
     */
    public String stringParaMD5(String senha){
        try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(),0,senha.length());
            return new BigInteger(1,m.digest()).toString(16);
        }catch(Exception e){
            return "";
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
