package pe.com.Colegio.Euler.config;

import jdk.jfr.Description;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 *
 * @author Dev
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    @Description("Ejemplo de HTML")
    public ClassLoaderTemplateResolver templateResolver() {
        var templateResolver = new ClassLoaderTemplateResolver();
        //carpeta donde se encuentra las paginas web
        templateResolver.setPrefix("templates/");
        templateResolver.setCacheable(false);
        //tipo de paginas que se van a cargar
        templateResolver.setSuffix(".html");
        //modo de plantilla de las paginas
        templateResolver.setTemplateMode("HTML5");
        //permitir caracteres especiales
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    @Description("Motor de integracion")
    public SpringTemplateEngine templateEngine() {
        var templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    @Description("Resolucion de vistas en Thymeleaf")
    public ViewResolver viewResolver() {
        var viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//habilitamos el acceso a la carpeta static donde estas los recursos
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

}
