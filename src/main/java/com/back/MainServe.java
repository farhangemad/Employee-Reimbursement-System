package com.back;

/*import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.connectors.PostgreSQLConnector;
import com.back.dao.UserDao;
import com.back.models.UserModel;
import io.javalin.http.JavalinServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;*/

import javax.servlet.http.HttpServlet;

public class MainServe extends HttpServlet {

    /*private JavalinServlet javalinServlet;
    private PostgreSQLConnector connector;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        javalinServlet.service(req, resp);
    }

    @Override
    public void destroy() {
        javalinServlet.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        Properties properties = new Properties();
        try {
            String path = config.getServletContext().getRealPath("WEB-INF/db.properties");
            properties.load(new FileInputStream(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        connector = new PostgreSQLConnector(properties);


    }*/

    /*UserDao user = new UserDao();
    UserModel out = new UserModel();*/

}


