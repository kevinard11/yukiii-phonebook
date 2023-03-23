package com.yukiii.sprphonebook.repo;

import com.yukiii.sprphonebook.entity.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, Long> {

	Optional<Phonebook> findByPhoneNumber(String phoneNumber);
}
