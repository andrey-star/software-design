package com.andreystar.esourcing.controller;

import com.andreystar.esourcing.service.TurnstileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnstile")
public class TurnstileController {

    private final TurnstileService turnstileService;

    public TurnstileController(TurnstileService turnstileService) {
        this.turnstileService = turnstileService;
    }

    @PostMapping("/in/{id}")
    public void in(@PathVariable int id) {
        turnstileService.letIn(id);
    }

    @PostMapping("/out/{id}")
    public void out(@PathVariable int id) {
        turnstileService.letOut(id);
    }

}
