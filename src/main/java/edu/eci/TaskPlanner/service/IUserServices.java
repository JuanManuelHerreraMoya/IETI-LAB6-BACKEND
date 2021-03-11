package edu.eci.TaskPlanner.service;
import edu.eci.TaskPlanner.model.*;

import java.util.List;

public interface IUserServices {

    List<User> getAll() throws TaskPlannerServicesException;
    User getById(String userId)throws TaskPlannerServicesException;
    User create(User user)throws TaskPlannerServicesException;
    User update(User user)throws TaskPlannerServicesException;
    void remove(String userId)throws TaskPlannerServicesException;
}
