package controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import beans.user;
import dao.ItemDao;

@Controller
public class crudcontroller {

	@Autowired
	ItemDao dao;
	
	  @GetMapping("/user")
	  public String showform(Model m, HttpServletRequest req,HttpServletResponse res) { 
	  List<user> list = dao.getUsers();
	  m.addAttribute("list", list);
	  return "userlist"; 
	  }
	
	@GetMapping("/userform/create")
	public String createuser(Model m, HttpServletRequest req, HttpServletResponse res) {
		m.addAttribute("command", new user());
		return "createuser";
	}

	@PostMapping(value = "userform/save")
	public String saveUser(@ModelAttribute("users") user user, RedirectAttributes redir) {
		dao.save(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/userform/edit/{id}")
	public String edit(@PathVariable int id, Model m, HttpServletRequest req, HttpServletResponse res) {
		user user = dao.getUserById(id);
		m.addAttribute("command", user);
		return "useredit";
	}
	
	@RequestMapping(value = "userform/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("user") user user, RedirectAttributes redir) {
		dao.update(user);
		return "redirect:/";
	}
	
	@RequestMapping(value = "userform/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/";
	}
	
	
	
	
}
