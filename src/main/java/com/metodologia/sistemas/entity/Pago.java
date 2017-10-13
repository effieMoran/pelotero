package com.metodologia.sistemas.entity;

import com.metodologia.sistemas.enums.MedioDePago;
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
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@ApiModel(value = "Pago", description = "Pago")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Pago {

    @Getter
    @Setter
    private double monto;

    @Getter
    @Setter
    private MedioDePago medioDePago;

    @Getter
    @Setter
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.MERGE )
    @ElementCollection(targetClass=LineaBebida.class)
    private Set<LineaBebida> lineaBebidas;

    @Getter
    @Setter
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.MERGE )
    @ElementCollection(targetClass=Fiesta.class)
    private Set<Fiesta> fiesta;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date fecha;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "pago_id")
    private int id;
}
