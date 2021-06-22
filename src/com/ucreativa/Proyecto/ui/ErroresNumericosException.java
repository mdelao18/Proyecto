package com.ucreativa.Proyecto.ui;

public class ErroresNumericosException extends Exception {
    public ErroresNumericosException(String periodo) {
        super("Favor revisar que el año sea numérico " + "\n" + "Año: " + periodo);
    }
}
