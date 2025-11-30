package com.moodtrack.api.service;

import com.moodtrack.api.dto.HabitoRequestDto;
import com.moodtrack.api.dto.HabitoResponseDto;
import com.moodtrack.api.model.Habito;

import java.util.List;

public interface IHabitoService {

    Habito crearHabito(HabitoRequestDto requestDto);

    List<HabitoResponseDto> obtenerTodosLosHabitos();
}