package org.example.controller;

import org.example.models.RequestModel;
import org.example.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    public String buildUsers(UserModel user) {

        int status;
        //returnJson.addProperty("logged_in", true);
        status = 200;

        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        String email = user.getEmail();
        String phone = user.getPhone();
        String result = firstname + "---" + lastname + "---" + email + "---" + phone;
        System.out.println(result);

        return result;
    }

    public String buildRequests(RequestModel request) {
        int status;
        //returnJson.addProperty("logged_in", true);
        status = 200;

        String employee_id = Integer.toString(request.getEmployee_id());
        String amount = Double.toString(request.getAmount());
        String reason = request.getReason();
        String timecreated = (request.getTimecreated()).toString();
        String approved = Boolean.toString(request.getApproved());
        String approverid = Integer.toString(request.getApproverid());
        String result = employee_id + "----" + amount + "---" + reason + "---" + timecreated
                + "---" + approved + "---" + approverid;

        String replaceString=result.replace(' ','_');
        String replacedString=replaceString.replace(':','*');
        return replacedString;
    }

}
