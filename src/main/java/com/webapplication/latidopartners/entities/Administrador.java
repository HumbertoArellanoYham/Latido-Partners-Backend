package com.webapplication.latidopartners.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@ToString
@Entity
@Table(name = "administrador", schema = "public")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_admin", nullable = false)
    private Long idAdmin;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private String nombre;
}
