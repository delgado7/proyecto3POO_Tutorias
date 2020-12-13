/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;

/**
 *
 * @author fabri
 */
public class Aula {
    private Calendar Desde;
    private Calendar Hasta;
    private String id;
    private boolean reservada;

    public Aula(Calendar Desde, Calendar Hasta, String id, boolean reservada) {
        this.Desde = Desde;
        this.Hasta = Hasta;
        this.id = id;
        this.reservada = reservada;
    }



    public Calendar getDesde() {
        return Desde;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }
    
    public void setDesde(Calendar Desde) {
        this.Desde = Desde;
    }

    public Calendar getHasta() {
        return Hasta;
    }

    public void setHasta(Calendar Hasta) {
        this.Hasta = Hasta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isReservada() {
        return this.reservada;
    }

    public void habilitarAula(Calendar desde, Calendar hasta){
        setDesde(desde);
        setHasta(hasta);
    }

    
    
}
