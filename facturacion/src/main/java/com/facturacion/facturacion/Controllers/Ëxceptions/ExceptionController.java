package com.facturacion.facturacion.Controllers.Ëxceptions;


public class ExceptionController {

    private String code;
    private String messageError;

    public ExceptionController(){

    }
    

    public ExceptionController(String code, String messageError) {
        this.code = code;
        this.messageError = messageError;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessageError() {
        return messageError;
    }
    public void setMessageError(String messageError) {
        this.messageError = messageError;   
    }

    
    
}
