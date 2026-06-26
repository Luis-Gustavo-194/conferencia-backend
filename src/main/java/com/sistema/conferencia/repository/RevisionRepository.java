package com.sistema.conferencia.repository;

import com.sistema.conferencia.domain.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {
}
