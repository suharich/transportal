package edu.khnahu.repository;

import edu.khnahu.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class AccountRepositoryImpl implements AccountRepositoryCustom {
    @Autowired
    private MongoOperations operations;

    @Override
    public Account findById(String id) {
        Account result = operations.findOne(query(where("_id").is(id)), Account.class);
        return result;
    }
}
