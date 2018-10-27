package com.github.pavelhe.model;

import javax.persistence.*;

import lombok.*;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
