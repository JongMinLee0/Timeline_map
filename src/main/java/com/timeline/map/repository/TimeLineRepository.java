package com.timeline.map.repository;

import com.timeline.map.model.TimeLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeLineRepository extends JpaRepository<TimeLine, Long> {

    List<TimeLine> findAllByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
