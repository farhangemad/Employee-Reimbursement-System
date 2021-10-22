package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.*;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.example.dao.UserDao;
import org.example.models.UserModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Users implements Handler {
    Gson gson = new Gson();
    UserDao dao = new UserDao();

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Logic logic = new Logic();
        context.contentType("application/json");
        //JsonObject jsonObject = JsonParser.parseString(context.body()).getAsJsonObject();
        //String username = jsonObject.get("username").getAsString();
        //String password = jsonObject.get("password").getAsString();
        List<UserModel> users = dao.findAllUsers();

        //JsonObject returnJson = new JsonObject();

        for (int i = 0; i < users.size(); i++) {
            /*UserModel user = users.get(i);
            int status;
            //returnJson.addProperty("logged_in", true);
            status = 200;

            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String email = user.getEmail();
            String phone = user.getPhone();
            String result = firstname + "---" + lastname + "---" + email + "---" + phone;
            */
            UserModel user = users.get(i);
            String result = logic.buildUsers(user);

            context.cookie("Emp"+(i+1), result);

        }
    }
}
