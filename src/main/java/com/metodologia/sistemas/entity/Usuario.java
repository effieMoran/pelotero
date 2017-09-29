package com.metodologia.sistemas.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
import javax.persistence.Table;
import javax.persistence.Transient;

@ApiModel(value = "Usuario", description = "Pass y nickname de los usuarios")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "usuario")
public class Usuario {

    @ApiModelProperty(name = "Nombre de usuario", value = "Nombre de usuario")
    @Getter
    @Setter
    private String username;

    @ApiModelProperty(name = "Contrasena", value = "Contrasena")
    @Getter
    @Setter
    //@Transient
    private String password;

    @ApiModelProperty(name = "ID Usuario", value = "ID del usuario")
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "usuario_id")
    private int id;
}
