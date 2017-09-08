package com.metodologia.sistemas.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel(value = "Cliente", description = "Datos de los clientes del pelotero")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Cliente {

    @ApiModelProperty(name = "Nombre", value = "Nombre de pila", required = true, example = "Aegon" )
    @Getter
    @Setter
    private String nombre;

    @ApiModelProperty(name = "Apellido", value = "Apellido", required = true, example = "Targaryen")
    @Getter
    @Setter
    private String apellido;

    @ApiModelProperty(name = "Telefono fijo",value = "Telefono fijo", required = false, example = "362-4409088")
    @Getter
    @Setter
    private String telefono;

    @ApiModelProperty(name = "Direccion",value = "Direccion", required = false)
    @Getter
    @Setter
    private String direccion;

    @ApiModelProperty(name = "email",value = "email", required = false)
    @Getter
    @Setter
    private String email;

    @ApiModelProperty(name = "CUIL/CUIT",value = "CUIL/CUIT", required = false, example = "19-12345678-4")
    @Getter
    @Setter
    private String CUIL;

    @ApiModelProperty(name = "Celular", value = "Telefono celular", required = false,  example = "397-4567589")
    @Getter
    @Setter
    private String celular;

    @ApiModelProperty(name = "Otra info",value = "Otra informacion relevante", required = false, example = "Tiene 10% de descuento por que sale en Game of Thrones")
    @Getter
    @Setter
    private String otraInformacion;

    @ApiModelProperty(name = "ID Cliente", value = "ID del cliente", required = false)
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;


}
