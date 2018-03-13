package org.astanis.db.datasets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "employee")
@Data
@NoArgsConstructor
@Entity
@Table(name = "workinghours")
public class WorkingTimeDataSet extends DataSet {
    @Column(name = "year")
    private int year;

    @Column(name = "month")
    private int month;

    @Column(name = "day")
    private int day;

    @Column(name = "working_minutes")
    private int workingMinutes;

    @ManyToOne
    private EmployeeDataSet employee;

    public WorkingTimeDataSet(int year, int month, int day, int workingMinutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.workingMinutes = workingMinutes;
    }
}
