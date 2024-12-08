package dominio;

public class Candidato {
    /*
    Clase Candidato:
    Atributos: nombre, votos
    Métodos: incrementarVotos(), resetearVotos()
     */
    private String nombre;
    private int votos;


    //Constructores:
    public Candidato(String nombre) {
        this.nombre = nombre;
        votos = 0;
    }


    //Getters y Setters:
    public String getNombre() {
        return nombre;
    }
    public Candidato setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public int getVotos() {
        return votos;
    }
    public Candidato setVotos(int votos) {
        this.votos = votos;
        return this;
    }


    //Métodos de Candidato:
    public Candidato incrementarVotos() {
        votos++;
        return this;
    }
    public Candidato resetVotos() {
        votos = 0;
        return this;
    }
    public String toString() {
        return nombre;
    }
    public boolean equals(Object object) {
        if (object != null && object.getClass() == this.getClass()) {
            return nombre.equalsIgnoreCase(((Candidato) object).getNombre());
        }
        else return false;
    }
}