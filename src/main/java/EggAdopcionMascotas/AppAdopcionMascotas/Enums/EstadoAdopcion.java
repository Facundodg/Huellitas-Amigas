package EggAdopcionMascotas.AppAdopcionMascotas.Enums;

public enum EstadoAdopcion {

    ENADOPCION("En adopcion"), ADOPTADA("Adoptada");

    private String nombre;

    private EstadoAdopcion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
