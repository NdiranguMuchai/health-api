package com.ndirangu.health.controller;

import com.ndirangu.health.model.Patient;
import com.ndirangu.health.service.PatientService;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
@Api(tags = {"Patient"})
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation(value = "Returns a list of all patients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping({"/", "","/list"})
    public @ResponseBody Page<Patient> list(Pageable pageable){
        return patientService.list(pageable);
    }

    @ApiOperation(value = "Returns  a single patient by id")
    @GetMapping("/{id}")
    public @ResponseBody Optional<Patient>findOne(@PathVariable UUID id) throws Exception{
        patientService.findOne(id).orElseThrow(()-> new Exception("patient with id "+id+" not found"));
        return patientService.findOne(id);
    }

    @ApiOperation(value = "Creates a new patient")
    @PostMapping("/create")
    public @ResponseBody UUID create(
            @ApiParam(value = "Patient object store in database table", required = true)
            @RequestBody Patient patient){
        return patientService.create(patient);
    }

    @ApiOperation(value = "updates a patient given their id")
    @PutMapping("/{id}")
    public @ResponseBody UUID update(@RequestBody Patient patient, @PathVariable UUID id) throws Exception{
        patientService.findOne(id).orElseThrow(()-> new Exception("patient with id "+id+" not found"));
        patient.setId(id);
        return patientService.update(patient);

    }
}
