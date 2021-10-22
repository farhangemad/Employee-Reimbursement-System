package org.example;


import io.javalin.http.staticfiles.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.controller.Insert;
import org.example.controller.Login;
import org.example.controller.Manipulation;
import org.example.dao.RequestDao;
import org.example.dao.UserDao;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

/*import io.javalin.http.staticfiles.Location;
import org.example.models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;*/

import java.util.List;

/**
 * Routes are established here
 *
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.trace("Entering application.");



        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.addStaticFiles("/public", Location.CLASSPATH);

            javalinConfig.showJavalinBanner = false;
            javalinConfig.defaultContentType = "application/json";


        }).start(7000);
        System.out.println("Server is running on Port 7000");

        app.routes(() -> {
            path("/index", () -> {
                /*get(Manipulation::checkLogin);*/
                post(Manipulation::checkLogin);
            });

            path("/manager", () -> {
                get(Manipulation::getRequests);
                post(Manipulation::getUsers);

            });

            path("/employee", () -> {
                get(Manipulation::getRequests);
                post(Manipulation::getUsers);

            });

            path("/employee/req", () -> {
                //get(Manipulation::getRequests);
                post(Manipulation::setRequest);

            });


        });

    }

}



