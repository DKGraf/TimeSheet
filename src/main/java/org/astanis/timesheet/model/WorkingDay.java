package org.astanis.timesheet.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "month")
@Data
@NoArgsConstructor
@Entity
@Table(name = "day")
public class WorkingDay extends DataSet {
    @Column(name = "minutes")
    private int minutes;

    @ManyToOne
    private WorkingMonth month;
}
