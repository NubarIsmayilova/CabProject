package com.example.cabproject.repository;

import com.example.cabproject.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
}
