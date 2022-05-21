package EggAdopcionMascotas.AppAdopcionMascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication
public class AppAdopcionMascotasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppAdopcionMascotasApplication.class, args);
    }
    

public void configure(WebSecurity web) {
         // El nuevo firewall se ve obligado a sobrescribir el original
    web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
}
 
@Bean
public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
    StrictHttpFirewall firewall = new StrictHttpFirewall();
    firewall.setAllowUrlEncodedSlash(true);
    return firewall;


}

}