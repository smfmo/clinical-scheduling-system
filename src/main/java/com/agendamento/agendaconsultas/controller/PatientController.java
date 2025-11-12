package com.agendamento.agendaconsultas.controller;

import com.agendamento.agendaconsultas.model.Patient;
import com.agendamento.agendaconsultas.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public String form(Model model) {
        model.addAttribute("patient",  new Patient());
        return "patient-form";
    }

    @PostMapping
    public String registerPatient(@ModelAttribute(name = "patient") Patient patient) {
        service.registerPatient(patient);
        return "redirect:/consultations";
    }

    @GetMapping("/{patientId}")
    public String getPatient(@PathVariable(name = "patientId") UUID patientId, Model model) {
        Patient patient = service.findById(patientId);
        model.addAttribute("patient", patient);
        return "patient-form";
    }

    public String deletePatient(@PathVariable(name = "patientId") UUID patientId) {
        service.deletePatient(patientId);
        return "redirect:/inicio";
    }
}
