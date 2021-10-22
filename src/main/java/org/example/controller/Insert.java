package org.example.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.example.dao.RequestDao;
import org.example.dao.UserDao;
import org.example.models.RequestModel;
import org.example.models.UserModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Insert implements Handler {
    RequestDao dao = new RequestDao();

    @Override
    public void handle(@NotNull Context context) throws Exception {
        RequestModel request = new RequestModel();
        context.contentType("application/json");
        JsonObject jsonObject = JsonParser.parseString(context.body()).getAsJsonObject();
        //Integer employee_id = jsonObject.get("employee_id").getAsInt();
        //Double amount = jsonObject.get("amount").getAsDouble();
        //String reason = jsonObject.get("reason").getAsString();
        request.setEmployee_id(jsonObject.get("employee_id").getAsInt());
        request.setAmount(jsonObject.get("amount").getAsDouble());
        request.setReason(jsonObject.get("reason").getAsString());
        request.setApproved(false);
        request.setApproverid(0);
        dao.persist(request);
    }

}
