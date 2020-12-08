/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.lang.Exception;
/**
 *
 * @author fabri
 */
public class Tutoría extends Curso{

    private String escuela;
    private String materia;
    private TModalidad modalidad;
    private String código;
    private Tutor tutor;
    private String aula;
    private String horario;
    private int cupo;
    private int matriculados=0;
    private Calendar desde;
    private Calendar hasta;
    private int sesiones=1;
    private int asistenciaTotal = 0;
    private int sesionesTotales;
    private boolean enCursoActualmente = false;
    private ArrayList<Estudiante> EstudiantesMatriculados;

    public Tutoría(Tutor tutor, String código, String escuela, String materia, TModalidad modalidad, String aula, String horario, int cupo, Calendar desde, Calendar hasta, int sesionesTotales) {
        this.tutor = tutor;
        this.código = código;
        this.escuela = escuela;
        this.materia = materia;
        this.modalidad = modalidad;
        this.aula = aula;
        this.horario = horario;
        this.cupo = cupo;
        this.desde = desde;
        this.hasta = hasta;
        this.sesionesTotales = sesionesTotales;
        EstudiantesMatriculados = new ArrayList<>();
    }

    public Tutor getTutor() {
        return tutor;
    }

    public String getCódigo() { return código; }

    public String getEscuela() {
        return escuela;
    }

    public String getMateria() {
        return materia;
    }

    public TModalidad getModalidad() {
        return modalidad;
    }

    public String getAula() {
        return aula;
    }

    public String getHorario() {
        return horario;
    }

    public int getCupo() {
        return cupo;
    }

    public int getMatriculados() {
        return matriculados;
    }

    public Calendar getDesde() {
        return desde;
    }

    public Calendar getHasta() {
        return hasta;
    }

    public int getSesiones() {
        return sesiones;
    }

    public int getAsistenciaTotal() {
        return asistenciaTotal;
    }

    public int getSesionesTotales() {
        return sesionesTotales;
    }
    
    public void registrarAsistencia(ArrayList<Estudiante> asistieron){
        asistenciaTotal+=asistieron.size();
    }
    
    public double getPorcentajeAsistencia(){
        return (double) asistenciaTotal/(sesionesTotales*cupo);
    }
    
    public int getAusencias(){
        return matriculados*sesiones - asistenciaTotal;
    }

    public boolean isEnCursoActualmente() {
        return enCursoActualmente;
    }
    
    public void setEnCursoActualmente(boolean enCursoActualmente) {
        this.enCursoActualmente = enCursoActualmente;
    }
    
    public void matricularEstudiante(Estudiante E) throws ClassFullException{
        if(matriculados==this.cupo)
            throw new ClassFullException();
        if (!EstudiantesMatriculados.contains(E))
            EstudiantesMatriculados.add(E);
        matriculados++;
    }

    public void desmatricularEstudiante(Estudiante E){
        EstudiantesMatriculados.remove(E);
    }
    
    
}
