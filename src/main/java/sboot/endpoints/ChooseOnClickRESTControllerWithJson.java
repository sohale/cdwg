package sboot.endpoints;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sboot.GameInstance;
import sboot.TimestampProvider;
import sboot.UserState;

import javax.annotation.Resource;
import java.time.ZonedDateTime;

/**
 * Sets a choice, then returns the result back to the scope as a json.
 * This is also a minimalistic version of @ChooseOnPushButtonController, same but returns a json.
 * See Dave Syer's tutorial on Spring.io
 * 28/05/15.
 */
@RestController
public class ChooseOnClickRESTControllerWithJson {

    @Resource
    GameInstance gameModel;

    @Resource
    TimestampProvider timer;

    private static final Log log = LogFactory.getLog(ChooseOnClickRESTControllerWithJson.class);

    ChooseOnClickRESTControllerWithJson(){
        log.info("ChooseOnPushButtonController constructor called");
    }

    @RequestMapping("/choosej") //,method = RequestMethod.GET)
    public
    //@ResponseBody void
    //@ResponseBody Why decorator not needed?
    UserState
    choose
        (
            @RequestParam(value="uid", required=true)
            Long uid,
            @RequestParam(value="choice", required=true)
            Integer choice,
            @RequestParam(value="old_choice", required=false) //for consistence check only
            Integer old_choice
        )
    {
        System.out.println("chosen by the button=" + this.timer);
        ZonedDateTime ts = timer.getNow();
        log.info(String.format("User '%1$s' chose %2$s at %3$s (old choice = %1$s)",uid+"",choice+"",ts+"", old_choice));

        UserState u = this.gameModel.getUserState(uid);
        u.setChoice(choice, ts);
        return u;
    }

}
