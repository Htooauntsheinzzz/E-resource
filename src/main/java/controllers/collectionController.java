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
import beans.collection;
import dao.CollectionDao;

@Controller
public class collectionController {
	
	@Autowired
	CollectionDao dao;
	
	
	
	  @GetMapping("/collectionadd") 
	  public String addcollection(Model m) {
	  m.addAttribute("command", new collection()); 
	  return "addcollection"; }
	  
	  
	@PostMapping("/savecollection")
	public String saveCollection(@ModelAttribute("collection") collection col,RedirectAttributes redir) {
	dao.save(col);
	return "redirect:/collectionadd";
	}
}
