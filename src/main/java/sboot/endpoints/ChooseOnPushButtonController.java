package sboot.endpoints;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sboot.GameInstance;
import sboot.TimestampProvider;

import javax.annotation.Resource;
import java.time.ZonedDateTime;

/**
 * Created by sohail on 12/05/15.
 */
@Controller
@RequestMapping("/choose")
public class ChooseOnPushButtonController {

    @Resource
    GameInstance gameModel;

    @Resource
    TimestampProvider timer;

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
        System.out.println("choooose="+this.timer);
        ZonedDateTime ts = timer.getNow();
        log.info(String.format("User '%1$s' chose %2$s at %3$s",uid+"",choice+"",ts+""));

        this.gameModel.getUserState(uid).setChoice(choice, ts);
    }

}
