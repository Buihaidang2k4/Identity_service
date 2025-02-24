package com.devteria.identity_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devteria.identity_service.entity.User;

/*
jpa  aotu generate code
save(entity)
findById(id)
findAll() - lay tat ca ban ghi
deleteById(id) - xoa ban ghi theo khoa chinh.
 */
@Repository // se giup bean tao repo
public interface UserRepository extends JpaRepository<User, String> {
    // Jpa tu dong res query kiem tra su ton tai ham nay
    boolean existsByUsername(String username); // tim theo ten

    Optional<User> findByUsername(String username);
}
