package com.business.demo.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Sale {

    @SequenceGenerator(
            name = "sale_sequence",
            sequenceName = "sale_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sale_sequence"
    )
    private String id;
 /*   @OneToMany
    private Client client;
    @OneToMany
    private Employee employee;*/
    //private List<Product> products;
    private Double price;
}
