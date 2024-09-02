package com.minibank.loans.infrastructure.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        // Fetch the currently authenticated user
        // For example, using Spring Security:
        //return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName()).or(()->Optional.of("system"));
        return Optional.of(1L);
    }
}
