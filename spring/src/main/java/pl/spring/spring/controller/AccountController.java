package pl.spring.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.spring.spring.dto.CreateAccountDTO;
import pl.spring.spring.entity.Account;
import pl.spring.spring.repository.AccountRepository;

import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    /**
     *      /accounts/create
     *      This POST method creates an account for a user
     **/

    @PostMapping("/create")
    public ResponseEntity<?> createAccount (@RequestBody CreateAccountDTO createAccountDTO) {
        Account account = new Account();
        account.setBalance(0D);
        account.setUserId(createAccountDTO.getUserId());

        String generatedAccountNO = UUID.randomUUID().toString();

        account.setAccountNO(generatedAccountNO);
        Account saved = accountRepository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
