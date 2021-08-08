package com.azhar.hospital.db.vo;

/**
 *
 * @author fastox
 */
public class PatientInfoVo {

    private int id;
    private String firstName;
    private String fatherName;
    private String mobile;
    private String email;
    private UsersVo usersVo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsersVo getUsersVo() {
        return usersVo;
    }

    public void setUsersVo(UsersVo usersVo) {
        this.usersVo = usersVo;
    }
}
