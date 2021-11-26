package org.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView modelAndView() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("controllerVariable", "Model and view usage");
        return view;
    }

    @GetMapping("/model")
    public String model(Model model) {
        model.addAttribute("controllerVariable", "Just model usage");
        return "index";
    }

    @GetMapping("/map")
    public String map(Map<String, Object> model) {
        model.put("controllerVariable", "Map usage");
        return "index";
    }
}
