package com.github.pavelhe.model;

import javax.persistence.*;

import lombok.*;

@Entity
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
    private String name;
}
