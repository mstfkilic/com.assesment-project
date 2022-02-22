package com.mustafakilic.entities.concretes;

import lombok.*;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String model;
    @NotNull
    @NotBlank
    private String brand;
    @NotNull
    @NotBlank
    private String os;
    @NotNull
    @NotBlank
    private String osVersion;
}
