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
@Table(name = "employee")
public class EmployeeDataSet extends DataSet {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "employee", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WorkingTimeDataSet> workingHours;

    public EmployeeDataSet(String name, List<WorkingTimeDataSet> workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }
}

