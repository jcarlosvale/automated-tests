package com.learning.school.mapper;

import com.learning.school.dto.ProfessorRequestDTO;
import com.learning.school.dto.ProfessorResponseDTO;
import com.learning.school.model.Professor;

import java.util.List;
import java.util.UUID;

public interface ProfessorMapper {

    Professor toModel(UUID id, ProfessorRequestDTO professorRequestDTO);
    List<ProfessorResponseDTO> toDTO(List<Professor> professorList);
    ProfessorResponseDTO toDTO(Professor professor);


}
