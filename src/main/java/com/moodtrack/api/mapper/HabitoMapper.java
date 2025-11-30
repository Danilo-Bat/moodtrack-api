package com.moodtrack.api.mapper;

import com.moodtrack.api.dto.HabitoRequestDto;
import com.moodtrack.api.dto.HabitoResponseDto;
import com.moodtrack.api.model.Habito;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HabitoMapper {

    public Habito toEntity(HabitoRequestDto dto) {
        Habito habito = new Habito();
        habito.setDescripcion(dto.getDescripcion());
        habito.setNivelImportancia(dto.getNivelImportancia());
        return habito;
    }

    public HabitoResponseDto toResponseDto(Habito habito) {
        return new HabitoResponseDto(habito.getId(), habito.getDescripcion());
    }

    public List<HabitoResponseDto> toResponseDtoList(List<Habito> habitos) {
        return habitos.stream()
                .map(this::toResponseDto)
                .toList();
    }
}