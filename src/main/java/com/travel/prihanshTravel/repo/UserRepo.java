package com.travel.prihanshTravel.repo;

import com.travel.prihanshTravel.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUserEmail(String userEmail);
}
