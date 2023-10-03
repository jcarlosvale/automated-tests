package com.learning.school.service;

import com.learning.school.dto.ProfessorRequestDTO;
import com.learning.school.dto.ProfessorResponseDTO;
import com.learning.school.exception.ProfessorNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    List<ProfessorResponseDTO> findAll();
    Optional<ProfessorResponseDTO> findById(String id);
    ProfessorResponseDTO save(ProfessorRequestDTO professorRequestDTO);
    ProfessorResponseDTO update(String id, ProfessorRequestDTO professorRequestDTO) throws ProfessorNotFoundException;
    void delete(String id);
}
