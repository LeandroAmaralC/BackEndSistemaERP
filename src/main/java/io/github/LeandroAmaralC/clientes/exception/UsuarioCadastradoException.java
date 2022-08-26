package io.github.LeandroAmaralC.clientes.exception;

public class UsuarioCadastradoException extends  RuntimeException{

    public UsuarioCadastradoException(String login){
        super("Usuário já cadastrado para o login " + login );
    }
}
