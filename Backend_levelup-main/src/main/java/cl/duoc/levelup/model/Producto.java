package cl.duoc.levelup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "producto", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombre")
})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "La categoría es obligatoria")
    @Column(length = 50, nullable = false)
    private String categoria;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Column(length = 50, unique = true, nullable = false)
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 200, message = "La descripción debe tener entre 10 y 200 caracteres")
    @Column(length = 200, nullable = false)
    private String descripcion;

    @NotBlank(message = "La URL de la imagen es obligatoria")
    @Pattern(regexp = "^/img/.*\\.(jpg|jpeg|png|webp|gif)$",
            message = "La URL debe empezar con /img/ y terminar en .jpg, .jpeg, .png, .webp o .gif")
    @Column(length = 50, nullable = false)
    private String imgUrl;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    @Max(value = 999999999, message = "El precio es demasiado alto")
    @Column(nullable = false)
    private Integer precio;
}