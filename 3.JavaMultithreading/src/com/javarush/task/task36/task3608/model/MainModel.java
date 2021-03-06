package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();


    ArrayList<User> list = new ArrayList<>();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    private List<User> getAllUsers(){
        List<User> list = userService.getUsersBetweenLevels(1,100);
        return userService.filterOnlyActiveUsers(list);
    }


    public void loadUsers(){
        modelData.setUsers(getAllUsers());
        modelData.setDisplayDeletedUserList(false);
    }
    public void loadDeletedUsers(){
        modelData.setUsers(userService.getAllDeletedUsers());
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userid){
        modelData.setActiveUser(userService.getUsersById(userid));

    }

    public void deleteUserById(long id){
        userService.deleteUser(id);
        loadUsers();
    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name,id,level);
        loadUsers();
    }

}
