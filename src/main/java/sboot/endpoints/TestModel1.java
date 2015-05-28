package sboot.endpoints;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import java.util.Map;
import org.springframework.ui.Model;

/**
 * Created by sohail on 18/05/15.
 */
@Controller
@RequestMapping("/mtest1") //If not specified, all URLs are redirected here
public class TestModel1 {
    //Why a "model" is a @Controller?

    //@Resource
    //GameInstance gameModel;
    private static final Log log = LogFactory.getLog(ChooseOnPushButtonController.class);

    TestModel1(){
        log.info("TestModel1 constructor called");
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    //@ResponseBody //If this is removed, then
    //Circular view path [x]: would dispatch back to the current handler URL [/x] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
    String
    do1
    (
          //  //@RequestParam(value="uid", required=true)
          //  Map<String, Long> model
          //  //Understanding:
          //  //   the model is actually an output. It constitutes the "request" (GET/POST) to the page x, where String x is returned.
          Model model
            )
    {
        log.info("map instance used: " + model + "model.hashCode()=" + model.hashCode());
        int i=(int)(Math.random()*1000);
        //model.put("k"+i,"vv"+i);
        //model.put("uid",new Long(i));
        model.addAttribute("uid",new Long(i));
        log.info(">>> " + model + "model.hashCode()="+model.hashCode());
        return "/userfullstate";



    }
}


