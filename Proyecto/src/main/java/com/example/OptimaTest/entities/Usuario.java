package com.example.OptimaTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El correo electrónico debe ser válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 4, message = "La contraseña debe tener al menos 8 caracteres")
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private boolean enabled = true;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Object getRol() {
        return this.rol;
    }

    public void setContrasena(String encode) {
        this.contrasena = encode;
    }

    public String getContrasena() {
        return contrasena;
    }
}