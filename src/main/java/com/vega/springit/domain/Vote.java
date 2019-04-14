package com.vega.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Vote extends Auditable {

    @Id
    @GeneratedValue
    private Long id;
    private int vote;

    // user
    // link

}
