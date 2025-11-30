package com.moodtrack.api.service.impl;

import com.moodtrack.api.dto.HabitoRequestDto;
import com.moodtrack.api.dto.HabitoResponseDto;
import com.moodtrack.api.mapper.HabitoMapper;
import com.moodtrack.api.model.Habito;
import com.moodtrack.api.repository.HabitoRepository;
import com.moodtrack.api.service.IHabitoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HabitoServiceImpl implements IHabitoService {

    private final HabitoRepository habitoRepository;
    private final HabitoMapper habitoMapper;

    public HabitoServiceImpl(HabitoRepository habitoRepository, HabitoMapper habitoMapper) {
        this.habitoRepository = habitoRepository;
        this.habitoMapper = habitoMapper;
    }

    @Override
    @Transactional
    public Habito crearHabito(HabitoRequestDto requestDto) {
        Habito habito = habitoMapper.toEntity(requestDto);
        return habitoRepository.save(habito);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HabitoResponseDto> obtenerTodosLosHabitos() {
        List<Habito> habitos = habitoRepository.findAll();
        return habitoMapper.toResponseDtoList(habitos);
    }
}