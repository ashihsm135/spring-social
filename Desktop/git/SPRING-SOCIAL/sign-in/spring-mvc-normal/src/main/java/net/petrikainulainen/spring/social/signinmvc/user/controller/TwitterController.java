package net.petrikainulainen.spring.social.signinmvc.user.controller;

import net.petrikainulainen.spring.social.signinmvc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;


/**
 * @author Petri Kainulainen
 */
@Controller
@SessionAttributes("twitter")
public class TwitterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    protected static final String ERROR_CODE_EMAIL_EXIST = "NotExist.user.email";
    protected static final String TWITTERAPIDETAILLIST = "twitter";
    protected static final String TWITTERAPIDETAIL = "twitter/detail";

    private UserService service;
    
    
    //Connection<?> connectionn = null;

    @Autowired
    public TwitterController(UserService service) {
        this.service = service;
    }

    /**
     * Renders the registration page.
     */
    @RequestMapping(value = "/twitter/api", method = RequestMethod.GET)
    public String showTwitterDetail(WebRequest request, Model model,@RequestParam(required = false) Connection<Twitter> connection) {
        LOGGER.debug("Rendering Registration Page.");

        //Connection<?> connectionn = connection;  //ProviderSignInUtils.getConnection(request);
        
        Twitter twitter = (Twitter) connection.getApi();
        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
        for(TwitterProfile friend : friends){
        	System.out.println(friend.getScreenName());
        }
        
        LOGGER.debug("Rendering registration form with information: {}", "");

        model.addAttribute(TWITTERAPIDETAILLIST, "");

        return TWITTERAPIDETAIL;
    }
}
