package com.azhar.hospital.db.type;

public enum UsersType {
    ADMIN(1, "admin"), DOCTOR(2, "doctor"), NURSE(3, "nurse"), RECEPTION(4, "reception");
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

    private UsersType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public static UsersType getUserTypeById(int id) {
        for (UsersType usertype : UsersType.values()) {
            if (usertype.getId() == id) {
                return usertype;
            }
        }
        return null;
    }
    
    public static UsersType getUserTypeByType(String type) {
        for (UsersType usertype : UsersType.values()) {
            if (usertype.getType() == type) {
                return usertype;
            }
        }
        return null;
    }
}
