
package com.azhar.hospital.db.type;

public enum Userstype {
    ADMIN(1,"admin"),DOCTOR(2,"doctor");
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String type;
    private Userstype(int id ,String type){
    this.id=id;
    this.type=type;
    }
    public static Userstype getUserTypeById(int id){
    for(Userstype usertype:Userstype.values()){
    if(usertype.getId() ==id){
    return usertype;
    }
    }return null;
    }
}
