package org.astanis.db.datasets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "workinghours")
public class WorkingTimeDataSet extends DataSet {
    @Column(name = "month")
    private int month;

    @ElementCollection
    private List<Integer> hours;

    @ManyToOne
    private EmployeeDataSet employee;

    public WorkingTimeDataSet(int month, List<Integer> hours) {
        this.month = month;
        this.hours = hours;
    }
}
