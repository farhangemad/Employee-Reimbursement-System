package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.example.dao.UserDao;
import org.example.models.UserModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Login implements Handler {
    UserDao dao = new UserDao();
    Gson gson;


    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.contentType("application/json");
        JsonObject jsonObject = JsonParser.parseString(context.body()).getAsJsonObject();
        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();
        List<UserModel> users = dao.findAllUsers();
        //JsonObject returnJson = new JsonObject();

        for (int i = 0; i < users.size(); i++) {
            UserModel user = users.get(i);
            String userUsername = user.getUsername();
            String fname = user.getFirstname();
            String lname = user.getLastname();
            String pass = user.getPasswd();
            String superstatus = Boolean.toString(user.getSuperstatus());


            int status;
            if (userUsername.contains(username) && pass.contains(password)){
                //returnJson.addProperty("logged_in", true);
                status = 200;

                context.cookie("fname", fname);
                context.cookie("lname", lname);
                context.cookie("superstatus", superstatus);

                context.status(status);
                context.contentType("application/json");
                break;

            } else {
                //returnJson.addProperty("logged_in", false);
                status = 401;
                context.status(status);
                context.contentType("application/json");
            }


        //context.result(gson.toJson(returnJson));
        }
    }



}
