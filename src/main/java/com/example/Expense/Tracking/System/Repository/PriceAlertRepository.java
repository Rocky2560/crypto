package com.example.Expense.Tracking.System.Repository;

import com.example.Expense.Tracking.System.Entity.PriceAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceAlertRepository extends JpaRepository <PriceAlert , Long> {

    List<PriceAlert> findByTriggeredFalse();

}
