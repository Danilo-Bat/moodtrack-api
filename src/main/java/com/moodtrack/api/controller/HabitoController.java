package com.moodtrack.api.controller;

import com.moodtrack.api.dto.HabitoRequestDto;
import com.moodtrack.api.dto.HabitoResponseDto;
import com.moodtrack.api.model.Habito;
import com.moodtrack.api.service.IHabitoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habitos")
public class HabitoController {

    private final IHabitoService habitoService;

    public HabitoController(IHabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @PostMapping
    public ResponseEntity<Habito> crearHabito(@Valid @RequestBody HabitoRequestDto requestDto) {
        Habito habitoCreado = habitoService.crearHabito(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(habitoCreado);
    }

    @GetMapping
    public ResponseEntity<List<HabitoResponseDto>> obtenerTodosLosHabitos() {
        List<HabitoResponseDto> habitos = habitoService.obtenerTodosLosHabitos();
        return ResponseEntity.ok(habitos);
    }
}