package boot.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartController {

    @GetMapping ("/smart/list")
    public String list(Model model){

        return "/smartshop/list";
    }

    @GetMapping("/smart/form")
    public String form(){

        return "/smartshop/smartForm";
    }
}
