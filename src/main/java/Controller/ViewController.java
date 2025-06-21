// controller/ViewController.java
package Controller;

import Entity.PriceAlert;
import Repository.PriceAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final PriceAlertRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("alerts", repository.findAll());
        model.addAttribute("alert", new PriceAlert());
        System.out.println(model);
        return "index";
    }

    @PostMapping("/")
    public String createAlert(@ModelAttribute PriceAlert alert) {
        repository.save(alert);
        return "redirect:/";
    }
}
