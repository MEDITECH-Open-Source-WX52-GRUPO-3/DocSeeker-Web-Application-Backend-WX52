package com.meditech.docseeker.security.domain.service;



import com.meditech.docseeker.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}