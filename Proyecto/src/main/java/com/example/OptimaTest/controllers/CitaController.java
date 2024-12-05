package com.example.OptimaTest.controllers;

import com.example.OptimaTest.entities.Cita;
import com.example.OptimaTest.entities.Usuario;
import com.example.OptimaTest.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.crearCita(cita));
    }

    @PutMapping("/{citaId}/asignar")
    public ResponseEntity<Cita> asignarCita(@PathVariable Long citaId, @RequestParam Long administradorId, @RequestParam Long agenteId) {
        return ResponseEntity.ok(citaService.asignarCita(citaId, administradorId, agenteId));
    }


    @PutMapping("/{citaId}/completar")
    public ResponseEntity<Cita> completarCita(@PathVariable Long citaId) {
        return ResponseEntity.ok(citaService.completarCita(citaId));
    }

    @PutMapping("/{citaId}/reabrir")
    public ResponseEntity<Cita> reabrirCita(@PathVariable Long citaId) {
        return ResponseEntity.ok(citaService.reabrirCita(citaId));
    }
}
