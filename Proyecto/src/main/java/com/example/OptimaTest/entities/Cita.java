package com.example.OptimaTest.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String proyecto;
    private LocalDateTime fechaCita;
    private LocalDateTime fechaAsignacion;
    private LocalDateTime fechaCerrado;
    @ManyToOne
    private Usuario agenteAsignado;
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDateTime getFechaCerrado() {
        return fechaCerrado;
    }

    public void setFechaCerrado(LocalDateTime fechaCerrado) {
        this.fechaCerrado = fechaCerrado;
    }

    public Usuario getAgenteAsignado() {
        return agenteAsignado;
    }

    public void setAgenteAsignado(Usuario agenteAsignado) {
        this.agenteAsignado = agenteAsignado;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
}
