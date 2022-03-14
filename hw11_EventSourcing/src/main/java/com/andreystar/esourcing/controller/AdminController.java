package com.andreystar.esourcing.controller;

import com.andreystar.esourcing.command.ClientCreationRequest;
import com.andreystar.esourcing.command.SubscriptionExtensionRequest;
import com.andreystar.esourcing.query.Subscription;
import com.andreystar.esourcing.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public int createClient(@RequestBody ClientCreationRequest clientCreationRequestCommand) {
        return adminService.registerClient(clientCreationRequestCommand);
    }

    @PostMapping("/extend")
    public void extendSubscription(@RequestBody SubscriptionExtensionRequest extCommand) {
        adminService.extendSubscription(extCommand);
    }

    @GetMapping("/subscription/{id}")
    public Subscription getSubscription(@PathVariable int id) {
        return adminService.getSubscription(id);
    }

}
