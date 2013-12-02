package controllers;



/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;*/


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
/*import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;*/
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



import org.springframework.web.servlet.ModelAndView;

import services.AuditService;
/*import util.Encrypt;*/
import services.UserService;
import domain.AuditLog;
import domain.User;
import event.constants.EventLogConstants;
import services.EventService;


/**
 * {@link UserController} controller responsible for checking if user exists in DB and
 * checking the password field.
 */
@Controller
@RequestMapping(value = "/UserLogin")
public class UserController {
	private UserService userService;
	private AuditService auditService;
	

	/**
	 * @param userService
	 */
	@Autowired
	public UserController(UserService userService, AuditService auditService) {
		this.userService = userService; 
		this.auditService = auditService;
	}
	
	
	/*private EventService eventService;

	*//**
	 * @param eventService
	 *//*

	public UserController(EventService eventService) {
		this.eventService = eventService; 
	}
	*/
/*	private User user;*/
	

	
	
	 /* Set disallowed fields to prevents from entering by the user 
	 * by modifying request 
	 * @param dataBinder
	 */
  /* @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
      dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
    *//**
     * 
     * @param binder databinder object that connects to the date editor
     *//*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
*/
    
    
/*    
    *//**
     * Sets up the initial form
     * @param model
     * @return initial view
     */
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute("user", new User());
		return "UserLogin";
	}

	/**
	 * Process the form submission
	 * @param event
	 * @param result
	 * @param model
	 * @return the view
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(User user, BindingResult result, Model model) {
		
        if (user.getUserName().equals("")) {
            result.reject("userName", "Please enter your Email Address in the User Name field"); //Username cannot be blank
        } 
        
        if (user.getPassword().equals("")) {       //Password cannot be blank 
            result.reject("password", "Please enter your password in the password field");
        } 
        
		if (result.hasErrors()) {               
			return "UserLogin";
		} 
		if (result.equals(user))
		   {
			return "UserLogin";
		   }
	////////////////////////////here must be some issues below. I tested many times in various approaches but failed///////////////////////////////////////////
		  else{
			   userService.saveUser(user);          //save userName and password
			   model.addAttribute("user", user); //
			   return "redirect:/"; ///?????????
		   }
	}
}

	

/*//////here should have a mapping (User Name,which is the emaill address should map to the userID in log.jsp)//////
AuditLog log = new AuditLog();
log.setUserId(userService.loadUser(userName));*/
////////////////////////////////////////////////////////////////

