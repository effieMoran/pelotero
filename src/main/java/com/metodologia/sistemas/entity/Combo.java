package com.metodologia.sistemas.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@ApiModel(value = "Combo", description = "Combo")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Combo {

    @Getter
    @Setter
    private double precio;

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "combo_id")
    private int id;

    @Setter
    @Getter
    @OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL )
    @ElementCollection(targetClass=Item.class)
    private Set<Item> items;

}
