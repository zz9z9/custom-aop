package springbasic.customaop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springbasic.customaop.member.MemberService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Controller
public class TestController {

    private MemberService service;

    public TestController(InvocationHandler handler) {
        //         /*
        //         * Look up or generate the designated proxy class and its constructor.
        //         */
        //        Constructor<?> cons = getProxyConstructor(caller, loader, interfaces);
        // cons.newInstance(new Object[]{h});
        this.service = (MemberService) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] { MemberService.class },
                handler);
    }

    @GetMapping("save")
    public String hello(Model model) {
        service.save();
        model.addAttribute("data", "save");
        return "hello";
    }

    @GetMapping("find")
    public String find(Model model) {
        service.find();
        model.addAttribute("data", "find");
        return "hello";
    }
}

