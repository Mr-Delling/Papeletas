package dominio;

import java.util.*;
import presentacion.Eleccion;
import java.io.*;

public class Papeleta {
    // Atributos
    private List<Candidato> listaPreferencias;

    // Constructor
    public Papeleta(List<Candidato> listaPreferencias) {
        this.listaPreferencias = new ArrayList<>(listaPreferencias); // Copiamos la lista para evitar problemas de referencia.
    }

    // Método para obtener la primera preferencia
    public Candidato obtenerPrimeraPreferencia() {
        if (!listaPreferencias.isEmpty()) {
            return listaPreferencias.get(0); // Retorna el primer candidato de la lista.
        }
        return null; // Retorna null si la lista está vacía.
    }

     // Método para eliminar un candidato específico de la lista
     public boolean eliminarCandidato(Candidato candidato) {
        if (listaPreferencias.contains(candidato)){
            listaPreferencias.remove(candidato); // Elimina el candidato de la lista si está presente.
            return true;
        }else{
            System.out.println("El candidato no está en la lista");
            return false;
        }
    }
    //Lectura de fichero lecturaCandidatos.csv linea por linea
    
    public static Papeleta lectura(String nombre) {
        List <Candidato> candidatos = new ArrayList<>();
        String rutaFichero = nombre+".csv";
           
        try {
            Scanner scanner = new Scanner(new File(rutaFichero));
            
            while (scanner.hasNextLine()) {
                int indiceCandidato = scanner.nextInt();
                candidatos.add(Eleccion.getCandidato(indiceCandidato));
            }
            return new Papeleta(candidatos);
        }catch (IOException e){
            System.out.println("Error al leer el fichero");
            return null;
        }
    }
    

    // Getter para la lista de preferencias (opcional)
    public List<Candidato> getListaPreferencias() {
        return listaPreferencias; // Retorna la lista para mantener la encapsulación.
    }
     // Setter para actualizar la lista de preferencias (opcional)
     public void setListaPreferencias(List<Candidato> listaPreferencias) {
        this.listaPreferencias = listaPreferencias; // Actualiza la lista con una copia de la misma lista.
    }

}

