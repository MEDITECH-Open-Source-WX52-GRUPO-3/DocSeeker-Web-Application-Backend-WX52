package com.meditech.docseeker.healing.domain.presistence;

import com.meditech.docseeker.healing.domain.model.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<New, Long> {
    New findByTitle(String title);


}
