package controllers;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import beans.biblio;
import beans.collection;
import dao.BiblioDao;




@Controller
public class biblioController {
	
	@Autowired
	BiblioDao dao;
	
	
	@GetMapping("/")
	public String sidebar(Model m) {
	
	return "welcome";
	}
	
		
	@GetMapping("/createbiblio")
	public String createBiblio(Model m,HttpServletRequest req, HttpServletResponse res) {
		// For View collection Form
	List<collection> list = dao.getCollection();
	m.addAttribute("command", new biblio());
	m.addAttribute("list", list);
	return "createbiblio";
		}

		
	@PostMapping("/savebiblio") 
	public String saveBiblio(@ModelAttribute("biblio") biblio bib,RedirectAttributes redir)
   {
	dao.save(bib); 
	return "redirect:/"; 
	}
		
	
	

}
