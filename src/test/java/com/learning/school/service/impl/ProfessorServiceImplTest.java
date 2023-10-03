package com.learning.school.service.impl;

import com.learning.school.mapper.ProfessorMapper;
import com.learning.school.repository.ProfessorRepository;
import org.mockito.Mockito;

class ProfessorServiceImplTest {

    private ProfessorMapper mapper = Mockito.mock(ProfessorMapper.class);
    private ProfessorRepository repository = Mockito.mock(ProfessorRepository.class);
    private ProfessorServiceImpl service = new ProfessorServiceImpl(mapper, repository);

}