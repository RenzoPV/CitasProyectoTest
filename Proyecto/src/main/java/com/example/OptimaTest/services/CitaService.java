package com.example.OptimaTest.services;

import com.example.OptimaTest.entities.Cita;
import com.example.OptimaTest.entities.EstadoCita;
import com.example.OptimaTest.entities.Rol;
import com.example.OptimaTest.entities.Usuario;
import com.example.OptimaTest.repositories.CitaRepository;
import com.example.OptimaTest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Cita crearCita(Cita cita) {
        cita.setEstado(EstadoCita.PENDIENTE);
        cita.setFechaCita(LocalDateTime.now());
        return citaRepository.save(cita);
    }

    public Cita asignarCita(Long citaId, Long administradorId, Long agenteId) {
        Usuario administrador = usuarioRepository.findById(administradorId)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        if (!administrador.getRol().equals(Rol.ADMINISTRADOR)) {
            throw new RuntimeException("Solo un administrador puede asignar citas");
        }

        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        if (cita.getEstado() == EstadoCita.ASIGNADA) {
            throw new RuntimeException("La cita ya está asignada");
        }

        Usuario agente = usuarioRepository.findById(agenteId)
                .orElseThrow(() -> new RuntimeException("Agente no encontrado"));

        cita.setEstado(EstadoCita.ASIGNADA);
        cita.setFechaAsignacion(LocalDateTime.now());
        cita.setAgenteAsignado(agente);
        return citaRepository.save(cita);
    }

    public Cita completarCita(Long citaId) {
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstado(EstadoCita.COMPLETADA);
        cita.setFechaCerrado(LocalDateTime.now());
        return citaRepository.save(cita);
    }

    public Cita reabrirCita(Long citaId) {
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstado(EstadoCita.REABIERTA);
        cita.setFechaCerrado(null);
        return citaRepository.save(cita);
    }
}
