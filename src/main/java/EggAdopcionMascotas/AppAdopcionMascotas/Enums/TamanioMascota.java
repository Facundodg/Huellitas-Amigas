package EggAdopcionMascotas.AppAdopcionMascotas.Enums;

public enum TamanioMascota {

    // seleccione el tamaño de la mascota
    PEQUENIA("Pequeña"), MEDIANA("Mediana"), GRANDE("Grande");

    private String nombre;

    private TamanioMascota(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
