package com.test.amazons.web;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller ("amazonsUI") public class  UI {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index", ImmutableMap.of("width", 6, "height", 6)); // todo enquire for game size
    }
}
