package com.digitalspace.loginauthapi.domain.appointment;

public enum AppointmentType {
    VIRTUAL("virtual"),
    PRESENCIAL("presencial");

    private String type;


    AppointmentType(String virtual) {
        this.type = virtual;
    }

    public String getType(){
        return type;
    }
}
