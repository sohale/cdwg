package sboot.endpoints;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sboot.GameInstance;

import javax.annotation.Resource;

/**
 * Created by sohail on 12/05/15.
 */
@Controller
@RequestMapping("/choose")
public class ChooseOnPushButtonController {

    @Resource
    GameInstance gameModel;

    private static final Log log = LogFactory.getLog(ChooseOnPushButtonController.class);

    ChooseOnPushButtonController(){
        log.info("ChooseOnPushButtonController constructor called");
    }


    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody void
    choose
        (
            @RequestParam(value="uid", required=true)
            Long uid,
            @RequestParam(value="choice", required=true)
            Integer choice
        )
    {
        log.info(String.format("User '%1$s' chose %2$s ",uid+"",choice+""));
    }

}
