package sboot.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sboot.endpoints.UserStateSummaryView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sohail on 28/04/15.
 */
@Controller
@RequestMapping("/userfullstate")
public class UserStateReport {

    private static final String template = "User Information and State: %s!";
    private final AtomicLong counter = new AtomicLong();

    Object model;
    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    UserStateSummaryView method_name_does_not_matter(
            //@RequestParam(value="uid", required=false, defaultValue=model.getTheOnlyUser())
            @RequestParam(value="uid", required=true)
            long uid
    ) {
        //gameobj
        //gameobj.getUserState(uid).getSummary();
        return new UserStateSummaryView(uid, counter.incrementAndGet() + String.format(template, uid));
    }
}
