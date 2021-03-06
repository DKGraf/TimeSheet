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

    //"true" - male, "false" - female.
    @Column(name = "sex")
    private boolean sex;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "employee",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<WorkingMonth> months;
}
