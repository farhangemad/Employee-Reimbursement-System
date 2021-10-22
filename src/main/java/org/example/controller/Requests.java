package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.sql.Timestamp;
import java.util.*;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.example.dao.RequestDao;
import org.example.dao.UserDao;
import org.example.models.RequestModel;
import org.example.models.UserModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Requests implements Handler {
    Gson gson = new Gson();
    RequestDao dao = new RequestDao();

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Logic logic = new Logic();
        context.contentType("application/json");
        //JsonObject jsonObject = JsonParser.parseString(context.body()).getAsJsonObject();
        //String username = jsonObject.get("username").getAsString();
        //String password = jsonObject.get("password").getAsString();
        List<RequestModel> requests = dao.findAll();

        //JsonObject returnJson = new JsonObject();

        for (int i = 0; i < requests.size(); i++) {
            RequestModel request = requests.get(i);
            /*int status;
            //returnJson.addProperty("logged_in", true);
            status = 200;

            String employee_id = request.getEmployee_id();
            String amount = Double.toString(request.getAmount());
            String reason = request.getReason();
            String timecreated = (request.getTimecreated()).toString();
            String approved = Boolean.toString(request.getApproved());
            String approverid = Integer.toString(request.getApproverid());
            String result = employee_id + "---" + amount + "---" + reason + "---" + timecreated
                    + "---" + approved + "---" + approverid;

            String replaceString=result.replace(' ','_');
            String replacedString=replaceString.replace(':','*');*/

            String result = logic.buildRequests(request);


            context.cookie("Req"+(i+1), result);

        }
    }
}
