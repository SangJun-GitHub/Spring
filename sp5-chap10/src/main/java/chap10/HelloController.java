package chap10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Sang Jun Park on 03/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model,
                        @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("greeting", "hello, " + name);
        return "hello";
    }
}
