package org.example.controller;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jetbrains.annotations.NotNull;


public class Manipulation {

    private static final Logger logger = LogManager.getLogger(Manipulation.class.getName());


    /**
     * This checks credentials
     * @param context
     * @throws Exception
     */
    public static void checkLogin(@NotNull Context context) throws Exception {
        logger.trace("Checking credentials");
        Login login = new Login();
        login.handle(context);

    }

    /**
     * Here, you get all users
     * @param context
     * @throws Exception
     */
    public static void getUsers(@NotNull Context context) throws Exception {
        logger.trace("Getting users");
        Users users = new Users();
        users.handle(context);
    }

    /**
     * Here, you get all requests
     * @param context
     * @throws Exception
     */
    public static void getRequests(@NotNull Context context) throws Exception {
        logger.trace("Getting requests");
        Requests requests = new Requests();
        requests.handle(context);
    }

    /**
     * This allows insertion of new request
     * @param context
     * @throws Exception
     */
    public static void setRequest(@NotNull Context context) throws Exception {
        logger.trace("Setting request");
        Insert insert = new Insert();
        insert.handle(context);
    }
}
