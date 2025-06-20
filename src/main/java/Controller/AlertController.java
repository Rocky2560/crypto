package Controller;

import Entity.PriceAlert;
import Repository.PriceAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final PriceAlertRepository repository;

    @PostMapping
    public PriceAlert createAlert(@RequestBody PriceAlert alert) {
        return repository.save(alert);
    }

    @GetMapping
    public List<PriceAlert> getAlerts() {
        return repository.findAll();
    }
}
