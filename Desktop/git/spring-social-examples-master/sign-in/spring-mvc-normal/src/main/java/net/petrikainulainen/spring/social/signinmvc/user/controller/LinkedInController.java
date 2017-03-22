package net.petrikainulainen.spring.social.signinmvc.user.controller;

import net.petrikainulainen.spring.social.signinmvc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;


/**
 * @author Petri Kainulainen
 */
@Controller
@SessionAttributes("linkedin")
public class LinkedInController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    protected static final String ERROR_CODE_EMAIL_EXIST = "NotExist.user.email";
    protected static final String LINKEDINAPIDETAILLIST = "linkedin";
    protected static final String LINKEDINAPIDETAIL = "linkedin/detail";

    private UserService service;

    @Autowired
    public LinkedInController(UserService service) {
        this.service = service;
    }

    /**
     * Renders the registration page.
     */
    @RequestMapping(value = "/linkedin/api", method = RequestMethod.GET)
    public String showTwitterDetail(WebRequest request, Model model ,@ModelAttribute(value="linkedin") Connection<LinkedIn> connection) {
        LOGGER.debug("Rendering Registration Page.");
        LinkedIn linkedin = (LinkedIn) connection.getApi();
      
        LOGGER.debug("Rendering registration form with information: {}", "");
        model.addAttribute(LINKEDINAPIDETAILLIST, "");
        return LINKEDINAPIDETAIL;
    }
}
