/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author ASUS
 */
public class WebServiceTester {
    private Client client;
    private String REST_SERVICE_URL = "http://localhost:8080/UserManagement/rest/UserService/users";
    private static final String SUCCESS_RESULT = "<result>success</result>";
    private static final String PASS = "Pass";
    private static final String FAIL = "Fail";
    
    private void init(){
        this.client = ClientBuilder.newClient();
    }
    
    public static void  main(String[] args){
        WebServiceTester tester = new WebServiceTester();
        //Initialize the tester
        tester.init();
        //Test get all users Web Service Method
        tester.testGetAllUsers();        
        //Test get user Web Service Method
        tester.testGetUser();
        //Test update user Web Service Method
        tester.testUpdateUser();
        //Test add user Web Service Method
        tester.testAddUser();
        //Test delete user Web Service Method
        tester.testDeleteUser();
    }

    //Test: Get list of all users
   
    private void testGetAllUsers() {
        GenericType<List<User>> list = new GenericType<List<User>>(){};
        List<User> users = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML).get(list);
        String result = PASS;
        //Check if list is not empty
        if(users.isEmpty()){
            result = FAIL;
        }
        System.out.println("Test Case Name: testGetAllUsers, Result: " + result);
    }

    //Test: Get User by id
    private void testGetUser() {
        User sampleUser = new User();
        sampleUser.setId(1);
        
        User user = client.target(REST_SERVICE_URL).path("/{userid}").resolveTemplate("userid", 1).request(MediaType.APPLICATION_XML).get(User.class);
        String result = FAIL;
        //Check if user is same as sample user
        if(sampleUser != null && sampleUser.getId() == user.getId()){
            result = PASS;
        }
        System.out.println("Test Case Name: testGetUser, Result: " + result);
    }

    //Test: Update User having id 1
    private void testUpdateUser() {
        Form form = new Form();
        form.param("id", "1");
        form.param("name", "Anushka Raj");
        form.param("jobRole", "Software Engineer");
        
        String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML).put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
        String result = PASS;
        //Check if result is success XML
        if(!SUCCESS_RESULT.equals(callResult)){
            result = FAIL;
        }
        System.out.println("Test Case name: testUpdate, Result: " + result);
    }

    //Test: Add User having id 2
    private void testAddUser() {
     Form form = new Form();
     form.param("id", "2");
     form.param("name", "Jazzy");
     form.param("jobRole", "Musician");
     
     String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
     String result = PASS;
     //Check if result is success XML
     if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
     }
     System.out.println("Test Case Name: testAddUser, Result " + result);
    }

    //Test: Delete User of id 2
    private void testDeleteUser() {
        String callResult = client.target(REST_SERVICE_URL).path("/{userid}").resolveTemplate("userid", 2).request(MediaType.APPLICATION_XML).delete(String.class);
        String result = PASS;
        
        //Check if result is success XML
        if(!SUCCESS_RESULT.equals(callResult)){
            result = FAIL;
        }
        System.out.println("Test Case Name: testDeleteUser, Result : " + result);
    }

}
