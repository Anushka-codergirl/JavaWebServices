/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */

package com.test;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String jobRole; 

    public User(){}
    public User(int id,String name, String jobRole){
        this.id = id;
        this.name = name;
        this.jobRole = jobRole;
    }
    
    public int getId() {
        return id;
    }
    
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    public String getJobRole() {
        return jobRole;
    }
    
    @XmlElement
    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if(object == null){
            return false;
        }else if(!(object instanceof User)){
            return false;
        }else{
            User user = (User)object;
            if(id == user.getId()&& name.equals(user.getName())&& jobRole.equals(user.getJobRole())){
                return true;
            }            
        }
        return false;
    }    
}
