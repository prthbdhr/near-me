package com.app.nearme.controller;

import com.app.nearme.dto.RequestDTO;
import com.app.nearme.dto.ResponseDTO;
import com.app.nearme.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/nearme")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/search")
    public ResponseEntity<Page<ResponseDTO>> search(@RequestBody RequestDTO request) {
        Page<ResponseDTO> results = placeService.search(request);
        return ResponseEntity.ok(results);
    }
}
