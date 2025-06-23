package com.example.Expense.Tracking.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PriceAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cryptoId;    //e,g bitcoin, etherium
    private double targetPrice;
    private boolean isAbove;   // true : alert if above, false : alert if below;
    private String email;
    private boolean triggered = false;


}
