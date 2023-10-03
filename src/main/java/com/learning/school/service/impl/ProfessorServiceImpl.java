package com.learning.school.service.impl;

import com.learning.school.dto.ProfessorRequestDTO;
import com.learning.school.dto.ProfessorResponseDTO;
import com.learning.school.exception.ProfessorNotFoundException;
import com.learning.school.mapper.ProfessorMapper;
import com.learning.school.repository.ProfessorRepository;
import com.learning.school.service.ProfessorService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorMapper mapper;
    private final ProfessorRepository repository;

    public ProfessorServiceImpl(ProfessorMapper mapper, ProfessorRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<ProfessorResponseDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public Optional<ProfessorResponseDTO> findById(final String professorId) {
        Objects.requireNonNull(professorId, "professorId should not be null");
        var professorOptional = repository.findById(UUID.fromString(professorId));
        return professorOptional.map(mapper::toDTO);
    }

    @Override
    public ProfessorResponseDTO save(final ProfessorRequestDTO professorRequestDTO) {
        Objects.requireNonNull(professorRequestDTO, "professorRequestDTO should not be null");
        var id = UUID.randomUUID();
        var response = repository.save(mapper.toModel(id, professorRequestDTO));
        return mapper.toDTO(response);
    }

    @Override
    public ProfessorResponseDTO update(final String professorId,
                                       final ProfessorRequestDTO professorRequestDTO) throws ProfessorNotFoundException {
        Objects.requireNonNull(professorId, "professorId should not be null");
        Objects.requireNonNull(professorRequestDTO, "professorRequestDTO should not be null");
        var id = UUID.fromString(professorId);
        var response = repository.update(mapper.toModel(id, professorRequestDTO));
        return mapper.toDTO(response);
    }

    @Override
    public void delete(final String professorId) {
        Objects.requireNonNull(professorId, "professorId should not be null");
        var id = UUID.fromString(professorId);
        repository.delete(id);
    }
}
