/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EggAdopcionMascotas.AppAdopcionMascotas.Servicios;

import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Mascota;
import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Usuario;
import EggAdopcionMascotas.AppAdopcionMascotas.Enums.EstadoAdopcion;
import EggAdopcionMascotas.AppAdopcionMascotas.Repositorios.MascotaRepositorio;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MascotaServicio {

    @Autowired
    MascotaRepositorio repomascota;

    @PersistenceContext
    private EntityManager entityManager;

    public void NuevaMascota(Usuario user, Mascota gmascota, String image) {
        Mascota mascota = new Mascota();
        mascota.setNombre(gmascota.getNombre());
        mascota.setDescripcion(gmascota.getDescripcion());
        mascota.setTipoAnimal(gmascota.getTipoAnimal());
        mascota.setSexo(gmascota.getSexo());
        mascota.setEstadoAdopcion(EstadoAdopcion.ENADOPCION);
        mascota.setFechaAdopcion(new Date());
        mascota.setFoto(image);
        mascota.setTamanioMascota(gmascota.getTamanioMascota());
        mascota.setEdadMascota(gmascota.getEdadMascota());
        mascota.setUsuario(gmascota.getUsuario());
        repomascota.save(mascota);
    }

    public Optional<Mascota> ModificarMascota(String MascotaID) {
        Optional<Mascota> mascota = repomascota.findById(MascotaID);

        if (mascota.get() != null) {
            return mascota;
        }

        return null;

    }

    public List<Mascota> GetAllMascotas() {
        List<Mascota> mascotas = repomascota.findAll();

        if (mascotas.isEmpty()) {
            return null;
        }

        return mascotas;
    }

    public String CreateImage(String dir, MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                Path directorio, rutag1;

                directorio = Paths.get(dir);

                rutag1 = Paths.get(directorio.toFile().getAbsolutePath() + "//" + file.getOriginalFilename());

                Files.write(rutag1, file.getBytes());

            } catch (Exception ex) {
                System.out.println("Error en la Creacion");
            }
        }

        return file.getOriginalFilename();
    }

    public Mascota GetIdMascotas(String MascotaID)
    {

        return repomascota.findById(MascotaID).orElse(null);
    }

    /*

    public Mascota mostrar(String id) {

        String query = "FROM mascota WHERE id = " + id + " ";
        return (Mascota) entityManager.createQuery(query).getSingleResult();

    }

     */

}
