package com.tourist.repository;

import com.tourist.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository <UserRegistration,Long>{

}
