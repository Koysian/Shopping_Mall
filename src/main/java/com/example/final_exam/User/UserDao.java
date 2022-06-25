package com.example.final_exam.User;

import com.example.final_exam.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createUser(CreateUserReq createUserReq) {
        String createUserQuery = "insert into users (firstName, lastName, email, id, password) VALUES (?,?,?,?,?)";
        Object[] createUserParams = new Object[]{createUserReq.getFirstName(), createUserReq.getLastName(),createUserReq.getEmail(), createUserReq.getId(), createUserReq.getPassword()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);
    }

    public int checkId(CreateUserReq createUserReq) {
        String checkIdQuery = "select exists(select id from users WHERE id=?);";
        Object[] checkIdParam = new Object[]{createUserReq.getId()};
        return this.jdbcTemplate.queryForObject(checkIdQuery, int.class, checkIdParam);
    }

    public int login(LoginReq loginReq) {
        String loginQuery = "select exists(select id, password from users where id=? and password=? and status='ACTIVE');";
        Object[] loginParam = new Object[]{loginReq.getId(), loginReq.getPassword()};
        return this.jdbcTemplate.queryForObject(loginQuery, int.class, loginParam);
    }


    public int checkAdmin(String id) {
        String checkAdminQuery = "select exists(select id from admins where id=?);";
        String checkAdminParam = id;
        return this.jdbcTemplate.queryForObject(checkAdminQuery, int.class, checkAdminParam);
    }

    public List<User> list() {
        String listQuery = "select userIdx, firstName, lastName, email, id from users where status='ACTIVE';";

        return this.jdbcTemplate.query(listQuery, (rs, rowNum)->new User(
                rs.getInt("userIdx"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("id")
        ));
    }

    public List<User> deletedUserlist() {
        String listQuery = "select userIdx, firstName, lastName, email, id from users where status='INACTIVE';";

        return this.jdbcTemplate.query(listQuery, (rs, rowNum)->new User(
                rs.getInt("userIdx"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("id")
        ));
    }

    public void resurrectUser(String id) {
        String resurrectUserQuery = "update users set status = 'ACTIVE' where id=?;";

        this.jdbcTemplate.update(resurrectUserQuery, id);
    }

    public void deleteUser(String id) {
        if(checkAdmin(id) == 1){
            return;
        }
        String resurrectUserQuery = "update users set status = 'INACTIVE' where id=?;";
        this.jdbcTemplate.update(resurrectUserQuery, id);
    }

    public int getUserIdxById(String id){
        if(this.jdbcTemplate.queryForObject("select exists(select userIdx from users where id=?);", int.class, id) != 1){
            return -1;
        }
        return this.jdbcTemplate.queryForObject("select userIdx from users where id=?", int.class, id);
    }

    public void makeHimAdmin(String id) {
        int userIdx = getUserIdxById(id);
        if(userIdx == -1){
            return;
        }
        String makeHimAdminQuery = "insert into admins (userIdx, id) values (?, ?);";

        Object[] makeHimAdminParams = new Object[]{userIdx, id};

        this.jdbcTemplate.update(makeHimAdminQuery, makeHimAdminParams);
    }

    public void modifyUser(ModifyUserReq modifyUserReq) {
        if(getUserIdxById(modifyUserReq.getId()) == -1){
            return;
        }
        String modifyUserQuery = "update users set firstName=?, lastName=?, email=? where id=?;";
        Object[] modifyUserParams = new Object[]{modifyUserReq.getFirstName(), modifyUserReq.getLastName(), modifyUserReq.getEmail(), modifyUserReq.getId()};
        this.jdbcTemplate.update(modifyUserQuery, modifyUserParams);
    }
}
