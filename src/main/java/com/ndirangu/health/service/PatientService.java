package com.ndirangu.health.service;

import com.ndirangu.health.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface PatientService {
    UUID create(Patient patient);
    Page<Patient>list(Pageable pageable);
    Optional<Patient> findOne(UUID id) throws Exception;
    UUID update(Patient patient) throws Exception;
}
