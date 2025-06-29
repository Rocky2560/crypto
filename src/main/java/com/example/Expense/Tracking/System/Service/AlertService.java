package com.example.Expense.Tracking.System.Service;

import com.example.Expense.Tracking.System.Entity.PriceAlert;
import com.example.Expense.Tracking.System.Repository.PriceAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final PriceAlertRepository repository;
    private final JavaMailSender mailSender;

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 60000)
    public void checkAlerts() {
        List<PriceAlert> alerts = repository.findByTriggeredFalse();
        for (PriceAlert alert : alerts) {
            double currentPrice = fetchCryptoPrice(alert.getCryptoId());
            boolean shouldTrigger = alert.isAbove() ? currentPrice >= alert.getTargetPrice() : currentPrice <= alert.getTargetPrice();
            if (shouldTrigger) {
                sendEmail(alert.getEmail(), alert.getCryptoId(), currentPrice, alert.getTargetPrice());
                alert.setTriggered(true);
                repository.save(alert);
            }
        }
    }

    private double fetchCryptoPrice(String cryptoId) {
//        String url = "https://api.coincap.io/v2/assets/" + cryptoId + "&vs_currencies=usd";
        String cryptoSymbol = "BTC";
        String url = "https://min-api.cryptocompare.com/data/price?fsym=" + cryptoSymbol + "&tsyms=USD";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Double> response = restTemplate.getForObject(url, Map.class);

        return response.get("USD");

    }

    private void sendEmail(String to, String cryptoId, double current, double target) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("🔔 Crypto Alert: " + cryptoId);
        message.setText("The price of " + cryptoId + " is now $" + current + " (target: $" + target + ")");
        mailSender.send(message);
    }
}

