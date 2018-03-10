package org.astanis.db.datasets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeDataSet extends DataSet {
    @Column(name = "name")
    private String name;

//    @Column(name = "sex")
//    private boolean sex;
//
//    @Column(name = "birthdate")
//    private Date birthDate;
//
//    @Column(name = "position")
//    private String position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Map<Integer, List<WorkingTimeDataSet>> workingHours;

    public EmployeeDataSet(String name, /*boolean sex, Date birthDate, String position,*/ Map<Integer, List<WorkingTimeDataSet>> workingHours) {
        this.name = name;
//        this.sex = sex;
//        this.birthDate = birthDate;
//        this.position = position;
        this.workingHours = workingHours;
    }
}

