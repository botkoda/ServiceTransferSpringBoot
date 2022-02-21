package com.botkoda.netology.demo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Amount {
    @Id
    @GeneratedValue
    @Column(name = "amount_id")
    private Long id;
    private int value;
    private String currency;


}
