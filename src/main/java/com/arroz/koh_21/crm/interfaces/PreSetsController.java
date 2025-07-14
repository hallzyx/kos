package com.arroz.koh_21.crm.interfaces;

import com.arroz.koh_21.crm.domain.model.aggregates.PreSet;
import com.arroz.koh_21.crm.domain.services.PreSetCommandService;
import com.arroz.koh_21.crm.interfaces.resources.CreatePreSetResource;
import com.arroz.koh_21.crm.interfaces.resources.PresetResource;
import com.arroz.koh_21.crm.interfaces.transform.CreatePreSetCommandFromResourceAssembler;
import com.arroz.koh_21.crm.interfaces.transform.PreSetResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/v1/presets", produces = APPLICATION_JSON_VALUE)
@Tag(name= "PreSets", description = "Available PreSet Endpoints")
public class PreSetsController {
    private final PreSetCommandService preSetCommandService;
    public PreSetsController(PreSetCommandService preSetCommandService) {
        this.preSetCommandService = preSetCommandService;
    }

    @PostMapping("customers/{customerId}/products/{productId}/pres-sets")
    @Operation(summary = "Create a new PreSet")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "PreSet created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> CreatePreSet(
            @PathVariable String customerId,
            @PathVariable String productId,
            CreatePreSetResource resource
    ){
        try{
            var command = CreatePreSetCommandFromResourceAssembler.ToCommandFromResource(productId, customerId, resource);
            var newPreSet = preSetCommandService.Handle(command).map(
                    PreSetResourceFromEntityAssembler::ToResourceFromEntity
            ).orElseThrow(
                    () -> new RuntimeException("Failed to create PreSet")
            );
            return new ResponseEntity<>(newPreSet,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "error",e.getMessage(),
                            "status", HttpStatus.BAD_REQUEST
                    )
            );
        }



    }
}
