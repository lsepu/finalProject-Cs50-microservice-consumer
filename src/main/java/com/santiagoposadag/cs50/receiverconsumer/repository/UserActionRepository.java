package com.santiagoposadag.cs50.receiverconsumer.repository;

import com.santiagoposadag.cs50.receiverconsumer.collections.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserActionRepository  extends ReactiveCrudRepository<User, String> {
}
