package Util;

public class User {

    String fname;
    String lname;
    String dob;
    Integer age;

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public User(String fname, String lname, String dob, Integer age) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.age = age;
    }

    
    
}
