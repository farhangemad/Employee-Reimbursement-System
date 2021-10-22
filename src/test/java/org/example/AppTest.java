package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.controller.Logic;
import org.example.models.RequestModel;
import org.example.models.UserModel;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void userLine() {
        String expected = "tom---red---mailing---555";
        UserModel user1 = new UserModel();
        user1.setId(1);
        user1.setUsername("will");
        user1.setPasswd("wall");
        user1.setFirstname("tom");
        user1.setLastname("red");
        user1.setEmail("mailing");
        user1.setPhone("555");
        user1.setSuperstatus(true);
        Logic logic = new Logic();
        String actual = logic.buildUsers(user1);

        /*Logic service = new Logic();
        String actual = service.buildUsers(iterateOver, credentials);*/
        assertEquals(expected, actual);
    }

    @Test
    public void requestLine() {
        String expected = "1----22.22---tom---2021-10-11_02*11*57.634556---true---1";
        RequestModel request1 = new RequestModel();
        request1.setId(1);
        request1.setEmployee_id(1);
        request1.setAmount(22.22);
        request1.setReason("tom");
        request1.setTimecreated(Timestamp.valueOf("2021-10-11 02:11:57.634556"));
        request1.setApproved(true);
        request1.setApproverid(1);

        Logic logic = new Logic();
        String actual = logic.buildRequests(request1);

        /*Logic service = new Logic();
        2021-10-11_02*11*57.634556
        String actual = service.buildUsers(iterateOver, credentials);*/
        assertEquals(expected, actual);
    }
}
