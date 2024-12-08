package dominio;

import java.util.List;

public class Eleccion {
    /*
    Clase Eleccion:
    Atributos: candidatos (lista de objetos Candidato), papeletas (lista de objetos Papeleta)
    Métodos: realizarRecuento(), eliminarCandidatoConMenosVotos(), comprobarMayoríaAbsoluta(), validarPapeletas()
     */
    private static List<Candidato> candidatos;
    private List<Papeleta> papeletas;


    //Constructores:
    public Eleccion(List<Papeleta> papeletas) {
        candidatos = List.of(
                new Candidato("Pepito"),
                new Candidato("Juan"),
                new Candidato("Alejandro"),
                new Candidato("Matthew")
        );
        this.papeletas = papeletas;
    }


    //Getters y Setters:
    public List<Papeleta> getPapeletas() {return papeletas;}
    public Eleccion setPapeletas(List<Papeleta> papeletas) {
        this.papeletas = papeletas;
        return this;
    }


    //Métodos de candidatos
    public static Candidato getCandidato(int indiceCandidato) {
        switch (indiceCandidato) {
            case 1:
                return candidatos.get(0);
            case 2:
                return candidatos.get(1);
            case 3:
                return candidatos.get(2);
            case 4:
                return candidatos.get(3);
            default:
                System.out.println("Este candidato no existe.");
                return null;
        }
    }
    public static int indiceCandidato(Candidato candidato) {
        switch (candidato.getNombre()) {
            case "Pepito":
                return 1;
            case "Juan":
                return 2;
            case "Alejandro":
                return 3;
            case "Matthew":
                return 4;
            default:
                System.out.println("Este candidato no existe.");
                return -1;
        }
    }
    public int getTotalVotos() {
        int totalVotos = 0;
        for (Candidato candidato : candidatos) {
            totalVotos += candidato.getVotos();
        }
        return totalVotos;
    }


    //Métodos de Eleccion
    public boolean validarPapeletas() {
        try {
            if (!papeletas.isEmpty()) {
                return false;
            } else {
                for (Papeleta papeleta : papeletas) {
                    if (papeleta == null) return false;
                }
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("Las papeletas no están validadas.");
            return false;
        }
    }
    public boolean realizarRecuento() {
        try {
            if (validarPapeletas()) {
                for (Candidato candidato : candidatos) {
                    for (Papeleta papeleta : papeletas) {
                        if (papeleta.getCandidatos().contains(candidato)) {
                            candidato.incrementarVotos();
                        }
                    }
                }
            }
            eliminarCandidatoConMenosVotos();
            return true;
        } catch (NullPointerException e) {
            System.out.println("Error de conteo.");
            return false;
        }
    }
    public boolean eliminarCandidatoConMenosVotos() {
        try {
            Candidato candidato1 = candidatos.get(0);
            for (Candidato candidato2 : candidatos) {
                if (candidato1.getVotos() > candidato2.getVotos()) {
                    candidato1 = candidato2;
                }
            }
            candidatos.remove(candidato1);
            return true;
        } catch (NullPointerException e) {
            System.out.println("Error de eliminación.");
            return false;
        }
    }
    public boolean comprobarMayoriaAbsoluta() {
        for (Candidato candidato: candidatos) {
            if (candidato.getVotos() >= getTotalVotos()) {
                System.out.println(candidato+" tiene mayoría absoluta.");
                return true;
            }
        }
        System.out.println("Ningún candidato tiene mayoría absoluta.");
        return false;
    }
    public void mostrarResultados() {
        for (Candidato candidato : candidatos) {
            System.out.println(candidato.getNombre() + "\tVotos: "+ candidato.getVotos());
        }
        System.out.println();
    }
}