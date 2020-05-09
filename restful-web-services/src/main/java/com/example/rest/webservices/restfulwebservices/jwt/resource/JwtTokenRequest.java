package com.example.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

    
    /*
     {
    "token": " .eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU4ODE1OTA5MSwiaWF0IjoxNTg3NTU0MjkxfQ.X5FqeLkCnPBKnXm1anzsoZ3734qL5o2cUtTh9iM6iKYASFlicgT8Xbs-rscDTTajBGgP_bmsw4Fvqv7SGxzDJQ"
}

     */
    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

