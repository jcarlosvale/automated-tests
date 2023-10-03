package com.learning.school.repository;

import com.learning.school.exception.ProfessorNotFoundException;
import com.learning.school.model.Professor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessorRepository {
    List<Professor> findAll();
    Optional<Professor> findById(UUID id);
    Professor save(Professor professor);
    Professor update(Professor professor) throws ProfessorNotFoundException;
    void delete(UUID id);
}
