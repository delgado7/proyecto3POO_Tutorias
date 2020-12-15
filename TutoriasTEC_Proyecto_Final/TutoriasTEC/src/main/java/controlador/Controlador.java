package Controlador;

import Modelo.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Controlador {
    ArrayList<Estudiante> estudiantes = new ArrayList<>();
    ArrayList<Tutor> tutores = new ArrayList<>();
    ArrayList<String> escuelas = new ArrayList<>();
    ArrayList<String> materias = new ArrayList<>();
    ArrayList<Tutoría> tutorías = new ArrayList<>();
    ArrayList<Aula> aulas = new ArrayList<>();
    public String [] aulasDefault = {"1", "2", "3", "4"};
    public String [] escuelasDefault = {"", "Computación", "Matemática"};
    public String [] materiasComputacionDefault = {"", "Fundamentos", "Intro Taller"};
    public String [] materiasMatematicasDefault = {"", "Discreta", "General"};
    public String [] materiasDefault = {"", "Fundamentos", "Intro Taller", "Discreta", "General"};
    public HashMap<String, String[]> escuelaMaterias = new HashMap<>();
    public HashMap<String, String[]> materiaTutorias = new HashMap<>();
    public static String correoUsuario;

    public Controlador() {}
    
    public void registrarDato(JSONObject dato, String nombreObjeto) {
        switch(nombreObjeto) {
            case "Estudiante":
                registrarEstudianteEnBase(dato.get("Carné").toString(), dato.get("CorreoEstudiantil").toString(), dato.get("Contraseña").toString(), dato.get("matriculadoEn").toString() , dato.get("Nombre").toString(), true);
                break; 
            case "Tutor":
                registrarTutorEnBase(TModalidad.valueOf((dato.get("Modalidad")).toString()),dato.get("MateriaTutoría").toString(),dato.get("CorreoEstudinatil").toString(), dato.get("Contraseña").toString(), dato.get("Nombre").toString(), true);
                        break;
                        
            case "Tutoría":

                ArrayList<Estudiante> listaEstudiantesMatriculados = new ArrayList<>();
                JSONArray Estudiantes = (JSONArray) dato.get("Lista estudiantes matriculados");
                for(int i = 0; i < Estudiantes.size(); i++) {
                    JSONObject estudianteJSON = (JSONObject) Estudiantes.get(i);
                    String identificador = (estudianteJSON.get("Carné")).toString();
                    registrarDato(estudianteJSON, "Estudiante");
                    listaEstudiantesMatriculados.add(obtenerEstudiante(identificador));
                }
                registrarTutoríaEnBase(obtenerTutor(buscarObjeto(dato, "Tutor", "CorreoEstudinatil")), dato.get("Código").toString(), dato.get("Escuela").toString(), dato.get("Materia").toString(), TModalidad.valueOf((dato.get("Modalidad")).toString()), dato.get("Aula").toString(), dato.get("Horario").toString(), Integer.parseInt(((dato.get("Cupo"))).toString()), Utilitaria.obtenerFecha((dato.get("Desde")).toString()),Utilitaria.obtenerFecha((dato.get("Hasta")).toString()), Integer.parseInt((dato.get("SesionesTotales")).toString()), Integer.parseInt((dato.get("Asistencia Total")).toString()), Boolean.parseBoolean((dato.get("En Curso")).toString()), listaEstudiantesMatriculados, Integer.parseInt((dato.get("Sesiones")).toString()), true);
                break;
            case "Aula":
                registrarAulaEnBase(Utilitaria.obtenerFecha((dato.get("Desde")).toString()), Utilitaria.obtenerFecha((dato.get("Hasta")).toString()), dato.get("Id").toString(), Boolean.parseBoolean((dato.get("Reservada")).toString()), true);
                break;
            default:
                break; 
        }

    }
    
    // public boolean registrarTutoríaEnBase(Tutor tutor, String código, String escuela, String materia, TModalidad modalidad, String aula, String horario, int cupo, Calendar desde, Calendar hasta, int sesionesTotales, boolean lectura){
    //tutor, código, escuela, materia, modalidad, aula, horario, cupo, desde, hasta, sesionesTotales, asistenciaTotal, enCursoActualmente, EstudiantesMatriculados
    
    public String buscarObjeto(JSONObject dato, String nombreObjeto, String id){
        JSONArray listaObjetos = (JSONArray) dato.get(nombreObjeto);
        JSONObject objetoJSON = (JSONObject) listaObjetos.get(0);
        registrarDato(objetoJSON, nombreObjeto);
        return (objetoJSON.get(id)).toString();
    }
    
    public boolean cargarInformacionJSON(String archivo, String nombreObjeto) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(archivo)) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaDatosJSON = (JSONArray) objetos;
            for(int i = 0; i < listaDatosJSON.size(); i++) {
                JSONObject objetoDato = (JSONObject) listaDatosJSON.get(i);
                JSONObject dato = (JSONObject) objetoDato.get(nombreObjeto);
                registrarDato(dato, nombreObjeto);
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    
    public boolean editarEstudianteJSON(String carné, HashMap edicion) {
        JSONParser jsonParser = new JSONParser();
        Estudiante EstudianteActual = obtenerEstudiante(carné);
        //Línea para comprobar la actualización de la lista de vehículos
        
        try (FileReader reader = new FileReader("Estudiante.json")) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaEstudiantesJSON = (JSONArray) objetos;
            for(int i = 0; i < listaEstudiantesJSON.size(); i++) {
                JSONObject EstudianteActualJSON = (JSONObject) listaEstudiantesJSON.get(i);
                JSONObject estudiante = (JSONObject) EstudianteActualJSON.get("Estudiante");
                for(int j = 0; j < edicion.keySet().size(); j++) {
                    if((estudiante.get("Carné")).toString().equals(carné)) {
                        estudiante.put(edicion.keySet().toArray()[j], 
                                edicion.get(edicion.keySet().toArray()[j]));
                    }
                    //Línea para comprobar la actualización de la lista de vehículos
                    setDatoEdicionEstudiante(EstudianteActual, (edicion.keySet().toArray()[j]).toString(), 
                                   (edicion.get(edicion.keySet().toArray()[j])).toString());
                    
                }
            }
        try (FileWriter archivo = new FileWriter("Estudiante.json")) {
                archivo.write(listaEstudiantesJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    public boolean editarAulaJSON(String Id, HashMap edicion) {
        JSONParser jsonParser = new JSONParser();
        //Línea para comprobar la actualización de la lista de vehículos
        Aula aulaActual = obtenerAula(Id);
        
        try (FileReader reader = new FileReader("Aula.json")) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaAulasJSON = (JSONArray) objetos;
            for(int i = 0; i < listaAulasJSON.size(); i++) {
                JSONObject AulaActualJSON = (JSONObject) listaAulasJSON.get(i);
                JSONObject aula = (JSONObject) AulaActualJSON.get("Aula");
                for(int j = 0; j < edicion.keySet().size(); j++) {
                    if((aula.get("Id")).toString().equals(Id)) {
                        aula.put(edicion.keySet().toArray()[j], 
                                edicion.get(edicion.keySet().toArray()[j]));
                    }
                    //Línea para comprobar la actualización de la lista de vehículos
                    setDatoEdicionAula(aulaActual, (edicion.keySet().toArray()[j]).toString(), 
                                   (edicion.get(edicion.keySet().toArray()[j])).toString());
                    
                }
            }
        try (FileWriter archivo = new FileWriter("Aula.json")) {
                archivo.write(listaAulasJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    public void setDatoEdicionAula(Aula aulaActual, String nombreDato, 
            String datoActualizado) {
        switch(nombreDato) {
            case "Desde":
                aulaActual.setDesde(Utilitaria.obtenerFecha(datoActualizado));
                break;
            case "Hasta":
                aulaActual.setDesde(Utilitaria.obtenerFecha(datoActualizado));
                break;
            case "Reservada":
                aulaActual.setReservada(Boolean.parseBoolean(datoActualizado));
                
                break;
            default:
                break;
        }
    }
    public boolean confirmarAsistenciaTutoría(String código, HashMap edicion) {
        JSONParser jsonParser = new JSONParser();
        Tutoría TutoríaActual = obtenerTutoría(código);
        
        //Línea para comprobar la actualización de la lista de vehículos
        
        try (FileReader reader = new FileReader("Tutoría.json")) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaTutoríasJson = (JSONArray) objetos;
            for(int i = 0; i < listaTutoríasJson.size(); i++) {
                JSONObject TutoríaActualJSON = (JSONObject) listaTutoríasJson.get(i);
                JSONObject tutoría = (JSONObject) TutoríaActualJSON.get("Tutoría");
                for(int j = 0; j < edicion.keySet().size(); j++) {
                    if((tutoría.get("Código")).toString().equals(código)) {
                        tutoría.put(edicion.keySet().toArray()[j], 
                                edicion.get(edicion.keySet().toArray()[j]));
                    }
                    setDatoEdicionTutoría(TutoríaActual, (edicion.keySet().toArray()[j]).toString(), 
                                   (edicion.get(edicion.keySet().toArray()[j])).toString());
                    
                }
            }
        try (FileWriter archivo = new FileWriter("Tutoría.json")) {
                archivo.write(listaTutoríasJson.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    public void setDatoEdicionEstudiante(Estudiante estudianteActual, String nombreDato, 
            String datoActualizado) {
        switch(nombreDato) {
            case "matriculadoEn":
                estudianteActual.setMatriculadoEn(datoActualizado);
                break;
            default:
                break;
        }
    }
    
    public void setDatoEdicionTutoría(Tutoría tutoríaActual, String nombreDato, 
            String datoActualizado) {
        switch(nombreDato) {
            case "Asistencia Total":
                tutoríaActual.registrarAsistencia(Integer.parseInt(datoActualizado));
                break;
            case "Sesiones":
                tutoríaActual.registrarSesion(Integer.parseInt(datoActualizado));
                break;
            default:
                break;
        }
    }
    
    public JSONArray prepararArrayObjetos(String nombreObjeto) {
        JSONObject objetoJSON = new JSONObject();
        JSONArray arrayObjeto = new JSONArray();
        objetoJSON = agregarDato(objetoJSON, nombreObjeto, false, 0);
        arrayObjeto.add(objetoJSON);
        return arrayObjeto;
    }
    
    public JSONObject agregarDato(JSONObject dato, String nombreObjeto, 
            boolean ultimo, int indice) {
        switch(nombreObjeto) {
            case "Estudiante":
                Estudiante ultimoEstudiante;
                ultimoEstudiante = estudiantes.get(estudiantes.size()-1);
                dato.put("Nombre",ultimoEstudiante.getNombre());
                dato.put("Carné", ultimoEstudiante.getCarné());
                dato.put("CorreoEstudiantil", ultimoEstudiante.getCorreoEstudiantil());
                dato.put("Contraseña", ultimoEstudiante.getContraseña());
                dato.put("matriculadoEn", ultimoEstudiante.getTutoríaMatriculada());
                dato.put("Profesión", ultimoEstudiante.getProfesión());
                break;
            case "Tutor":
                Tutor ultimoTutor;
                if(ultimo) {
                    ultimoTutor=tutores.get(tutores.size()-1);
                } else {
                    ultimoTutor=tutorías.get(tutorías.size()-1).getTutor();
                }
                dato.put("Modalidad",ultimoTutor.getModalidad().toString());
                dato.put("MateriaTutoría",ultimoTutor.getMateriaTutoría());
                dato.put("CorreoEstudinatil",ultimoTutor.getCorreoEstudiantil());
                dato.put("Contraseña",ultimoTutor.getContraseña());
                dato.put("Nombre", ultimoTutor.getNombre());
                break;
            case "Tutoría":
                JSONArray tutorJSON = prepararArrayObjetos("Tutor");
                Tutoría ultimaTutoría;
                ultimaTutoría=tutorías.get(tutorías.size()-1);
                ArrayList<Estudiante> listaEstudiantesMatriculados = 
                        ultimaTutoría.getEstudiantesMatriculados();
                JSONObject estudianteJSON = new JSONObject();
                JSONArray listaEstudiantesJSON = new JSONArray();
                
                for(int i = 0; i < listaEstudiantesJSON.size(); i++) {
                    estudianteJSON = agregarDato(estudianteJSON, "Estudiante", false, i);
                    listaEstudiantesJSON.add(estudianteJSON);
                }
                
                dato.put("Tutor",tutorJSON);
                dato.put("Código",ultimaTutoría.getCódigo());
                dato.put("Escuela",ultimaTutoría.getEscuela());
                dato.put("Materia",ultimaTutoría.getMateria());
                dato.put("Modalidad", ultimaTutoría.getModalidad().toString());
                dato.put("Aula", ultimaTutoría.getAula());
                dato.put("Horario", ultimaTutoría.getHorario());
                dato.put("Cupo", Integer.toString(ultimaTutoría.getCupo()));
                dato.put("Desde", Utilitaria.formatoFechaJSON(ultimaTutoría.getDesde()));
                dato.put("Hasta", Utilitaria.formatoFechaJSON(ultimaTutoría.getHasta()));
                dato.put("Sesiones", Integer.toString(ultimaTutoría.getSesiones()));
                dato.put("SesionesTotales", Integer.toString(ultimaTutoría.getSesionesTotales()));
                dato.put("Lista estudiantes matriculados", listaEstudiantesJSON);
                dato.put("Asistencia Total", Integer.toString(ultimaTutoría.getAsistenciaTotal()));
                dato.put("En Curso", String.valueOf(ultimaTutoría.isEnCursoActualmente()));
                break;
             case "Aula":
                Aula ultimaAula;
                ultimaAula=aulas.get(aulas.size()-1);
                dato.put("Desde",Utilitaria.formatoFechaJSON(ultimaAula.getDesde()));
                dato.put("Hasta",Utilitaria.formatoFechaJSON(ultimaAula.getHasta()));
                dato.put("Id",ultimaAula.getId());
                dato.put("Reservada",String.valueOf(ultimaAula.isReservada()));
                break;
            default:
                break;
        }
        return dato;
        
    }
    public boolean listaTieneDatos(String nombreObjeto) {
        switch(nombreObjeto) {
            case "Estudiante":
                return estudiantes.size() > 1;
            case "Tutor":
                return tutores.size()>1;
            case "Tutoría":
                return tutorías.size()>1;
            case "Aula":
                return aulas.size()>1;
        }
        return false;
    }
    public boolean agregarInformacionJSON(String nombreArchivo, 
            String nombreObjeto) {
        JSONParser jsonParser = new JSONParser();
        JSONArray listaDatosJSON;
        try (FileReader reader = new FileReader(nombreArchivo)) {
            if(listaTieneDatos(nombreObjeto)) {
                Object objetos = jsonParser.parse(reader);
                listaDatosJSON = (JSONArray) objetos;
            } else {
                listaDatosJSON = new JSONArray();
            }
            JSONObject datoActualJSON = new JSONObject();
            datoActualJSON = agregarDato(datoActualJSON, nombreObjeto, true, 0);
            JSONObject paquete = new JSONObject();
            paquete.put(nombreObjeto, datoActualJSON);
            listaDatosJSON.add(paquete);
            try (FileWriter archivo = new FileWriter(nombreArchivo)) {
                archivo.write(listaDatosJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    
    //agregarServicioAVehiculo
    /*
    public boolean agregarServicioAVehiculo(String placa, Servicio servicioActual){
        Vehiculo vehiculoActual = obtenerVehiculo(placa);
        boolean servicioAgregado = vehiculoActual.agregarServicio(servicioActual);
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("vehiculos.json")) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaVehiculosJSON = (JSONArray) objetos;
            for(int i = 0; i < listaVehiculosJSON.size(); i++) {
                JSONObject vehiculoActualJSON = (JSONObject) listaVehiculosJSON.get(i);
                JSONObject vehiculo = (JSONObject) vehiculoActualJSON.get("Vehiculo");
                if((vehiculo.get("Placa")).toString().equals(placa)) {
                    EmpresaMantenimiento empresaActual = servicioActual.getEmpresaRelacionada();
                    JSONObject objetoEmpresa = new JSONObject();
                    JSONArray empresasRelacionadas = new JSONArray();
                    
                    objetoEmpresa.put("Razon social", empresaActual.getRazonSocial());
                    objetoEmpresa.put("Cedula", empresaActual.getNumeroCedula());
                    objetoEmpresa.put("Telefono", empresaActual.getTelefono());
                    objetoEmpresa.put("Provincia", empresaActual.getProvincia());
                    objetoEmpresa.put("Canton", empresaActual.getCanton());
                    objetoEmpresa.put("Distrito", empresaActual.getDistrito());
                    objetoEmpresa.put("Señas", empresaActual.getSeñas());
                    
                    empresasRelacionadas.add(objetoEmpresa);
                    
                    JSONArray serviciosRelacionados;
                    serviciosRelacionados = (JSONArray)vehiculo.get("Lista servicios relacionados");
                    
                    if(servicioAgregado) {
                        JSONObject servicioNuevo = new JSONObject();
                        servicioNuevo.put("Identificador", 
                                Integer.toString(servicioActual.getIdentificador()));
                        servicioNuevo.put("Fecha inicio", 
                                Utilitaria.formatoFechaJSON(servicioActual.getFechaInicio()));
                        servicioNuevo.put("Fecha final", 
                                Utilitaria.formatoFechaJSON(servicioActual.getFechaFinalizacion()));
                        servicioNuevo.put("Monto pagado", 
                                Double.toString(servicioActual.getMontoPagado()));
                        servicioNuevo.put("Detalles", 
                                servicioActual.getDetalles());
                        servicioNuevo.put("Tipo", 
                                (servicioActual.getTipo()).toString());
                        servicioNuevo.put("Empresa relacionada", empresasRelacionadas);
                        serviciosRelacionados.add(servicioNuevo);
                    }
                }
            }
        try (FileWriter archivo = new FileWriter("vehiculos.json")) {
                archivo.write(listaVehiculosJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    */
    
    public boolean agregarEstudianteATutoría(String cod, Estudiante estudianteActual){
        try{
            Tutoría tutoríaActual = obtenerTutoría(cod);
            tutoríaActual.matricularEstudiante(estudianteActual);
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("Tutoría.json")) {
                Object objetos = jsonParser.parse(reader);
                JSONArray listaTutoríasJSON = (JSONArray) objetos;
                for(int i = 0; i < listaTutoríasJSON.size(); i++) {
                    JSONObject tutoríaActualJSON = (JSONObject) listaTutoríasJSON.get(i);
                    JSONObject tutoría = (JSONObject) tutoríaActualJSON.get("Tutoría");
                    if((tutoría.get("Código")).toString().equals(cod)) {
                        
                            JSONArray estudiantesRelacionados;
                            estudiantesRelacionados = (JSONArray)tutoría.get("Lista estudiantes matriculados");

                            JSONObject estudianteNuevo = new JSONObject();
                            estudianteNuevo.put("Nombre", estudianteActual.getNombre());
                            estudianteNuevo.put("Carné", estudianteActual.getCarné());
                            estudianteNuevo.put("CorreoEstudiantil", estudianteActual.getCorreoEstudiantil());
                            estudianteNuevo.put("Contraseña", estudianteActual.getContraseña());
                            estudianteNuevo.put("matriculadoEn", tutoría.get("Código").toString());
                            estudiantesRelacionados.add(estudianteNuevo);
                    }
                }
            try (FileWriter archivo = new FileWriter("Tutoría.json")) {
                    archivo.write(listaTutoríasJSON.toJSONString());
                    archivo.flush();
                } catch (IOException e) {
                    return false;
                }
            } catch (FileNotFoundException e) {
                return false;
            } catch (IOException | ParseException e) {
                return false;
            }
            return true;
            
        }catch (ClassFullException E){
            return false;
        }
    }
    public boolean registrarEstudianteEnBase(String carné, String correoEstudiantil, String contraseña, String matriculadoEn, String nombre, boolean lectura){
        if(obtenerEstudiante(carné) == null && obtenerEstudianteCorreo(correoEstudiantil) == null && verificarCorreo(correoEstudiantil)) {
            Estudiante nuevoEstudiante = new Estudiante( carné,  correoEstudiantil,  contraseña,  matriculadoEn,  nombre,  "Estudiante");
            estudiantes.add(nuevoEstudiante);
            
            if(!lectura) {
                agregarInformacionJSON("Estudiante.json","Estudiante");
            }
            return true;
        }
        return false;
    }
    public boolean registrarAulaEnBase(Calendar Desde, Calendar Hasta, String id, boolean reservada, boolean lectura){
        if(obtenerAula(id) == null) {
            Aula nuevaAula = new Aula(Desde, Hasta, id, reservada);
            
            aulas.add(nuevaAula);
            
            if(!lectura) {
                agregarInformacionJSON("Aula.json","Aula");
            }
            return true;
        }
        return false;
    }
    public Estudiante obtenerEstudiante(String pId)
    {
        Estudiante elCliente;
        for(int i = 0; i < estudiantes.size(); i++)
        {
            elCliente = estudiantes.get(i);
            if(elCliente.getCarné().equals(pId))
            {
                return elCliente;
            }
        }
        return null;
    }
    public Estudiante obtenerEstudianteCorreo(String correo)
    {
        Estudiante elCliente;
        for(int i = 0; i < estudiantes.size(); i++)
        {
            elCliente = estudiantes.get(i);
            if(elCliente.getCorreoEstudiantil().equals(correo))
            {
                return elCliente;
            }
        }
        return null;
    }
    public Aula obtenerAula(String pId)
    {
        Aula elCliente;
        for(int i = 0; i < aulas.size(); i++)
        {
            elCliente = aulas.get(i);
            if(elCliente.getId().equals(pId))
            {
                return elCliente;
            }
        }
        return null;
    }
    public Tutor obtenerTutor(String pId)
    {
        Tutor elCliente;
        for(int i = 0; i < tutores.size(); i++)
        {
            elCliente = tutores.get(i);
            if(elCliente.getCorreoEstudiantil().equals(pId))
            {
                return elCliente;
            }
        }
        return null;
    }
    public Tutoría obtenerTutoría(String pCod)
    {
        Tutoría LaTutoría;
        for(int i = 0; i < tutorías.size(); i++)
        {
            LaTutoría = tutorías.get(i);
            if(LaTutoría.getCódigo().equals(pCod))
            {
                return LaTutoría;
            }
        }
        return null;
    }
    public boolean registrarTutorEnBase(TModalidad modalidad, String materiaTutoría, String correoEstudinatil, String contraseña, String nombre, boolean lectura){
        if(obtenerTutor(correoEstudinatil) == null && verificarCorreo(correoEstudinatil)) {
            Tutor nuevoTutor = new Tutor(modalidad, materiaTutoría, correoEstudinatil, contraseña, nombre);
            tutores.add(nuevoTutor);
            if(!lectura) {
                agregarInformacionJSON("Tutor.json","Tutor");
            }
            return true;
        }
        return false;
    }
    public boolean registrarTutoríaEnBase(Tutor tutor, String código, String escuela, String materia, TModalidad modalidad, String aula, String horario, int cupo, Calendar desde, Calendar hasta, int sesionesTotales, int asistenciaTotal, boolean enCursoActualmente, ArrayList<Estudiante> EstudiantesMatriculados, int sesiones, boolean lectura){
        if(obtenerTutoría(código) == null) {
            Tutoría nuevaTutoría = new Tutoría(tutor, código, escuela, materia, modalidad, aula, horario, cupo, desde, hasta, sesionesTotales, asistenciaTotal, enCursoActualmente, EstudiantesMatriculados, sesiones);
            tutorías.add(nuevaTutoría);
            reservarAula(obtenerAula(aula), desde, hasta);
            obtenerAula(aula).setReservada(true);
            if(!lectura) {
                agregarInformacionJSON("Tutoría.json","Tutoría");
            }
            return true;
        }
        return false;
    }
    public Estudiante getEstudiante(String carné){
        for (Estudiante E: estudiantes){
            if(E.getCarné().equals(carné))
                return E;
        }return null;
    }
    public Tutor getTutor(String carné){
        for (Tutor T: tutores){
            if(T.getCarné().equals(carné))
                return T;
        }return null;
    }
    public Tutoría getTutoría(String código){
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
    public int getAsistenciasPeriodicas(String code){
        for (int i = 0; i < tutorías.size(); i++) {
            if(tutorías.get(i).getCódigo().equals(code))
                return tutorías.get(i).getAsistenciaTotal();
        }
        return 0;
    }
    public void PasarLista(String pCódigo, String pCarné, boolean presente){
        //HashMap edicion= new HashMap();
        //edicion.put("matriculadoEn", "");
        if (presente) {
            for (int i = 0; i < tutorías.size(); i++) {
                if (tutorías.get(i).getCódigo().equals(pCódigo)) {
                    tutorías.get(i).PasarLista(pCarné);
                    //editarEstudianteJSON( pCarné,  edicion);
                }
            }
        }else{
            //editarEstudianteJSON( pCarné,  edicion);
        }
    }
    public boolean habilitarAula(Aula A, Calendar Desde, Calendar Hasta){
        HashMap edicion= new HashMap();
        if (!A.isReservada()){
            edicion.put("Desde", Utilitaria.formatoFechaJSON(Desde));
            edicion.put("Hasta", Utilitaria.formatoFechaJSON(Hasta));
            //edicion.put("Reservada", String.valueOf(true));
            editarAulaJSON(A.getId(), edicion);
            return true;
        }
        return false;
    }
    public void reservarAula(Aula A, Calendar Desde, Calendar Hasta){
        HashMap edicion= new HashMap();
        if (!A.isReservada()){
            edicion.put("Reservada", String.valueOf(true));
            editarAulaJSON(A.getId(), edicion);
        }
    }
    public void DeshabilitarAula(Aula A){
        HashMap edicion= new HashMap();
        if (A.isReservada()){
            edicion.put("Reservada", String.valueOf(false));
            editarAulaJSON(A.getId(),  edicion);
        }     
    }
    public ArrayList<Estudiante> getListaEstudiantes(){
        return estudiantes;
    }
    public ArrayList<Tutor> getListaTutores(){
       return tutores;
    }
    public ArrayList<Tutoría> getListaTutoríasPorEscuela(String pEscuela){
        ArrayList<Tutoría> auxiliar = new ArrayList();
        for (int i = 0; i < tutorías.size(); i++) {
            if (tutorías.get(i).getEscuela().equals(pEscuela)) {
               auxiliar.add(tutorías.get(i));
            }
        }
        return auxiliar;
    }
    public ArrayList<Tutoría> getListaTutoríasPorMateria(String pMateria){
        ArrayList<Tutoría> auxiliar = new ArrayList();
        for (int i = 0; i < tutorías.size(); i++) {
            if (tutorías.get(i).getMateria().equals(pMateria)) {
                auxiliar.add(tutorías.get(i));
            }
        }
        return auxiliar;
    }
    public ArrayList<Tutoría> getListaTutoríasPorModalidad(String pModalidad){
        ArrayList<Tutoría> auxiliar = new ArrayList();
        for (int i = 0; i < tutorías.size(); i++) {
            if (tutorías.get(i).getModalidad().toString().equals(pModalidad)) {
               auxiliar.add(tutorías.get(i));
            }
        }
        return auxiliar;
    }
    public ArrayList<Tutoría> getListaTutoríasPorCódigo(String pCódigo){
        ArrayList<Tutoría> auxiliar = new ArrayList();
        for (int i = 0; i < tutorías.size(); i++) {
            if (tutorías.get(i).getCódigo().equals(pCódigo)) {
                auxiliar.add(tutorías.get(i));
            }
        }
        return auxiliar;
    }
    public ArrayList<Tutoría> getListaTutorías(){
        return tutorías;
    }
    public ArrayList<Aula> getListaAula(){
        return aulas;
    }
    public ArrayList<String> getListaCodigos(String correo) {
        ArrayList<String> auxiliar = new ArrayList<>();
        for (int i = 0; i < tutorías.size(); i++) {
            if(tutorías.get(i).getTutor().getCorreoEstudiantil().equals(correo)) {
                auxiliar.add(tutorías.get(i).getCódigo());
            }
        }
        return auxiliar;
    }
    public Tutoría getTutoriaPorCodigo(String codigo) {
        for(int i = 0; i < tutorías.size(); i++) {
            if(tutorías.get(i).getCódigo().equals(codigo)) {
               return tutorías.get(i);
            }
        }
        return null;
    }
    public ArrayList<String> getListaSesiones(String codigo) {
        ArrayList<String> auxiliar = new ArrayList<>();
        int sesionesRestantes = getTutoriaPorCodigo(codigo).getSesionesTotales() - getTutoriaPorCodigo(codigo).getSesiones();
        for(int i = 0; i < sesionesRestantes; i++) {
            int numeroSesion = i + 1 + getTutoriaPorCodigo(codigo).getSesiones();
            auxiliar.add("Sesión " + numeroSesion);
        }
       return auxiliar;
    }
    public ArrayList<String> getListaEstudiantesTutoria(String codigo) {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(Estudiante estudianteActual : getTutoriaPorCodigo(codigo).getEstudiantesMatriculados()) {
           auxiliar.add(estudianteActual.getCarné() + "-" + estudianteActual.getNombre());
        }
       return auxiliar;
    }
    public ArrayList<String> getListaCorreosTutores() {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(Tutor tutorActual: tutores) {
            auxiliar.add(tutorActual.getCorreoEstudiantil());
        }
        return auxiliar;
    }
    public ArrayList<String> getListaNombresTutores() {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(Tutor tutorActual: tutores) {
            auxiliar.add(tutorActual.getNombre());
        }
        return auxiliar;
    }
    public ArrayList<String> getListaNombresEscuelas() {
        return escuelas;
    }
    public ArrayList<String> getListaNombresAulas() {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(Aula aulaActual: aulas) {
           auxiliar.add(aulaActual.getId());
        }
        return auxiliar;
    }
    public String getHorarioAula(String id) {
        for(Aula aulaActual: aulas) {
            if(aulaActual.getId().equals(id)) {
                return Utilitaria.formatoFecha(aulaActual.getDesde()) + " - " + Utilitaria.formatoFecha(aulaActual.getHasta());
            }
        }
        return "";
    }
    public void prepararDiccionarios() {
        escuelaMaterias.clear();
        materiaTutorias.clear();
        escuelaMaterias.put("Computación", materiasComputacionDefault);
        escuelaMaterias.put("Matemática", materiasMatematicasDefault);
        for(String materia: materiasDefault) {
            materiaTutorias.put(materia, getTutoriasPorMateria(materia).toArray(String[]::new));
        }
    }
    public ArrayList<String> getTutoriasPorMateria(String materia) {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(Tutoría tutoriaActual: tutorías) {
            if(tutoriaActual.getMateria().equals(materia)) {
                auxiliar.add(tutoriaActual.getCódigo());
            }
        }
        return auxiliar;
    }
    public String getAusenciasTutoria(String codigo) {
        return Integer.toString(getTutoriaPorCodigo(codigo).getAusencias());
    }
    public String getTotalAsistencias(String codigo) {
        return Integer.toString(getTutoriaPorCodigo(codigo).getAsistenciaTotal());
    }
    public String getPorcentajeAsistencia(String codigo) {
        return Double.toString(getTutoriaPorCodigo(codigo).getPorcentajeAsistencia());
    }
    public String[] getTutoriasPorMateriaModalidad(String[] tutorias, String modalidad) {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(String tutoria: tutorias) {
            if(getTutoriaPorCodigo(tutoria).getModalidad().toString().equals(modalidad)) {
                auxiliar.add(tutoria);
            }
        }
        return auxiliar.toArray(String[]::new);
    }
    public String[] getAulasDisponibles() {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(Aula aulaActual: aulas) {
            if(!aulaActual.isReservada()) {
                auxiliar.add(aulaActual.getId());
            }
        }
        return auxiliar.toArray(String[]::new);
    }
    public String [] getTutoresPorMateriaModalidad(String[] nombres, ArrayList<String> correos, String materia, String modalidad) {
        ArrayList<String> auxiliar = new ArrayList<>();
        for(int i = 0; i < nombres.length; i++) {
            if(obtenerTutor(correos.get(i)).getMateriaTutoría().equals(materia) && obtenerTutor(correos.get(i)).getModalidad().equals(TModalidad.valueOf(modalidad))) {
                auxiliar.add(nombres[i]);
            }
        }
        return auxiliar.toArray(String[]::new);
    }
    public boolean isEstudianteMatriculado(String correo) {
        return !obtenerEstudianteCorreo(correo).getMatriculadoEn().isEmpty();
    }
    public String getCarneConCorreo(String correo) {
        for(Estudiante estudianteActual: estudiantes) {
            if(estudianteActual.getCorreoEstudiantil().equals(correo)) {
                return estudianteActual.getCarné();
            }
        }
        return "";
    }
    public String getUsuarioActivo() {
        for(Estudiante estudianteActual: estudiantes) {
            if(estudianteActual.isActive()) {
                return estudianteActual.getCorreoEstudiantil();
            }
        }
        for(Tutor tutorActual: tutores) {
            if(tutorActual.isActive()) {
                return tutorActual.getCorreoEstudiantil();
            }
        }
        return "";
    }
    public void setUsuarioActivo(String correo, boolean estado) {
        this.correoUsuario = "Hola";
        for(Estudiante estudianteActual: estudiantes) {
            if(estudianteActual.getCorreoEstudiantil().equals(correo)) {
                estudianteActual.setActive(estado);
            }
        }
        for(Tutor tutorActual: tutores) {
            if(tutorActual.getCorreoEstudiantil().equals(correo)) {
                tutorActual.setActive(estado);
            }
        }
    }
    public int verificarCrendecials(String pUsuario, String pContraseña){
        for (int i = 0; i < estudiantes.size(); i++) {
            if (pUsuario.equals(getUsername(estudiantes.get(i).getCorreoEstudiantil())) && pContraseña.equals(estudiantes.get(i).getContraseña())) {
               estudiantes.get(i).setActive(true);
               return 1;
            }
        }
        for(int i=0; i < tutores.size(); i++){
            if (pUsuario.equals(getUsername(tutores.get(i).getCorreoEstudiantil())) && pContraseña.equals(tutores.get(i).getContraseña())) {
               tutores.get(i).setActive(true);
               return 2;
            }
        } 
        if (pUsuario.equals("usuarioAdmin") && pContraseña.equals("contraseñaAdmin")) { 
            return 3;
        }
        return -1;
    }
    public String getUsername(String parametro){
        String[] username = parametro.split("@", 2); 
        return username[0];
    }
    public boolean verificarCorreo(String correo)
    {
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)"
                       + "*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher comparador = patron.matcher(correo);
        return comparador.find();
    }
}
