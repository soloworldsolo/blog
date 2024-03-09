package com.soloworld.blog.repository;

import com.soloworld.blog.entity.Recipie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipieRepository extends JpaRepository<Recipie,Integer> {
}
