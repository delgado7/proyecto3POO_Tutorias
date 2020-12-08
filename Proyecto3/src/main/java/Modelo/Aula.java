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

    private void setDesde(Calendar Desde) {
        this.Desde = Desde;
    }

    public Calendar getHasta() {
        return Hasta;
    }

    private void setHasta(Calendar Hasta) {
        this.Hasta = Hasta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isReservada() {
        return (0<=Hasta.compareTo(Calendar.getInstance()) && Desde.compareTo(Calendar.getInstance())<=0) || (0<=Hasta.compareTo(Calendar.getInstance()) && Hasta.compareTo(Calendar.getInstance())<=0) || (0<=Desde.compareTo(Calendar.getInstance()) && Desde.compareTo(Calendar.getInstance())<=0);
    }

    public void habilitarAula(Calendar desde, Calendar hasta){
        setDesde(desde);
        setHasta(hasta);
    }

    
    
}
