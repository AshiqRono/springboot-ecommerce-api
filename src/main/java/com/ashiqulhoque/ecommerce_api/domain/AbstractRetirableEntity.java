package com.ashiqulhoque.ecommerce_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractRetirableEntity extends AbstractAuditingEntity{

    @Column(name = "retired_date")
    protected LocalDateTime retiredDate = null;
}
