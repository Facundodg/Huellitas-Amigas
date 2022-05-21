package EggAdopcionMascotas.AppAdopcionMascotas.Enums;

public enum Sexo {

    HEMBRA("Hembra"), MACHO("Macho");

    private String nombre;

    private Sexo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
