package doublev.partners.tickets.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    FALSE("Inactivo"), TRUE("Activo");

    private String estado;

    Status(String estado){
        this.estado = estado;
    }

    @JsonValue
    public String getEstado(){
        return estado;
    }
}
