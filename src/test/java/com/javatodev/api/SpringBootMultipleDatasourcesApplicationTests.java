package com.javatodev.api;

import com.javatodev.api.model.card.CreditCardEntity;
import com.javatodev.api.model.user.UserEntity;
import com.javatodev.api.repository.bank.CreditCardRepository;
import com.javatodev.api.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SpringBootMultipleDatasourcesApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    private static UserEntity user;
    private static CreditCardEntity creditCard;

    @BeforeAll
    public static void initializeDataObjects(){
        creditCard = CreditCardEntity.builder().type("VISA").number("4910 1399 6158 1466").build();
        user = UserEntity.builder().username("JavaToDev").build();
    }

    @Test
    public void shouldSaveUserToMemberDB() {
        UserEntity save = userRepository.save(user);
        Optional<UserEntity> userById = userRepository.findById(save.getId());
        assert (userById.isPresent());
    }

    @Test
    public void shouldSaveCreditCardToCardDB () {
        CreditCardEntity save = creditCardRepository.save(creditCard);
        Optional<CreditCardEntity> creditCardEntity = creditCardRepository.findById(save.getId());
        assert creditCardEntity.isPresent();
    }


}
