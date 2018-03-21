package org.astanis.timesheet.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "employee")
@Data
@NoArgsConstructor
@Entity
@Table(name = "month")
public class WorkingMonth extends DataSet {
    @Column(name = "year")
    private int year;

    @Column(name = "month")
    private int month;

    @OneToMany(mappedBy = "month",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    List<WorkingDay> days;

    @ManyToOne
    private Employee employee;
}
