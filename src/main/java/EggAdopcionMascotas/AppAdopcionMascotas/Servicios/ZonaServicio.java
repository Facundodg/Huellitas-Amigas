package EggAdopcionMascotas.AppAdopcionMascotas.Servicios;

import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Zona;
import EggAdopcionMascotas.AppAdopcionMascotas.Repositorios.ZonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZonaServicio {

    @Autowired
    private ZonaRepositorio zonaRepositorio;

    public List<Zona> listarZonas() {
        return zonaRepositorio.findAll();
    }

    public Zona devolverZona(String id) {
        return zonaRepositorio.getById(id);
    }
}
