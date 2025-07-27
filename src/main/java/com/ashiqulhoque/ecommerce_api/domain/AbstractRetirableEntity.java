package com.ashiqulhoque.ecommerce_api.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractRetirableEntity extends AbstractAuditingEntity{

    protected LocalDateTime retired_date = null;
}
