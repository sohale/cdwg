package sboot.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sboot.UserState;
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

    UserState model;

    @RequestMapping(method = RequestMethod.GET)
    //@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    UserStateSummaryView method_name_does_not_matter(
            //@RequestParam(value="uid", required=false, defaultValue=model.getTheOnlyUser())
            @RequestParam(value="uid", required=true)
            //@RequestParam(value="uid", required=false, defaultValue="-1")
            Long uid //todo: long
    ) {
        //gameobj
        //gameobj.getUserState(uid).getSummary();
        System.out.println("value received: "+uid);
        long uidl=Long.valueOf(uid+"");
        System.out.println("step 2: " + uidl);
        UserStateSummaryView u = new UserStateSummaryView(uidl, counter.incrementAndGet() + String.format(template, uid));
        System.out.println("step 3: " + u);
        return u;
    }
}
