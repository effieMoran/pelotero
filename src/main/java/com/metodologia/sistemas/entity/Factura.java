package com.metodologia.sistemas.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Date;
import java.util.Set;

@ApiModel(value = "Factura", description = "Factura detallada")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Factura {

    @ApiModelProperty(name = "id", value = "identificador", required = false, example = "4" )
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private int id;

    @Getter
    @Setter
    private Date fecha;

    @Getter
    @Setter
    private double total;

    @Getter
    @Setter
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="cliente_fk", nullable = true)
    private Cliente cliente;

    @Setter
    @Getter
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="fiesta_fk", nullable = true)
    private Fiesta fiesta;

    @Getter
    @Setter
    @OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.MERGE )
    @ElementCollection(targetClass=LineaDeFactura.class)
    private Set<LineaDeFactura> lineaDeFacturaSet;

}
