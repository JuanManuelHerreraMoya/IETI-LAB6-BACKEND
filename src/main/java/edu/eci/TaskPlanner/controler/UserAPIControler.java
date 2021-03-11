package edu.eci.TaskPlanner.controler;
import edu.eci.TaskPlanner.model.User;
import edu.eci.TaskPlanner.service.IUserServices;
import edu.eci.TaskPlanner.service.TaskPlannerServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserAPIControler {
    @Autowired
    IUserServices us;



    @RequestMapping(path = "/users/{userName}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByNameUser(@PathVariable(name = "userName") String userName) {
        try {
            return new ResponseEntity<>(us.getById(userName), HttpStatus.ACCEPTED);
        } catch (TaskPlannerServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(path = "/users/changeUser", method = RequestMethod.POST)
    public ResponseEntity<?> changeUsuario(@RequestBody User user){
        try {
            us.update(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (TaskPlannerServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/users/newUser", method = RequestMethod.POST)
    public ResponseEntity<?> postUsuario(@RequestBody User user){
        try {
            us.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (TaskPlannerServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "users/remove/{iduser}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeParticipant(@PathVariable(name = "idUser") String idUser) {
        try {
            us.remove(idUser);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (TaskPlannerServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        try{
            return new ResponseEntity<>(us.getAll(),HttpStatus.ACCEPTED);
        }catch (TaskPlannerServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
