package com.metodologia.sistemas.entity;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel(value = "Item", description = "Item")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Item {

    @Getter
    @Setter
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Item_id")
    private int id;

}
