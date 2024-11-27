package com.webapplication.latidopartners.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
@ToString
@Entity
@Table(name = "resultado", schema = "public")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Long idRespuesta;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_partners", referencedColumnName = "id_partners", nullable = false)
    private Partners partner;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cuestionario_id", referencedColumnName = "id_cuestionario", nullable = false)
    private Cuestionario cuestionario;

    @Column(nullable = false)
    private Float calificacion;

    @Column(nullable = false)
    private LocalDate fecha;
}
