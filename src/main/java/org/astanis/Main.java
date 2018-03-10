package org.astanis;

import org.astanis.db.datasets.EmployeeDataSet;
import org.astanis.db.datasets.TimeDataSet;
import org.astanis.db.datasets.WorkingTimeDataSet;
import org.astanis.db.dbservice.DbServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> m201801 = List.of(0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8);
        List<Integer> m201802 = List.of(8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 7, 0, 0, 0, 8, 8, 8);
        List<Integer> m201803 = List.of(8, 8, 0, 0, 8, 8, 8, 0, 0, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0, 0, 8, 8, 8, 8, 8, 0);

        WorkingTimeDataSet wtd201801 = new WorkingTimeDataSet();
        WorkingTimeDataSet wtd201802 = new WorkingTimeDataSet();
        WorkingTimeDataSet wtd201803 = new WorkingTimeDataSet();
        for (int i = 0; i < 31; i++) {
            int hour01 = m201801.get(i);
            int hour03 = m201803.get(i);
            wtd201801.getWorkingHours().add(new TimeDataSet(hour01));
            wtd201803.getWorkingHours().add(new TimeDataSet(hour03));
            if (i < 28) {
                int hour02 = m201802.get(i);
                wtd201802.getWorkingHours().add(new TimeDataSet(hour02));
            }
        }

//        WorkingTimeDataSet wtd201801 = new WorkingTimeDataSet();
//        WorkingTimeDataSet wtd201802 = new WorkingTimeDataSet();
//        WorkingTimeDataSet wtd201803 = new WorkingTimeDataSet();
//        wtd201801.setWorkingHours(m201801);
//        wtd201802.setWorkingHours(m201802);
//        wtd201803.setWorkingHours(m201803);

        List<WorkingTimeDataSet> wtdList = List.of(wtd201801, wtd201802, wtd201803);

        Map<Integer, List<WorkingTimeDataSet>> y2018 = new HashMap<>();
        y2018.put(201801, wtdList);
        y2018.put(201802, wtdList);
        y2018.put(201803, wtdList);

        EmployeeDataSet employee1 = new EmployeeDataSet("Ivanov Ivan Ivanovich", y2018);
        EmployeeDataSet employee2 = new EmployeeDataSet("Petrov Petr Petrovich", y2018);
        EmployeeDataSet employee3 = new EmployeeDataSet("Alexandrov Alexander Alexandrovich", y2018);

        DbServiceImpl dbService = new DbServiceImpl();

        dbService.save(employee1);
        dbService.save(employee2);
        dbService.save(employee3);
    }
}
