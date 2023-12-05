package com.atosalves.model.exceptions;

public class AcessoNegadoException extends Exception{
    
    private Long idCorrida;

 
    public AcessoNegadoException(String msm) {
        super(msm);
    }
    public AcessoNegadoException(Long id, String msm) {
        super(msm);
        this.idCorrida = id;
    }

    public Long getIdCorrida() {
        return idCorrida;
    }
}
