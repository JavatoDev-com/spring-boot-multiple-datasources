package com.javatodev.api.repository.bank;

import com.javatodev.api.model.card.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
}
