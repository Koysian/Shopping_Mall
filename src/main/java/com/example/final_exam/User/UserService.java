package com.example.final_exam.User;

import com.example.final_exam.Domain.*;
import com.example.final_exam.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void createUser(CreateUserReq createUserReq) throws Exception {
        if(checkId(createUserReq) == 1){
            throw new Exception();
        }
        String pwd;
        pwd = new SHA256().encrypt(createUserReq.getPassword());
        createUserReq.setPassword(pwd);

        userDao.createUser(createUserReq);
    }

    public int checkId(CreateUserReq createUserReq){
        return userDao.checkId(createUserReq);
    }

    public void login(LoginReq loginReq) throws Exception{
        try {
            String pwd;
            pwd = new SHA256().encrypt(loginReq.getPassword());
            loginReq.setPassword(pwd);
            int isSuccess = userDao.login(loginReq);
            if (isSuccess != 1) {
                throw new Exception();
            }
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public int checkAdmin(String id){
        return userDao.checkAdmin(id);
    }

    public List<User> list() throws Exception{
        try{
            List<User> userList = userDao.list();
            return userList;
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public List<User> deletedUserlist() throws Exception{
        try{
            List<User> userList = userDao.deletedUserlist();
            return userList;
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void resurrectUser(String id) throws Exception{
        try{
            userDao.resurrectUser(id);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void deleteUser(String id) throws Exception{
        try{
            userDao.deleteUser(id);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void makeHimAdmin(String id) throws Exception{
        try{
            userDao.makeHimAdmin(id);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void modifyUser(ModifyUserReq modifyUserReq) throws Exception{
        try{
            userDao.modifyUser(modifyUserReq);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
