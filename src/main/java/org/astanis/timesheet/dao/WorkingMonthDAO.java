package org.astanis.timesheet.dao;

import org.astanis.timesheet.model.WorkingMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingMonthDAO extends JpaRepository<WorkingMonth, Long> {
    List<WorkingMonth> findAllByYearAndMonth(int year, int month);
}
