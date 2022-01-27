package peaksoft.service;

import peaksoft.dao.DaoWorkers;
import peaksoft.dao.DaoWorkersImpl;
import peaksoft.entity.Workers;

import java.util.List;

public class WorkersServiceImpl implements WorkersService{
    DaoWorkers daoWorkers = new DaoWorkersImpl();
    @Override
    public void createTable() {
        daoWorkers.createTable();
    }

    @Override
    public void saveWorkers(String name, String surname, byte age) {
        daoWorkers.saveWorkers(name,surname,age);
    }

    @Override
    public List<Workers> getAllWorkers() {
        return daoWorkers.getAllWorkers();
    }

    @Override
    public void updateAllWorkers() {
        daoWorkers.updateAllWorkers();
    }

    @Override
    public List<Workers> deleteAllWorkers() {
      return    daoWorkers.deleteAllWorkers();
    }

    @Override
    public List<Workers> getRemainderWorkers() {
        return daoWorkers.getRemainderWorkers();
    }
}
