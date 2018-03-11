package org.astanis;

import org.astanis.db.datasets.EmployeeDataSet;
import org.astanis.db.datasets.WorkingTimeDataSet;
import org.astanis.db.dbservice.DbServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> m201801 = List.of(0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8);
        List<Integer> m201802 = List.of(8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 7, 0, 0, 0, 8, 8, 8);
        List<Integer> m201803 = List.of(8, 8, 0, 0, 8, 8, 7, 0, 0, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0);




        WorkingTimeDataSet wtd201801_1 = new WorkingTimeDataSet(201801, m201801);
        WorkingTimeDataSet wtd201802_1 = new WorkingTimeDataSet(201802, m201802);
        WorkingTimeDataSet wtd201803_1 = new WorkingTimeDataSet(201803, m201803);

        WorkingTimeDataSet wtd201801_2 = new WorkingTimeDataSet(201801, m201801);
        WorkingTimeDataSet wtd201802_2 = new WorkingTimeDataSet(201802, m201802);
        WorkingTimeDataSet wtd201803_2 = new WorkingTimeDataSet(201803, m201803);

        WorkingTimeDataSet wtd201801_3 = new WorkingTimeDataSet(201801, m201801);
        WorkingTimeDataSet wtd201802_3 = new WorkingTimeDataSet(201802, m201802);
        WorkingTimeDataSet wtd201803_3 = new WorkingTimeDataSet(201803, m201803);

        List<WorkingTimeDataSet> list1 = List.of(wtd201801_1, wtd201802_1, wtd201803_1);
        List<WorkingTimeDataSet> list2 = List.of(wtd201801_2, wtd201802_2, wtd201803_2);
        List<WorkingTimeDataSet> list3 = List.of(wtd201801_3, wtd201802_3, wtd201803_3);

        EmployeeDataSet employee1 = new EmployeeDataSet("Ivanov Ivan Ivanovich", list1);
        EmployeeDataSet employee2 = new EmployeeDataSet("Petrov Petr Petrovich", list2);
        EmployeeDataSet employee3 = new EmployeeDataSet("Alexandrov Alexander Alexandrovich", list3);

        wtd201801_1.setEmployee(employee1);
        wtd201802_1.setEmployee(employee1);
        wtd201803_1.setEmployee(employee1);

        wtd201801_2.setEmployee(employee2);
        wtd201802_2.setEmployee(employee2);
        wtd201803_2.setEmployee(employee2);

        wtd201801_3.setEmployee(employee3);
        wtd201802_3.setEmployee(employee3);
        wtd201803_3.setEmployee(employee3);

        DbServiceImpl dbService = new DbServiceImpl();

        dbService.save(employee1);
        dbService.save(employee2);
        dbService.save(employee3);

    }
}
