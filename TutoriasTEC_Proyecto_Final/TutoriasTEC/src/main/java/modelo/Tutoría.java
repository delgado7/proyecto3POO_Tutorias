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
    private Calendar desde;
    private Calendar hasta;
    private int sesiones=0;
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

    public Tutoría(Tutor tutor, String código, String escuela, String materia, TModalidad modalidad, String aula, String horario, int cupo, Calendar desde, Calendar hasta, int sesionesTotales, int asistenciaTotal, boolean enCursoActualmente, ArrayList<Estudiante> EstudiantesMatriculados, int sesiones) {
        this.escuela = escuela;
        this.materia = materia;
        this.modalidad = modalidad;
        this.código = código;
        this.tutor = tutor;
        this.aula = aula;
        this.horario = horario;
        this.cupo = cupo;
        this.desde = desde;
        this.hasta = hasta;
        this.sesionesTotales = sesionesTotales;
        this.EstudiantesMatriculados = EstudiantesMatriculados;
        this.asistenciaTotal = asistenciaTotal;
        this.enCursoActualmente = enCursoActualmente;
        this.sesiones = sesiones;
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

    public ArrayList<Estudiante> getEstudiantesMatriculados() {
        return EstudiantesMatriculados;
    }

    public void setEstudiantesMatriculados(ArrayList<Estudiante> EstudiantesMatriculados) {
        this.EstudiantesMatriculados = EstudiantesMatriculados;
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
        return EstudiantesMatriculados.size();
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
    
    public void registrarAsistencia(int asistenciaDeHoy){
        asistenciaTotal+=asistenciaDeHoy;
    }
    
    public void registrarSesion(int nSesion){
        sesiones = nSesion;
    }
    
    public double getPorcentajeAsistencia(){
        return (double) asistenciaTotal/(sesionesTotales*cupo);
    }
    
    public int getAusencias(){
        return EstudiantesMatriculados.size()*sesiones - asistenciaTotal;
    }

    public boolean isEnCursoActualmente() {
        return enCursoActualmente;
    }
    
    public void setEnCursoActualmente(boolean enCursoActualmente) {
        this.enCursoActualmente = enCursoActualmente;
    }
    
    public void matricularEstudiante(Estudiante E) throws ClassFullException{
        if(EstudiantesMatriculados.size()==this.cupo)
            throw new ClassFullException();
        if (!EstudiantesMatriculados.contains(E))
            EstudiantesMatriculados.add(E);
    }

    public void desmatricularEstudiante(Estudiante E){
        EstudiantesMatriculados.remove(E);
    }
    public void PasarLista(String pCarné){
        for (int i = 0; i < EstudiantesMatriculados.size(); i++) {
            if(EstudiantesMatriculados.get(i).getCarné().equals("pCarné")){
                asistenciaTotal++;
                
        }
    }
    }

    @Override
    public String toString() {
        return "Tutor\u00eda{" + "escuela=" + escuela + ", materia=" + materia + ", modalidad=" + modalidad + ", c\u00f3digo=" + código + ", tutor=" + tutor + ", aula=" + aula + ", horario=" + horario + ", cupo=" + cupo + ", desde=" + desde + ", hasta=" + hasta + ", sesiones=" + sesiones + ", asistenciaTotal=" + asistenciaTotal + ", sesionesTotales=" + sesionesTotales + ", enCursoActualmente=" + enCursoActualmente + ", EstudiantesMatriculados=" + EstudiantesMatriculados + '}';
    }
    
    
    
    
}
