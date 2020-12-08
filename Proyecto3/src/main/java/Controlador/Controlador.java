package Controlador;

import Modelo.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Controlador {
    ArrayList<Estudiante> estudiantes = new ArrayList<>();
    ArrayList<Tutor> tutores = new ArrayList<>();
    ArrayList<String> escuelas = new ArrayList<>();
    ArrayList<String> materias = new ArrayList<String>();
    ArrayList<Tutoría> tutorías = new ArrayList<>();
    ArrayList<Aula> aulas = new ArrayList<>();

    public Controlador() {}

    public void registrarEstudianteEnBase(int carné, String correoEstudinatil, String contraseña, String nombre, String profesión){
        estudiantes.add(new Estudiante(carné, correoEstudinatil, contraseña, nombre, profesión));
    }

    public void registrarTutorEnBase(TModalidad modalidad, String materiaTutoría, String correoEstudinatil, String contraseña, String nombre){
        tutores.add(new Tutor(modalidad, materiaTutoría, correoEstudinatil, contraseña, nombre));
    }

    public void registrarTutoríaEnBase(Tutor tutor, String código, String escuela, String materia, TModalidad modalidad, String aula, String horario, int cupo, Calendar desde, Calendar hasta, int sesionesTotales){
        tutorías.add(new Tutoría(tutor, código, escuela, materia, modalidad, aula, horario, cupo, desde, hasta, sesionesTotales));
    }

    public Estudiante getEstudiante(int carné){
        for (Estudiante E: estudiantes){
            if(E.getCarné()==carné)
                return E;
        }return null;
    }
    public Tutor getTutor(int carné){
        for (Tutor T: tutores){
            if(T.getCarné()==carné)
                return T;
        }return null;
    }
    public Tutoría getTutoría(int código){
        for (Tutoría T: tutorías){
            if(T.getCódigo().equals(código))
                return T;
        }return null;
    }

    public Aula getAula(String id){
        for (Aula A: aulas){
            if(A.getId().equals(id))
                return A;
        }return null;
    }

    public void addToMaterias(String [] a){
        for(String s: a){
            materias.add(s);
        }
    }

    public void addToEscuelas(String [] a){
        for(String s: a){
            escuelas.add(s);
        }
    }

    public void addToEscuelas(Aula [] a){
        for(Aula s: a){
            aulas.add(s);
        }
    }

    public void habilitarAula(Aula A, Calendar Desde, Calendar Hasta){
        if (!A.isReservada())
            A.habilitarAula(Desde, Hasta);
    }


}
