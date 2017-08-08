package br.com.lrsantos.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.lrsantos.model.dao.InstituicaoDAO;
import br.com.lrsantos.model.dao.InstituicaoMemoryDAO;
import br.com.lrsantos.model.service.InstituicaoService;
import br.com.lrsantos.resource.InstituicaoResource;
import br.com.lrsantos.resource.TesteController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={TesteController.class, InstituicaoMemoryDAO.class,InstituicaoDAO.class, 
									InstituicaoResource.class, InstituicaoService.class})
public class WebAppConfig {

	@Bean
	public MessageSource messageSource() {
	     ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	     messageSource.setBasename("/WEB-INF/messages");
	     return messageSource;
	}
}
