package com.meditech.docseeker.healing.mapping;


import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.healing.resource.CreateNewResource;
import com.meditech.docseeker.healing.resource.NewResource;
import com.meditech.docseeker.healing.resource.UpdateNewResource;
import com.meditech.docseeker.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


public class NewMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public NewResource toResource(New model){
        return mapper.map(model,NewResource.class);
    }

    public Page<NewResource> modelListPage(List<New>modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, NewResource.class),pageable, modelList.size());
    }

    public New toModel(CreateNewResource resource){
        return mapper.map(resource, New.class);
    }

    public New toModel(UpdateNewResource resource){
        return mapper.map(resource, New.class);
    }
}
