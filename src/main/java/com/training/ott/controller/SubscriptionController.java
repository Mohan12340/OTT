package com.training.ott.controller;

import com.training.ott.model.Subscription;
import com.training.ott.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return service.createSubscription(subscription);
    }

    @GetMapping("/user/{userId}")
    public List<Subscription> getSubscriptions(@PathVariable Long userId) {
        return service.getSubscriptionsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public String cancelSubscription(@PathVariable Long id) {

        service.cancelSubscription(id);

        return "Subscription Cancelled Successfully";
    }

}
