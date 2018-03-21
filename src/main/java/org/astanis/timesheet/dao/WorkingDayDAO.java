package org.astanis.timesheet.dao;

import org.astanis.timesheet.model.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingDayDAO extends JpaRepository<WorkingDay, Long> {
}
