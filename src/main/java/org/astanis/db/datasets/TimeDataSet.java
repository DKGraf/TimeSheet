package org.astanis.db.datasets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "hours")
public class TimeDataSet extends DataSet {
    @Column(name = "hours")
    private int hours;

    @ManyToOne
    private WorkingTimeDataSet workingTime;

    public TimeDataSet(int hours) {
        this.hours = hours;
    }
}
