package com.roisimulator.controller;

import com.roisimulator.model.Scenario;
import com.roisimulator.repository.ScenarioRepository;
import com.roisimulator.service.ROICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ROIController {

    @Autowired
    private ROICalculatorService roiService;

    @Autowired
    private ScenarioRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        List<Scenario> scenarios = repository.findAll();
        model.addAttribute("scenarios", scenarios);
        return "index";
    }

    @PostMapping("/simulate")
    public String simulate(@ModelAttribute Scenario scenario, Model model) {
        Map<String, Double> result = roiService.calculateROI(scenario);
        model.addAttribute("scenario", scenario);
        model.addAttribute("result", result);
        return "index";
    }

    @PostMapping("/save")
    public String saveScenario(@ModelAttribute Scenario scenario) {
        repository.save(scenario);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteScenario(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
