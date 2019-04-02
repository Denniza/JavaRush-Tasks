package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model {
    @Override
    public void loadUserById(long userid) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    private ModelData modelData = new ModelData();
    ArrayList<User> list = new ArrayList<>();
    @Override
    public ModelData getModelData() {
        throw  new UnsupportedOperationException();
    }

    public void loadUsers(){
        list.add(new User("A",1,1));
        list.add(new User("B",2,1));
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
