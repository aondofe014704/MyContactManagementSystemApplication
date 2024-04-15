package org.contactManagementSystem.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {
    boolean isSuccessful;
    Object RegistrationResponse;
}
