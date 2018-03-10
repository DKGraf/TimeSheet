package org.astanis.db.datasets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "workinghours")
public class WorkingTimeDataSet extends DataSet {
//    @Column(name = "month")
//    private int month;

//    @Column(name = "hours")
    @OneToMany(mappedBy = "workingTime", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TimeDataSet> workingHours = new ArrayList<>();

    @ManyToOne
    private EmployeeDataSet employee;
}
