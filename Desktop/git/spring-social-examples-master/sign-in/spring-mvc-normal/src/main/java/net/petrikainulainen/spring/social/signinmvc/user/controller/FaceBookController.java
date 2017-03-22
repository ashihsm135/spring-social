package net.petrikainulainen.spring.social.signinmvc.user.controller;

import net.petrikainulainen.spring.social.signinmvc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
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
@SessionAttributes("facebook")
public class FaceBookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    protected static final String ERROR_CODE_EMAIL_EXIST = "NotExist.user.email";
    protected static final String FACEBOOKAPIDETAILLIST = "facebook";
    protected static final String FACEBOOKAPIDETAIL = "facebook/detail";

    private UserService service;

    @Autowired
    public FaceBookController(UserService service) {
        this.service = service;
    }

    /**
     * Renders the registration page.
     */
    @RequestMapping(value = "/facebook/api", method = RequestMethod.GET)
    public String showTwitterDetail(WebRequest request, Model model ,@ModelAttribute(value="twitter") Connection<?> connection) {
        LOGGER.debug("Rendering Registration Page.");
        Facebook twitter = (Facebook) connection.getApi();
        
        System.out.println("virendra k singh");
        LOGGER.debug("Rendering registration form with information: {}", "");
        model.addAttribute(FACEBOOKAPIDETAILLIST, "");
        return FACEBOOKAPIDETAIL;
    }
}
