package peaksoft.dao;

import peaksoft.entity.Workers;

import java.util.List;

public interface DaoWorkers {
     void createTable();
     void  saveWorkers(String name,String surname,byte age);
    List<Workers> getAllWorkers();
    void updateAllWorkers();
    List<Workers> deleteAllWorkers();
    List<Workers> getRemainderWorkers();
}
