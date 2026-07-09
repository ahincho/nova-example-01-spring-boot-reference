package pe.edu.nova.java.examples.dto;

import pe.edu.nova.java.libs.mask.utils.annotation.SkipMasking;

/**
 * DTO de ejemplo con datos sensibles. Los campos cuyo nombre coincide con
 * patrones conocidos (email, telefono, dni, tarjeta, etc.) se enmascaran
 * automáticamente por el framework — sin necesidad de anotaciones.
 */
public class ClienteDto {

    private String nombre;
    private String email;
    private String telefono;
    private String dni;
    private String tarjeta;

    /** Constructor por defecto. */
    public ClienteDto() {}

    /**
     * Crea un nuevo DTO de cliente.
     *
     * @param nombre   nombre del cliente
     * @param email    correo electrónico
     * @param telefono número de teléfono
     * @param dni      documento de identidad
     * @param tarjeta  número de tarjeta de crédito
     */
    public ClienteDto(String nombre, String email, String telefono, String dni, String tarjeta) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.tarjeta = tarjeta;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getTarjeta() { return tarjeta; }
    public void setTarjeta(String tarjeta) { this.tarjeta = tarjeta; }
}
