package ages.alfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/*
	Classe principal da aplicação Spring.
	Aqui podem ser colocadas dependências e configurações.
 */
@Configuration
@SpringBootApplication
public class AlfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlfaApplication.class, args);
    }

}
