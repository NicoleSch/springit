package com.vega.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String body;

    @ManyToOne
    private Link link;
}
