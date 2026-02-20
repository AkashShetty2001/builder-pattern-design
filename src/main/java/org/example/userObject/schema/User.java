package org.example.userObject.schema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    /*
    Imutable and mandatory properties:
     */

    private final Integer userId;
    private final String firstName;
    private final String email;
    private final String password;
    private final Character gender;

    /*
    non mandatory properties:
     */
    private final String lastName;
    private final Integer phoneNumber;
    private final LocalDate dateOfBirth;
    private final String address;
    private final String companyName;

    private User(Builder builder){
        this.userId=builder.userId;
        this.firstName= builder.firstName;
        this.email= builder.email;
        this.gender=builder.gender;
        this.password= builder.password;

        this.lastName= builder.lastName;;
        this.phoneNumber= builder.phoneNumber;;
        this.dateOfBirth=builder.dateOfBirth;
        this.address= builder.address;
        this.companyName= builder.companyName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Character getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public static class Builder{
        private  Integer userId;
        private  String firstName;
        private  String email;
        private  String password;
        private  Character gender;

        private String lastName;
        private Integer phoneNumber;
        private LocalDate dateOfBirth;
        private String address;
        private String companyName;

        public Builder(){
        }

        public Builder setUserId(Integer userId){
            if(userId == null){
                throw new IllegalArgumentException("user id cannot be empty");
            }
            this.userId=userId;
            return this;
        }

        public Builder setFirstName(String firstName){
            if(firstName == null || firstName.isEmpty()){
                throw new IllegalArgumentException("First Name cannot be empty");
            }
            this.firstName=firstName;
            return this;
        }

        public Builder setEmail(String email){
            if(email ==null || email.isEmpty()){
                throw new IllegalArgumentException("Email is mandatory");
            }

            String temp = email;
            boolean containsSymbol= false;
            for(int i=0;i<temp.length();i++){
                Character current = temp.charAt(i);
                if(current == '@'){
                    containsSymbol = true;
                    break;
                }else{
                    continue;
                }
            }

            if(!containsSymbol){
                throw new IllegalArgumentException("email should contain @");
            }

            this.email=email;
            return this;

        }

        public Builder setPassword(String password){
            if(password == null || password.isEmpty()){
                throw new IllegalArgumentException("password is mandatory");
            }
            Integer passwordLength= password.length();
            Integer lengthConstant = 8;
            if(passwordLength < lengthConstant){
                throw new IllegalArgumentException("Password should contain at least 8 characters");
            }
            this.password=password;
            return this;
        }

        public Builder setGender(Character gender){
            if(gender == null){
                throw new IllegalArgumentException("gender cannot be empty!");
            }
            Character tempGender=Character.toLowerCase(gender);
            List<Character> allowedGenderChar = new ArrayList<>();
            allowedGenderChar.add('m');
            allowedGenderChar.add('f');
            allowedGenderChar.add('t');
            if(!allowedGenderChar.contains(tempGender)){
                throw new IllegalArgumentException("Gender can be one of 'M','F','T'");
            }
            this.gender=gender;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {

            if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Date of birth cannot be in the future");
            }

            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhoneNumber(Integer phoneNumber) {
            if(phoneNumber!=null){
                Integer count =0;
                Integer tempPhoneNumber=phoneNumber;

                while(tempPhoneNumber>0){
                    tempPhoneNumber/=10;
                    count++;
                }

                if(count!=10){
                    throw new IllegalArgumentException("PhoneNumber should be exactly 10 digits!");
                }
            }
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build(){
            if(this.userId == null){
                throw new IllegalArgumentException("user id cannot be empty");
            }

            if(this.firstName == null){
                throw new IllegalArgumentException("first name cannot be empty!");
            }

            if(this.email == null){
                throw new IllegalArgumentException("email is mandatory");
            }

            if(this.password == null) {
                throw new IllegalArgumentException("password is mandatory");
            }

            if(this.gender == null){
                throw new IllegalArgumentException("gender cannot be empty!");
            }
            return new User(this);
        }
    }

}
