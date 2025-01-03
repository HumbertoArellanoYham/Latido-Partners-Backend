package com.webapplication.latidopartners.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cuestionario", schema = "public")
public class Cuestionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuestionario")
    private Long idCuestionario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Boolean activo;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "cuestionario", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    List<Pregunta> preguntasList;

    @JsonBackReference
    @OneToOne(mappedBy = "cuestionario")
    private Resultado resultado;
}
