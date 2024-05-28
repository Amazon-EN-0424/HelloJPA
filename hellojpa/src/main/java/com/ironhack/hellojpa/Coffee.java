package com.ironhack.hellojpa;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@Entity // this annotation is needed to make this map to a table
@Table(name = "coffees") // we can specify the name of the table
@ToString
public class Coffee {

    @Id // in order to declare the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // it enables something like auto increment
    private Integer id;

    @Column(name = "coffee_name") // we can specify the name of the column
    private String name;
    private String origin;

    public Coffee(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }
}
