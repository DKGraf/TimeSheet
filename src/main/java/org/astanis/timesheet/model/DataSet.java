package org.astanis.timesheet.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
abstract class DataSet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
