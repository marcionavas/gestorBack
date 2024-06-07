package com.example.gestorAssistenciaTecnica.api.util.exceptions;

public class TelefoneException extends Exception {

    public TelefoneException(String msg) {
        super(msg);
    }

    public TelefoneException(String msg, String telefone) {
        super(msg + telefone);
    }

}
