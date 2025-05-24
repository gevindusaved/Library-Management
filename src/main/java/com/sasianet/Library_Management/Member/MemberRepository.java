package com.sasianet.Library_Management.Member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasianet.Library_Management.Book.Books;

@Repository
public interface MemberRepository extends JpaRepository<Members, Integer> {
    Optional<Members> findById(int memberId);
}
