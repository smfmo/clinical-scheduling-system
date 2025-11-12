package com.agendamento.agendaconsultas.controller;

import com.agendamento.agendaconsultas.model.Consultation;
import com.agendamento.agendaconsultas.model.enums.Specialty;
import com.agendamento.agendaconsultas.service.ConsultationService;
import com.agendamento.agendaconsultas.service.DoctorService;
import com.agendamento.agendaconsultas.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public ConsultationController(ConsultationService consultationService,
                                  DoctorService doctorService, PatientService patientService) {
        this.consultationService = consultationService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping
    public String form(Model model, @RequestParam(required = false) Specialty speciality) {
        model.addAttribute("consultation", new Consultation());
        model.addAttribute("specialities", Specialty.values());
        model.addAttribute("patients", patientService.findAll());

        if (speciality != null) {
            model.addAttribute("doctors", doctorService.findDoctorBySpeciality(speciality));
        }
        else {
            model.addAttribute("doctors", doctorService.findAll());
        }
        return "consultation-form";
    }

    @PostMapping
    public String createConsultation(@ModelAttribute(name = "consultation") Consultation consultation) {
        consultationService.create(consultation);
        return "redirect:/inicio";
    }

    @GetMapping("/{consultationId}")
    public String getConsultation(@PathVariable(name = "consultationId") UUID consultationId, Model model) {
        Consultation consultation = consultationService.getById(consultationId);
        model.addAttribute("consultation", consultation);
        return "information-consultation";
    }

    @GetMapping("/deleteConsultation/{consultationId}")
    public String deleteConsultation(@PathVariable(name = "consultationId") UUID consultationId) {
        consultationService.deleteConsultation(consultationId);
        return "redirect/inicio";
    }
}
