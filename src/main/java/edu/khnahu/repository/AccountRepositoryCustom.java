package edu.khnahu.repository;

import edu.khnahu.domain.Account;

public interface AccountRepositoryCustom {
    Account findById(String id);
}
