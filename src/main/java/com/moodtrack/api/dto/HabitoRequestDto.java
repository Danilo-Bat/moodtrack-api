package com.moodtrack.api.dto;

import com.moodtrack.api.model.NivelDeImportanciaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitoRequestDto {

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 3, max = 255, message = "La descripcion debe tener entre 3 y 255 caracteres")
    private String descripcion;

    @NotNull(message = "El nivel de importancia es obligatorio")
    private NivelDeImportanciaEnum nivelImportancia;
}