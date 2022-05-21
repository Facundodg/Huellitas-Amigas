package EggAdopcionMascotas.AppAdopcionMascotas.Controladores;

import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Usuario;
import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Zona;
import EggAdopcionMascotas.AppAdopcionMascotas.Errores.ErroresServicio;
import EggAdopcionMascotas.AppAdopcionMascotas.Servicios.UsuarioServicio;
import EggAdopcionMascotas.AppAdopcionMascotas.Servicios.ZonaServicio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ZonaServicio zonaServicio;

    @GetMapping("/registro")
    public String registro(Model modelo) {
        List<Zona> zonas = zonaServicio.listarZonas();
        modelo.addAttribute("zonas", zonas);
        modelo.addAttribute("usuario", new Usuario());

        return "SignUp";
    }

    @GetMapping("/user-result")
    @ResponseBody
    public List<Usuario> ReturnUser(@RequestParam String id) {

        List<Usuario> buffer = new ArrayList<Usuario>();
        buffer.add(usuarioServicio.buscarUsuarioPorId(id));
        return buffer;
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam String password2,
            Model modelo,
            @ModelAttribute("usuario") Usuario usuario) {
        try {
            usuarioServicio.registrarUsuario(password2, usuario);
        } catch (ErroresServicio e) {
            modelo.addAttribute("error", e.getMessage());
            modelo.addAttribute("usuario", usuario);
        }
        return "SignUp";
    }

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
