package com.meditech.docseeker.healing.domain.service;


import com.meditech.docseeker.healing.domain.model.entity.New;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewService {

    Page<New> getAll(Pageable pageable);

    New getById(Long newId);

    List<New> getAll();
    New create(New newapp);

    New update(Long newId, New request);

    ResponseEntity<?> delete(Long newId);
}
