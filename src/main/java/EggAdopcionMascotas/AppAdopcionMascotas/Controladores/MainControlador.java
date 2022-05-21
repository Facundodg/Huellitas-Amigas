package EggAdopcionMascotas.AppAdopcionMascotas.Controladores;

import EggAdopcionMascotas.AppAdopcionMascotas.Entidades.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("")
public class MainControlador {

    @GetMapping("")
    public String index(HttpSession session, Model modelo) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        modelo.addAttribute("usuario", usuario);
        return "home";
    }

    @PreAuthorize("hasAnyRole('ROLE_USUARIO_REGISTRADO')")
    @GetMapping("/UserPanel")
    public String UserPanel() {
        return "UserPanel";
    }

}
