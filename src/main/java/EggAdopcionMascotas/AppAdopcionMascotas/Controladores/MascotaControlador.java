package EggAdopcionMascotas.AppAdopcionMascotas.Controladores;

import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Mascota;
import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Usuario;
import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Zona;
import EggAdopcionMascotas.AppAdopcionMascotas.Servicios.MascotaServicio;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import EggAdopcionMascotas.AppAdopcionMascotas.Servicios.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping("/mascota")
public class MascotaControlador {

    @Autowired
    private ZonaServicio zonaServicio;

    @Autowired
    private MascotaServicio mservicio;

    @GetMapping("/publicar-mascota")
    public String index(Model model) {

        model.addAttribute("mascota", new Mascota());

        return "darenadopcion";
    }

    @PostMapping("/publicar-mascota")
    public String registrar(HttpSession session, @RequestParam("file") MultipartFile file, @ModelAttribute("mascota") Mascota mascota) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        mascota.setUsuario(usuario);
        mservicio.NuevaMascota(usuario, mascota, mservicio.CreateImage("src//main//resources//static/upload", file));
        return "home";
    }

    @GetMapping("")
    public String ViewUserPanel() {
        return "UserPanel";
    }

    @GetMapping("/mostrarmascotas")
    @ResponseBody
    public List<Mascota> MostrarMascotas() {
        return mservicio.GetAllMascotas();
    }

    @GetMapping("/mostrarmascotasid{id}")
    @ResponseBody
    public List<Mascota> MostrarMascotas(@RequestParam("id") String MascotaID)
    {
        List<Mascota> masc = new ArrayList<Mascota>();

        masc.add(mservicio.GetIdMascotas(MascotaID));

        System.out.println(masc);

        return masc;
    }

    //------------------------------------------------------------------------

    /*

    @RequestMapping(value = "mostrar/{id}", method = RequestMethod.GET) // esta anotacion indica la url para ingresar a esta funcion
    public Mascota getMascota(@PathVariable String id) {

        return (mservicio.mostrar(id));

    }
    */

    //------------------------------------------------------------------------




    @GetMapping("/editar")
    public String editar(HttpSession session, Model modelo) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        try {
            modelo.addAttribute("usuario", usuario);
        } catch (Exception e) {
            e.getMessage();
        }

        List<Zona> zonas = zonaServicio.listarZonas();
        modelo.addAttribute("zonas", zonas);
        return "ConfigVista";

    }

}