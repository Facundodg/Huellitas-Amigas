package EggAdopcionMascotas.AppAdopcionMascotas.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginControlador {

    @GetMapping("")
    public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout,
            Model modelo) {
        if (error != null) {
            modelo.addAttribute("error", "Nombre de usuario o clave incorrectos");
        }
        if (logout != null) {
            modelo.addAttribute("logout", "Hasta pronto");
        }

        return "login";
    }

}
