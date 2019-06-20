package com.test.amazons.web;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

// TODO Everything

@RestController("amazonsAPI")
@RequestMapping("/api")
public class API {

    @GetMapping("/state")
    public Map<String,Object> state() {

        return new HashMap<>();
    }

    @PostMapping("/start")
    public String start(final @RequestParam int width,
                        final @RequestParam int height) {

        return "";
    }

    @PostMapping("/move")
    public String move(final @RequestParam int fromX, final @RequestParam int fromY,
                       final @RequestParam int toX,   final @RequestParam int toY) {

        return "";
    }

    @PostMapping("/reset")
    public String reset() {

        return "";
    }
}
