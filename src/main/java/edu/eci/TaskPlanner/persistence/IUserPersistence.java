package edu.eci.TaskPlanner.persistence;
import edu.eci.TaskPlanner.model.*;

import java.util.ArrayList;
import java.util.List;

public interface IUserPersistence {
    List<User> ListaUsers = new ArrayList<>();

    List<User> getAll()throws TaskPlannerException;
    User getById(String userId)throws TaskPlannerException;
    User create(User user)throws TaskPlannerException;
    User update(User user)throws TaskPlannerException;
    void remove(String userId)throws TaskPlannerException;
}
