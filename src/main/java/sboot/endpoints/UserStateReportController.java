package sboot.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sboot.GameInstance;
import sboot.TimestampProvider;
import sboot.UserState;
import sboot.endpoints.UserStateSummaryView;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/userfullstate")
public class UserStateReportController {

    private static final String template = "User Information and State: %s!";
    private final AtomicLong counter = new AtomicLong();
    //counter.incrementAndGet()

    @Resource
    /*
    Using "@Resource" by itself (without another bean) causes:
        Injection of resource dependencies failed;
        No qualifying bean of type [sboot.UserState] found for dependency:
        expected at least 1 bean which qualifies as autowire candidate
        for this dependency.
        Dependency annotations:
        {@javax.annotation.Resource(
           shareable=true, mappedName=, description=, name=, type=class java.lang.Object, lookup=, authenticationType=CONTAINER
           )}
     Solutions: To make the Bean using:
     1-Make a @Configuration class. (very flexible and customisable) (Uses @Bean in a method)
     2-define @Component when defining the class (1 instance only).
     */
    GameInstance model1; //Todo: rename to GameState

    UserStateReportController(){
    	System.out.println("UserStateReportController constructor called");
    	//this.model1 = new UserState();
    }

    @Resource
    public TimestampProvider timer;

    @RequestMapping(method = RequestMethod.GET) //Just narrows the http operations! (GET,PUT,POST)
    //It is important!
    //@RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody UserState //UserStateSummaryView
    method_name_does_not_matter(
            //@RequestParam(value="uid", required=false, defaultValue=model.getTheOnlyUser())
            //@RequestParam(value="uid", required=false, defaultValue="-1")
            @RequestParam(value="uid", required=true)
                Long uid //todo: long
          //  ,
          //  //Model model
          //  UserState tempmodel  //Constructed each time. Then what's the point? #Q
    ) {
        System.out.println("---------------------"+this.timer);

        //gameobj
        //gameobj.getUserState(uid).getSummary();
        System.out.println("value received: "+uid);
        long uidl=Long.valueOf(uid+"");
        //System.out.println("(model arg: temporary) :" + tempmodel + "      lastchoice="+tempmodel.lastChoice());
        System.out.println("step 2: " + uidl);
        //UserStateSummaryView ussv = new UserStateSummaryView(uidl, counter.incrementAndGet() + String.format(template, uid));
        //System.out.println("step 3: updating the tempmodel state");
        //tempmodel.setChoice((int) (uidl + 100));
        //System.out.println("tempmodel :" + tempmodel + "      lastchoice=" + tempmodel.lastChoice());
        //System.out.println("step 4: ussv=" + ussv);

        System.out.println("step 5: updating the this.model1 state");
        //this.model1.getUserState(uidl).setChoice((int) (uidl + 100));
        //this.model1.getUserState(uidl).setChoice( this.model1.getUserState(uidl).getChoice());
        UserState us = this.model1.getUserState(uidl);
        /*
        us.setChoice(us.lastChoice() + 1, null); //todo: null is bad
        */
        //System.out.println("this.model1 :" + this.model1 + "      lastchoice=" + this.model1.lastChoice());
        System.out.println("this.model1 :" + this.model1 + "      lastchoice=" + us.lastChoice());

        //return ussv;
        //return "Don't use this";
        return this.model1.getPlayer(uid);
    }
}
