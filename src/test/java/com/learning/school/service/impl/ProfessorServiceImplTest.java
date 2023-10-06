package com.learning.school.service.impl;

import com.learning.school.dto.ProfessorRequestDTO;
import com.learning.school.dto.ProfessorResponseDTO;
import com.learning.school.exception.ProfessorNotFoundException;
import com.learning.school.mapper.ProfessorMapper;
import com.learning.school.model.Professor;
import com.learning.school.repository.ProfessorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProfessorServiceImplTest {

    private ProfessorMapper mapper = mock(ProfessorMapper.class);
    private ProfessorRepository repository = mock(ProfessorRepository.class);
    private ProfessorServiceImpl service = new ProfessorServiceImpl(mapper, repository);

    @DisplayName(
            "when findALL is called, " +
                    "then returns a list of response")
    @Test
    void findAllTest() {
        // given
        var professorList = List.of(
                mock(Professor.class),
                mock(Professor.class)
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

        when(repository.findAll())
                .thenReturn(professorList);
        when(mapper.toDTO(professorList))
                .thenReturn(expectedResponse);

        // when
        var actualResponse = service.findAll();

        // then
        assertEquals(expectedResponse, actualResponse);
    }

    @DisplayName(
            "given a valid UUID " +
                    "when findById is called, " +
                    "then returns a response")
    @Test
    void findByIdTest() {
        // given
        var id = UUID.randomUUID();

        var professor = mock(Professor.class);
        var professorOptional = Optional.of(professor);

        var response =
                new ProfessorResponseDTO(
                        UUID.randomUUID().toString(),
                        "some name 1",
                        "some email 1");
        var expectedResponse = Optional.of(response);


        when(repository.findById(id))
                .thenReturn(professorOptional);
        when(mapper.toDTO(professor))
                .thenReturn(response);

        // when
        var actualResponse = service.findById(id.toString());

        // then
        assertEquals(expectedResponse, actualResponse);
        verify(repository, times(1))
                .findById(id);
        verify(repository, atMostOnce())
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
        verify(repository, times(0))
                .findById(any());
        verify(repository, never())
                .findById(any());
    }

    @DisplayName(
            "given a request " +
                    "when save is called, " +
                    "then the Professor is inserted")
    @Test
    void saveTest() {
        // given
        var request = mock(ProfessorRequestDTO.class);
        var idCaptor = ArgumentCaptor.forClass(UUID.class);
        var professor = mock(Professor.class);
        var expected = mock(ProfessorResponseDTO.class);

        when(mapper.toModel(any(UUID.class), eq(request)))
                .thenReturn(professor);
        when(repository.save(professor))
                .thenReturn(professor);
        when(mapper.toDTO(professor))
                .thenReturn(expected);

        // when
        var actual = service.save(request);

        // then
        verify(mapper).toModel(idCaptor.capture(), eq(request));
        assertNotNull(idCaptor.getValue());
        assertEquals(expected, actual);
        verify(repository, times(1))
                .save(professor);
    }

    @DisplayName(
            "given an id does not exist and a request " +
                    "when update is called, " +
                    "then an exception is threw")
    @Test
    void updateProfessorNotFoundTest() throws ProfessorNotFoundException {
        // given
        var id = UUID.randomUUID();
        var request = mock(ProfessorRequestDTO.class);
        var professor = mock(Professor.class);

        when(mapper.toModel(any(UUID.class), eq(request)))
                .thenReturn(professor);
        when(repository.update(professor))
                .thenThrow(new ProfessorNotFoundException());

        // when
        // then
        Assertions.assertThrows(ProfessorNotFoundException.class,
                () ->  service.update(id.toString(), request));
    }
}