package com.meditech.docseeker.security.domain.service.communication;


import com.meditech.docseeker.security.resource.AuthenticateResource;
import com.meditech.docseeker.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}