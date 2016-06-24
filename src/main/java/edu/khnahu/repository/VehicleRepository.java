package edu.khnahu.repository;

import edu.khnahu.domain.Account;
import edu.khnahu.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by dev on 6/24/16.
 */
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

}