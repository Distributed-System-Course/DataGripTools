package com.example.datagriptoolsdesign.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserBean {
    private String username;
    private String passward;

    public String getPassward() {
        return passward;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }
}
