package com.example.projectproposal.errors;

public class ErrorSedeRestControllerException extends RuntimeException {

    private static final long serialVersionUID = 1L;// por si queremos convertir este objeto de forma remota o en bits

    public ErrorSedeRestControllerException(String message) {
        super("Usuario con ID:");
    }



   
    
}
