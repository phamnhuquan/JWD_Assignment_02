package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    String message = "Phạm Quân !!!";
    @RequestMapping("/hello")
    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("Asasasas");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
}
