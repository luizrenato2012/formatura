package br.com.lrsantos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.lrsantos.controller.InstituicaoController;
import br.com.lrsantos.controller.TesteController;
import br.com.lrsantos.model.dao.InstituicaoDAO;
import br.com.lrsantos.model.dao.InstituicaoMemoryDAO;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={TesteController.class, InstituicaoMemoryDAO.class,InstituicaoDAO.class, InstituicaoController.class})
public class WebAppConfig {

}
