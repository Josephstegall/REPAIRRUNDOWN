package org.launchcode.repairrundown.Controllers;


import org.launchcode.repairrundown.Models.Data.UserDao;
import org.launchcode.repairrundown.Models.Forms.ProcessExistingUser;
import org.launchcode.repairrundown.Models.Forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index (Model model){ //this is the landing, home page
        model.addAttribute("title","Welcome To Repair Rundown");
        return "home/index";

    }

    @RequestMapping(value= "login", method=RequestMethod.GET)
    public String login (Model model){ //this is the page to fill in the existing user info
        model.addAttribute(new ProcessExistingUser());
        model.addAttribute("title","Please Login");

        return "home/login";
    }

    @RequestMapping(value= "login", method=RequestMethod.POST) //this is the existing user home page
    public String login (@ModelAttribute @Valid ProcessExistingUser loginform, Errors errors){

        if (errors.hasErrors()){
            return "home/login";
        }

        return "home/options";
    }

    @RequestMapping(value="registration", method=RequestMethod.GET)
    public String registration (Model model){ //this is the page to fill in the registration info
        model.addAttribute(new RegistrationForm());
        model.addAttribute("title","Please Enter All Information");

        return "home/registration";
    }
    @RequestMapping(value="registration", method=RequestMethod.POST)
    public String registration (@ModelAttribute @Valid RegistrationForm form, Errors errors, HttpServletRequest request){ //this is the page to fill in the registration info

        if (errors.hasErrors()){
            return "home/registration";
        }

        RegistrationForm existingUser = userDao.findByUsername(form.getUsername());
        RegistrationForm newUser = new RegistrationForm(form.getFirstName(),form.getLastName(),form.getUsername(), form.getPassword());
        userDao.save(newUser);



        return "redirect:home/options";
    }

}
