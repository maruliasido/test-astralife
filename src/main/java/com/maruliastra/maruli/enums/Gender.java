package com.maruliastra.maruli.enums;
import java.util.stream.Stream;

public enum Gender {

    M("M"),
    F("F");

    private String gender;

    private Gender(String gender){
        this.gender = gender;
    }

    public String getValue(){
        return this.gender;
    }

    public static Gender of(String value) {
        return (Gender) Stream.of(values()).filter((r) -> {
            return r.getValue().equals(value);
        }).findFirst().orElseThrow(IllegalArgumentException::new);
    }

}
