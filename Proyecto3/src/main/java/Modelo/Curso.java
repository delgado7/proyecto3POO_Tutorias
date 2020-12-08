package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Curso {

    public abstract String getCódigo();

    public abstract String getEscuela();

    public abstract String getMateria();

    public abstract String getAula();

    public abstract String getHorario();

    public abstract int getCupo();

    public abstract int getMatriculados();

    public abstract Calendar getDesde();

    public abstract Calendar getHasta();

    public abstract int getSesiones();

    public abstract int getAsistenciaTotal();

    public abstract int getSesionesTotales();

    public abstract void registrarAsistencia(ArrayList<Estudiante> asistieron);

    public abstract double getPorcentajeAsistencia();

    public abstract int getAusencias();

    public abstract boolean isEnCursoActualmente();

    public abstract void setEnCursoActualmente(boolean enCursoActualmente);

    public abstract void matricularEstudiante(Estudiante E) throws ClassFullException;

    public abstract void desmatricularEstudiante(Estudiante E);
}
