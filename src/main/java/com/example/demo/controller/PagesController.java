package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.model.Proveedores;
import com.example.demo.repository.PersonalRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PagesController {
	@Autowired
	private Environment env;
	@Autowired
	ProductoRepository productoRepository;
        @Autowired
        private Environment envp;
        @Autowired
        ProveedoresRepository proveedoresRepository;
        @Autowired
        private Environment envs;
        @Autowired
        PersonalRepository personalRepository;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("site_urlport", env.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "Hola Mundo !!");
		for (Producto p: productoRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("productos", productoRepository.findAll());
		return "index";
	}
	
	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "Vas muy bien !!!");
		return "next";
	}
        
        @RequestMapping("/proveedores")
	public String home1(Model model) {
		model.addAttribute("site_urlport", envp.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );
               model.addAttribute("message", "Hola Mundo !!");
                proveedoresRepository.findAll().forEach((p) -> {
                    System.out.println(p.nombre);
            });
		model.addAttribute("proveedores", proveedoresRepository.findAll());
		return "proveedores";
                
        }
        @RequestMapping("/si")
	public String si(Map<String, Object> model) {
		model.put("message", "Vas muy bien !!!");
		return "si";
	}  
        
        @RequestMapping("/personal")
	public String home2(Model model) {
		model.addAttribute("site_urlport", envs.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );
               model.addAttribute("message", "Hola Mundo !!");
                personalRepository.findAll().forEach((p) -> {
                    System.out.println(p.nombre);
            });
		model.addAttribute("personal", personalRepository.findAll());
		return "personal";
                
        }
        @RequestMapping("/sii")
	public String sii(Map<String, Object> model) {
		model.put("message", "Vas muy bien !!!");
		return "sii";
	}        


}