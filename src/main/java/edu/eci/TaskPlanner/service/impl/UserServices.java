package edu.eci.TaskPlanner.service.impl;

import edu.eci.TaskPlanner.model.User;
import edu.eci.TaskPlanner.persistence.IUserPersistence;
import edu.eci.TaskPlanner.persistence.TaskPlannerException;
import edu.eci.TaskPlanner.service.IUserServices;
import edu.eci.TaskPlanner.service.TaskPlannerServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServices implements IUserServices {
    @Autowired
    IUserPersistence up;

    public UserServices(){

    }

    @Override
    public List<User> getAll() throws TaskPlannerServicesException {
        try{
            return up.getAll();
        }catch (TaskPlannerException e){
            throw new TaskPlannerServicesException(e.getMessage());
        }
    }

    @Override
    public User getById(String userId)  throws TaskPlannerServicesException{
        try{
            return up.getById(userId);
        }catch (TaskPlannerException e){
            throw new TaskPlannerServicesException(e.getMessage());
        }
    }

    @Override
    public User create(User user)  throws TaskPlannerServicesException{
        try{
            return up.create(user);
        }catch (TaskPlannerException e){
            throw new TaskPlannerServicesException(e.getMessage());
        }
    }

    @Override
    public User update(User user)  throws TaskPlannerServicesException{
        try{
            return up.update(user);
        }catch (TaskPlannerException e){
            throw new TaskPlannerServicesException(e.getMessage());
        }
    }

    @Override
    public void remove(String userId)  throws TaskPlannerServicesException{
        try{
             up.remove(userId);
        }catch (TaskPlannerException e){
            throw new TaskPlannerServicesException(e.getMessage());
        }
    }
}
