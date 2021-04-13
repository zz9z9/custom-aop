package springbasic.customaop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springbasic.customaop.member.MemberService;

@Controller
public class TestController {

    private MemberService service;

    public TestController(@Qualifier("dependencyInjectionVer") MemberService service) {
        this.service = service;
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
