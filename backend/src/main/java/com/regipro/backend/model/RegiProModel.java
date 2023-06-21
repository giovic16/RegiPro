package com.regipro.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios", schema = "regipro")
@Data
public class RegiProModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String profissao;
}
