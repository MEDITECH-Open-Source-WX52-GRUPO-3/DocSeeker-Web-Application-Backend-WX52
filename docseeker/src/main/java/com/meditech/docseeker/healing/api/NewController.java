package com.meditech.docseeker.healing.api;


import com.meditech.docseeker.healing.domain.service.NewService;
import com.meditech.docseeker.healing.mapping.NewMapper;
import com.meditech.docseeker.healing.resource.CreateNewResource;
import com.meditech.docseeker.healing.resource.NewResource;
import com.meditech.docseeker.healing.resource.UpdateNewResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "meditech")
@RestController
@RequestMapping(value = "api/v1/news", produces = "application/json")
@Tag(name = "news", description = "Create, read, update and delete news")
public class NewController {

    private final NewService newService;
    private final NewMapper mapper;


    public NewController(NewService newService, NewMapper mapper) {
        this.newService = newService;
        this.mapper = mapper;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create New", responses = {
            @ApiResponse(description = "New successfully created", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewResource.class)))
    })
    public ResponseEntity<NewResource> createNew(CreateNewResource resource){
        return new ResponseEntity<>(mapper.toResource(newService.create(mapper.toModel(resource))),
                HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all News")
    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    public Page<NewResource> getAllNews(Pageable pageable){
        return mapper.modelListPage(newService.getAll(), pageable);
    }

    @GetMapping("{newId}")
    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @Operation(summary = "Get students By Id")
    public NewResource getNewById(@PathVariable Long newId){
        return mapper.toResource(newService.getById(newId));
    }

    @PutMapping("{newId}")
    @PreAuthorize("hasRole('ADMIN')")
    public NewResource updateNew(@PathVariable Long newId, UpdateNewResource resource){
        return mapper.toResource(newService.update(newId, mapper.toModel(resource)));
    }

    @DeleteMapping("{newId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteNew(Long newId){
        return newService.delete(newId);
    }


}
