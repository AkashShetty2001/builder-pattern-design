package org.example.userObject.main;

import org.example.userObject.schema.User;

public class userApplication {
    public static void main(String []args){

        User user = new User.Builder().
                setUserId(1).
                setFirstName("Akash").
                setEmail("akashkd9911@gmail.com").
                setPassword("12345678").
                setGender('M').build();

        System.out.println(user.getUserId()+" "+user.getFirstName()+" "+user.getGender()+" "+user.getEmail()+" "+user.getPassword());

        System.out.println(user.toString());



    }
}
