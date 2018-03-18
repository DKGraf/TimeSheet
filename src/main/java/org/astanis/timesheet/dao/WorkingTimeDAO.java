package org.astanis.timesheet.dao;

import org.astanis.timesheet.model.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingTimeDAO extends JpaRepository<WorkingTime, Long> {
}
