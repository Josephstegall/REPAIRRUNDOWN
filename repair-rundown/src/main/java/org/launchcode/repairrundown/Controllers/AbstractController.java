package org.launchcode.repairrundown.Controllers;

import org.launchcode.repairrundown.Models.Data.UserDao;
import org.launchcode.repairrundown.Models.Forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    public static final String userSessionKey = "user_id";

    protected RegistrationForm getUserFromSession (HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }
    protected void setUserInSession(HttpSession session, RegistrationForm user) {
        session.setAttribute(userSessionKey, user.getId());
    }
    @ModelAttribute("user")
    public RegistrationForm getUserForModel(HttpServletRequest request) {
        return getUserFromSession(request.getSession());
    }
}
