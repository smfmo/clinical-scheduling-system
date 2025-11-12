package com.agendamento.agendaconsultas.controller;

import com.agendamento.agendaconsultas.model.Doctor;
import com.agendamento.agendaconsultas.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public String form(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor-form";
    }

    @PostMapping
    public String registerDoctor(@ModelAttribute(name = "doctor") Doctor doctor) {
        service.registerDoctor(doctor);
        return "redirect/inicio";
    }

    @GetMapping("/{doctorId}")
    public String getDoctor(@PathVariable(name = "doctorId") UUID doctorId, Model model) {
        Doctor doctor = service.getById(doctorId);
        model.addAttribute("doctor", doctor);
        return "doctor-information";
    }

    @GetMapping("/deleteDoctor/{doctorId}")
    public String deleteDoctor(@PathVariable(name = "doctorId") UUID doctorId) {
        service.deleteDoctor(doctorId);
        return "redirect/inicio";
    }
}
