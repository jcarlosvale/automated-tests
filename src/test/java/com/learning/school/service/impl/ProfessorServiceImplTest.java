package com.learning.school.service.impl;

import com.learning.school.dto.ProfessorResponseDTO;
import com.learning.school.mapper.ProfessorMapper;
import com.learning.school.model.Professor;
import com.learning.school.repository.ProfessorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

class ProfessorServiceImplTest {

    private ProfessorMapper mapper = Mockito.mock(ProfessorMapper.class);
    private ProfessorRepository repository = Mockito.mock(ProfessorRepository.class);
    private ProfessorServiceImpl service = new ProfessorServiceImpl(mapper, repository);

    @DisplayName(
            "when findALL is called, " +
            "then returns a list of response")
    @Test
    void findAllTest() {
        // given
        var professorList = List.of(
                Mockito.mock(Professor.class),
                Mockito.mock(Professor.class)
        );
        var expectedResponse = List.of(
                new ProfessorResponseDTO(
                        UUID.randomUUID().toString(),
                        "some name 1",
                        "some email 1"
                ),
                new ProfessorResponseDTO(
                        UUID.randomUUID().toString(),
                        "some name 2",
                        "some email 2"
                )
        );

        Mockito.when(repository.findAll())
                .thenReturn(professorList);
        Mockito.when(mapper.toDTO(professorList))
                .thenReturn(expectedResponse);

        // when
        var actualResponse = service.findAll();

        // then
        Assertions.assertEquals(expectedResponse, actualResponse);
    }

    @DisplayName(
            "given a valid UUID " +
            "when findById is called, " +
            "then returns a response")
    @Test
    void findByIdTest() {
        // given
        var id = UUID.randomUUID();

        var professor = Mockito.mock(Professor.class);
        var professorOptional = Optional.of(professor);

        var response =
                new ProfessorResponseDTO(
                        UUID.randomUUID().toString(),
                        "some name 1",
                        "some email 1");
        var expectedResponse = Optional.of(response);


        Mockito.when(repository.findById(id))
                .thenReturn(professorOptional);
        Mockito.when(mapper.toDTO(professor))
                .thenReturn(response);

        // when
        var actualResponse = service.findById(id.toString());

        // then
        Assertions.assertEquals(expectedResponse, actualResponse);
        Mockito.verify(repository, Mockito.times(1))
                .findById(id);
        Mockito.verify(repository, Mockito.atMostOnce())
                .findById(id);
    }

    @DisplayName(
            "given an invalid UUID " +
            "when findById is called, " +
            "then throws an exception")
    @Test
    void findByIdFailsTest() {
        // given
        var id = "wrong value";

        // when
        // then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.findById(id)
        );

        // then
        Mockito.verify(repository, Mockito.times(0))
                .findById(Mockito.any());
        Mockito.verify(repository, Mockito.never())
                .findById(Mockito.any());
    }
}