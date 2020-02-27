package com.ndirangu.health.service.impl;

import com.ndirangu.health.model.Patient;
import com.ndirangu.health.repository.PatientRepository;
import com.ndirangu.health.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public UUID create(Patient patient) {
        return patientRepository.save(patient).getId();
    }

    @Override
    public Page<Patient> list(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Optional<Patient> findOne(UUID id) throws Exception{
        patientRepository.findById(id).orElseThrow(()-> new Exception("Patient with id "+id+" not found"));
        return patientRepository.findById(id);
    }

    @Override
    public UUID update(Patient patient) throws Exception{
        patientRepository.findById(patient.getId()).orElseThrow(()-> new Exception("Patient with id "+patient.getId()+" not found"));
        return null;
    }
}
