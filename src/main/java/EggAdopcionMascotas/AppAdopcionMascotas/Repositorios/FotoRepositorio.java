package EggAdopcionMascotas.AppAdopcionMascotas.Repositorios;

import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepositorio extends JpaRepository<Foto, String> {

}
