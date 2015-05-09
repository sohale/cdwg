package sboot.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sboot.UserState;
import sboot.endpoints.UserStateSummaryView;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/userfullstate")
public class UserStateReport {

    private static final String template = "User Information and State: %s!";
    private final AtomicLong counter = new AtomicLong();

    UserState model1;

    UserStateReport(){
    	System.out.println("UserStateReport constructor called");
    	this.model1 = new UserState();
    }

    @RequestMapping(method = RequestMethod.GET) //Just narrows the http operations! (GET,PUT,POST)
    //It is important!
    //@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    UserStateSummaryView method_name_does_not_matter(
            //@RequestParam(value="uid", required=false, defaultValue=model.getTheOnlyUser())
            //@RequestParam(value="uid", required=false, defaultValue="-1")
            @RequestParam(value="uid", required=true)
                Long uid //todo: long
            ,
            //Model model
            UserState tempmodel  //Constructed each time. Then what's the point? #Q
    ) {
        //gameobj
        //gameobj.getUserState(uid).getSummary();
        System.out.println("value received: "+uid);
        long uidl=Long.valueOf(uid+"");
        System.out.println("(model arg: temporary) :" + tempmodel + "      lastchoice="+tempmodel.lastChoice());
        System.out.println("step 2: " + uidl);
        UserStateSummaryView ussv = new UserStateSummaryView(uidl, counter.incrementAndGet() + String.format(template, uid));
        System.out.println("step 3: updating the tempmodel state");
        tempmodel.setChoice((int) (uidl + 100));
        System.out.println("tempmodel :" + tempmodel + "      lastchoice=" + tempmodel.lastChoice());
        System.out.println("step 4: ussv=" + ussv);

        System.out.println("step 5: updating the this.model1 state");
        this.model1.setChoice((int) (uidl + 100));
        System.out.println("this.model1 :" + this.model1 + "      lastchoice=" + this.model1.lastChoice());

        return ussv;
    }
}
