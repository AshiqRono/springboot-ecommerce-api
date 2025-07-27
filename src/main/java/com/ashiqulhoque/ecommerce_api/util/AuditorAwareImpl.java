package com.ashiqulhoque.ecommerce_api.util;

import jakarta.annotation.Nonnull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    @Nonnull
    public Optional<String> getCurrentAuditor() {
        // this can return the username from the security context when available
        // otherwise this will return the fixed string for all createdBy and modifiedBy fields
        return Optional.of("system");
    }
}
