package br.com.lrsantos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.lrsantos.controller.HomeController;
import br.com.lrsantos.model.bean.InstituicaoMemoryDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, InstituicaoMemoryDAO.class})
public class WebAppConfig {

}
