package org.astanis;

import org.astanis.db.datasets.EmployeeDataSet;
import org.astanis.db.datasets.WorkingTimeDataSet;
import org.astanis.db.dbservice.DbServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> m201801 = List.of(0, 0, 0, 0, 0, 0, 0, 0, 480, 480, 480, 480, 0, 0, 480, 480, 480, 480, 480, 0, 0, 480, 480, 480, 480, 480, 0, 0, 480, 480, 480);
        List<Integer> m201802 = List.of(480, 480, 0, 0, 480, 480, 480, 480, 480, 0, 0, 480, 480, 480, 480, 480, 0, 0, 480, 480, 480, 420, 0, 0, 0, 480, 480, 480);
        List<Integer> m201803 = List.of(480, 480, 0, 0, 480, 480, 420, 0, 0, 0, 0, 480, 480, 480, 480, 480, 0, 0, 480, 480, 480, 480, 480, 0, 0, 480, 480, 480, 480, 480, 0);

        List<WorkingTimeDataSet> list01 = new ArrayList<>();
        for (int i = 0; i < m201801.size(); i++) {
            list01.add(new WorkingTimeDataSet(2018, 1, i, m201801.get(i)));
        }
        for (int i = 0; i < m201802.size(); i++) {
            list01.add(new WorkingTimeDataSet(2018, 2, i, m201802.get(i)));
        }
        for (int i = 0; i < m201803.size(); i++) {
            list01.add(new WorkingTimeDataSet(2018, 3, i, m201803.get(i)));
        }

        List<WorkingTimeDataSet> list02 = new ArrayList<>();
        for (int i = 0; i < m201801.size(); i++) {
            list02.add(new WorkingTimeDataSet(2018, 1, i, m201801.get(i)));
        }
        for (int i = 0; i < m201802.size(); i++) {
            list02.add(new WorkingTimeDataSet(2018, 2, i, m201802.get(i)));
        }
        for (int i = 0; i < m201803.size(); i++) {
            list02.add(new WorkingTimeDataSet(2018, 3, i, m201803.get(i)));
        }

        List<WorkingTimeDataSet> list03 = new ArrayList<>();
        for (int i = 0; i < m201801.size(); i++) {
            list03.add(new WorkingTimeDataSet(2018, 1, i, m201801.get(i)));
        }
        for (int i = 0; i < m201802.size(); i++) {
            list03.add(new WorkingTimeDataSet(2018, 2, i, m201802.get(i)));
        }
        for (int i = 0; i < m201803.size(); i++) {
            list03.add(new WorkingTimeDataSet(2018, 3, i, m201803.get(i)));
        }

        EmployeeDataSet employee1 = new EmployeeDataSet
                ("Ivanov Ivan Ivanovich", 1L, "Some Department", list01, true);
        EmployeeDataSet employee2 = new EmployeeDataSet
                ("Petrov Petr Petrovich", 2L, "Another Department", list02, true);
        EmployeeDataSet employee3 = new EmployeeDataSet
                ("Ivanova Olga Ivanovna", 3L, "Another Department", list03, false);

        for (WorkingTimeDataSet aList01 : list01) {
            aList01.setEmployee(employee1);
        }
        for (WorkingTimeDataSet aList02 : list02) {
            aList02.setEmployee(employee2);
        }
        for (WorkingTimeDataSet aList03 : list03) {
            aList03.setEmployee(employee3);
        }

        DbServiceImpl dbService = new DbServiceImpl();

        dbService.save(employee1);
        dbService.save(employee2);
        dbService.save(employee3);

        System.out.println(dbService.readByName("Ivanova Olga Ivanovna"));
    }
}
