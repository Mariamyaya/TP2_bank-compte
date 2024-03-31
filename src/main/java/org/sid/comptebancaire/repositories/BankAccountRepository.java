package org.sid.comptebancaire.repositories;

import org.sid.comptebancaire.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
