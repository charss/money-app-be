package com.example.moneyapp.config.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
