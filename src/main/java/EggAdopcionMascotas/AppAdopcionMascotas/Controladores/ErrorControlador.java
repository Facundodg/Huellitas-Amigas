package EggAdopcionMascotas.AppAdopcionMascotas.Controladores;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorControlador implements ErrorController {

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
    public String error(Model modelo, HttpServletRequest request) {

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        modelo.addAttribute("codigo", statusCode);

        switch (statusCode) {
            case 400:
                modelo.addAttribute("explicacion", "La solicitud contiene información incorrecta");
                break;
            case 403:
                modelo.addAttribute("explicacion", "No tiene los permisos necesarios para acceder a este recurso");
                break;
            case 404:
                modelo.addAttribute("explicacion", "Página no encontrada");
                break;
            case 500:
                modelo.addAttribute("explicacion", "Error interno en el servidor");
                break;
            default:
                modelo.addAttribute("explicacion", "Ocurrió un error inesperado");
                break;

        }
        return "error";
    }

}
