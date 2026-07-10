package com.training.ott.service.impl;

import com.training.ott.model.Subscription;
import com.training.ott.repository.SubscriptionRepository;
import com.training.ott.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return repository.save(subscription);
    }

    @Override
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void cancelSubscription(Long id) {
        repository.deleteById(id);
    }
}
