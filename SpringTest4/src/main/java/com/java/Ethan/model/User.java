package com.java.Ethan.model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class User {
    private int ID;
    public void setId(int i) {
        this.ID = i;
    }
    @Override
    public String toString() {
        return "USer{" +
                "ID=" + ID +
                '}';
    }
}
