package com.javatodev.api;

import com.javatodev.api.model.bank.account.AccountEntity;
import com.javatodev.api.model.bank.card.CreditCardEntity;
import com.javatodev.api.model.user.UserEntity;
import com.javatodev.api.repository.bank.AccountRepository;
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
    @Autowired
    private AccountRepository accountRepository;

    private static UserEntity user;
    private static CreditCardEntity creditCard;
    private static AccountEntity account;

    @BeforeAll
    public static void initializeDataObjects(){
        creditCard = CreditCardEntity.builder().type("VISA").number("4910 0000 0000 0006").build();
        user = UserEntity.builder().username("JavaToDev").build();
        account = AccountEntity.builder().number("8884 0000 0002").build();
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

    @Test
    public void shouldSaveBankAccountToDB () {
        AccountEntity save = accountRepository.save(account);
        Optional<AccountEntity> byId = accountRepository.findById(save.getId());
        assert (byId.isPresent());
    }


}
