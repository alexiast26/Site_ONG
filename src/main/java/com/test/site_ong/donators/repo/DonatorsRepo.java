package com.test.site_ong.donators.repo;

import com.test.site_ong.donators.model.Donators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonatorsRepo extends JpaRepository<Donators, Integer> {

    //find donator based on id
    Donators findById(int id);

    //find donators based on submit date
    List<Donators> findBySubmitDate(LocalDateTime startDate, LocalDateTime endDate);

}
