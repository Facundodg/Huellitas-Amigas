package EggAdopcionMascotas.AppAdopcionMascotas.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class Frontcontroler {

    @GetMapping("/configvista")
    public String index() {
        return "ConfigVista";
    }

}
