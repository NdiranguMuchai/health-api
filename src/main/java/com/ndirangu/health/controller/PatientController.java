package com.ndirangu.health.controller;

import com.ndirangu.health.model.Patient;
import com.ndirangu.health.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping({"/", "","/list"})
    public @ResponseBody Page<Patient> list(Pageable pageable){
        return patientService.list(pageable);
    }
    @GetMapping("/{id}")
    public @ResponseBody Optional<Patient>findOne(@PathVariable UUID id) throws Exception{
        patientService.findOne(id).orElseThrow(()-> new Exception("patient with id "+id+" not found"));
        return patientService.findOne(id);
    }
    @PostMapping("/create")
    public @ResponseBody UUID create(@RequestBody Patient patient){
        return patientService.create(patient);
    }
    @PutMapping("/{id}")
    public @ResponseBody UUID update(@RequestBody Patient patient, @PathVariable UUID id) throws Exception{
        patientService.findOne(id).orElseThrow(()-> new Exception("patient with id "+id+" not found"));
        patient.setId(id);
        return patientService.update(patient);

    }
}
