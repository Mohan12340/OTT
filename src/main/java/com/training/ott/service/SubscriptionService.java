package com.training.ott.service;

import com.training.ott.model.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);

    List<Subscription> getSubscriptionsByUser(Long userId);

    void cancelSubscription(Long id);

}
