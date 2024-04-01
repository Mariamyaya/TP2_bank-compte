package org.sid.comptebancaire;

import org.sid.comptebancaire.entities.BankAccount;
import org.sid.comptebancaire.enums.AccountType;
import org.sid.comptebancaire.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

import static graphql.introspection.IntrospectionQueryBuilder.build;

@SpringBootApplication
public class CompteBancaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteBancaireApplication.class, args);
    }



    @Bean
    CommandLineRunner star (BankAccountRepository bankAccountRepository){
        return  args -> {
            for (int i = 0; i<10; i++){
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD").build();
                bankAccountRepository.save(bankAccount);
            }
        };
    }

}



