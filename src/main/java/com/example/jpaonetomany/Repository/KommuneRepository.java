package com.example.jpaonetomany.Repository;

import com.example.jpaonetomany.Model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

}
