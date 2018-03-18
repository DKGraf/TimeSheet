package org.astanis.timesheet.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends DataSet {
    @Column(name = "personal_number",
            unique = true)
    private long personalNumber;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "employee",
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<WorkingTime> workingHours;
}
