package org.contactManagementSystem.dtos.requests;


import lombok.Data;

@Data
public class LogOutRequest {
    private String userName;
    private String message;
}
