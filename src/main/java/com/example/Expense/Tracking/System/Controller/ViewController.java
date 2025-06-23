// controller/ViewController.java
package com.example.Expense.Tracking.System.Controller;

import com.example.Expense.Tracking.System.Entity.PriceAlert;
import com.example.Expense.Tracking.System.Repository.PriceAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class ViewController {

    private final PriceAlertRepository repository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("alerts", repository.findAll());
        model.addAttribute("alert", new PriceAlert());
        System.out.println(model);
        return "home";
    }

    @PostMapping
    public String createAlert(@ModelAttribute PriceAlert alert) {
        repository.save(alert);
        return "redirect:/alerts";
    }
}
