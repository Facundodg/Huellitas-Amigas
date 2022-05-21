package EggAdopcionMascotas.AppAdopcionMascotas.Repositorios;

import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepositorio extends JpaRepository<Mascota, String> {

}
