package EggAdopcionMascotas.AppAdopcionMascotas.Enums;

public enum TipoAnimal {

    GATO("Gato"), PERRO("Perro"), OTRO("Otro");

    private String nombre;

    private TipoAnimal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
