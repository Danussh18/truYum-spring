package com.cognizant.truYumspring.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @Column(name = "me_id")
    private int id;

    @Column(name = "me_name")
    private String name;

    @Column(name = "me_price", columnDefinition = "DECIMAL(8,2)")
    private double price;

    @Column(name = "me_active")
    private String active;

    @Column(name = "me_date_of_launch")
    private Date date_of_launch;

    @Column(name = "me_category")
    private String category;

    @Column(name = "me_free_delivery")
    private String free_delivery;

}
