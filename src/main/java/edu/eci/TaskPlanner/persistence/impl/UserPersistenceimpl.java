package edu.eci.TaskPlanner.persistence.impl;

import edu.eci.TaskPlanner.model.User;
import edu.eci.TaskPlanner.persistence.IUserPersistence;
import edu.eci.TaskPlanner.persistence.TaskPlannerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserPersistenceimpl implements IUserPersistence {

    public UserPersistenceimpl(){

    }
    @Override
    public List<User> getAll() {
        return ListaUsers;
    }

    @Override
    public User getById(String userId) throws TaskPlannerException {
        User usuario = null;
        for (int i = 0; i < ListaUsers.size(); i++) {
            if (ListaUsers.get(i).getUsername().equals(userId)){
                usuario = ListaUsers.get(i);
                break;
            }
        }
        if(usuario==null){
            throw new TaskPlannerException("Usuario no encontrado");
        }
        return usuario;
    }

    @Override
    public User create(User user) throws TaskPlannerException {
        for (int i = 0; i < ListaUsers.size(); i++) {
            if (ListaUsers.get(i).getUsername().equals(user.getUsername())){
                throw new TaskPlannerException("Usuario encontrado");
            }
        }
        ListaUsers.add(user);
        return user;
    }

    @Override
    public User update(User user) throws TaskPlannerException {
        for (int i = 0; i < ListaUsers.size(); i++) {
            if (ListaUsers.get(i).getUsername().equals(user.getUsername())){

                ListaUsers.remove(i);
                ListaUsers.add(user);
            }
        }
        return user;
    }

    @Override
    public void remove(String userId) {
        for (int i = 0; i < ListaUsers.size(); i++) {
            if (ListaUsers.get(i).getUsername().equals(userId)){
                ListaUsers.remove(i);
            }
        }
    }
}
