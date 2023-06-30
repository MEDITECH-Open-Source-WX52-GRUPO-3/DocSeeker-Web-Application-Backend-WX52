package com.meditech.docseeker.security.domain.service.communication;


import com.meditech.docseeker.security.resource.UserResource;
import com.meditech.docseeker.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}