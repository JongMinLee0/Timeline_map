package com.timeline.map.repository;

import com.timeline.map.model.TimeLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeLineRepository extends JpaRepository<TimeLine, Long> {

    List<TimeLine> getAllByName(String name);

    List<TimeLine> getAllByNameAndRegDate(String name, LocalDateTime regDate);

}
