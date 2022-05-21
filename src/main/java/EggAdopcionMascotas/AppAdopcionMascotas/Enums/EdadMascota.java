package EggAdopcionMascotas.AppAdopcionMascotas.Enums;

public enum EdadMascota {

    // Seleccione la edad de la mascota
    CACHORRA("Cachorra/o"), JOVEN("Jóven"), ADULTA("Adulta/o");

    private String nombre;

    private EdadMascota(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
