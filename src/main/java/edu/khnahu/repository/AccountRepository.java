package edu.khnahu.repository;

import edu.khnahu.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String>, AccountRepositoryCustom {
}
