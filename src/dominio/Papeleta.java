package dominio;

import java.io.*;
import java.util.*;

public class Papeleta {
    // Atributos
    private String nombre;
    private List<Candidato> candidatos;


    // Constructores
    public Papeleta(List<Candidato> candidatos) {
        this.candidatos = new ArrayList<>(candidatos); // Copiamos la lista para evitar problemas de referencia.
    }
    public Papeleta(List<Candidato> candidatos, String nombre) {
        this.candidatos = candidatos;
        this.nombre = nombre;
    }


    //Getters y Setters
    public List<Candidato> getCandidatos() {
        return candidatos; // Retorna la lista para mantener la encapsulación.
    }
    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos; // Actualiza la lista con una copia de la misma lista.
    }


    // Método para obtener la primera preferencia de candidato
    public Candidato obtenerPreferencia() {
        if (!candidatos.isEmpty()) {
            return candidatos.get(0); // Retorna el primer candidato de la lista.
        }
        return null; // Retorna null si la lista está vacía.
    }
    // Método para eliminar un candidato específico de la lista
    public boolean eliminarCandidato(Candidato candidato) {
        if (candidatos.contains(candidato)){
            candidatos.remove(candidato); // Elimina el candidato de la lista si está presente.
            return true;
        }else{
            System.out.println("El candidato no está en la lista");
            return false;
        }
    }


    //Lectura y Escritura
    public static Papeleta leer(String nombre) {
        List<Candidato> candidatos = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(nombre+".csv"));

            while (scanner.hasNextLine()) {
                int indiceCandidato = scanner.nextInt();
                candidatos.add(Eleccion.getCandidato(indiceCandidato));
            }
            return new Papeleta(candidatos);

        } catch (IOException e) {
            System.out.println("Error de lectura.");
            return null;
        }
    }
    public boolean grabar() {
        try {
            FileWriter fw = new FileWriter(new File(nombre+".csv"));
            for (Candidato candidato : candidatos) {
                fw.write(Eleccion.indiceCandidato(candidato)+"\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error de escritura.");
            return false;
        }
    }
}