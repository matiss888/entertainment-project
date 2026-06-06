package com.matiss.entertainment_storage.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.matiss.entertainment_storage.dto.MediaItemRequestDTO;
import com.matiss.entertainment_storage.dto.MediaItemResponseDTO;
import com.matiss.entertainment_storage.service.MediaItemService;

import lombok.AllArgsConstructor;

@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class MediaItemController {

    private final MediaItemService mediaItemService;

    @GetMapping("/media_items")
    public ResponseEntity<List<MediaItemResponseDTO>> getAllMediaItems() {
        return ResponseEntity.ok(mediaItemService.getAllMediaItems());
    }

    @PostMapping("/media_items")
    public ResponseEntity<MediaItemResponseDTO> postMediaItem(@RequestBody @Valid MediaItemRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediaItemService.postNewMediaItem(request));
    }

    @DeleteMapping("/media_items/{mediaItemID}")
    public ResponseEntity<Void> removeMediaItem(@PathVariable Long mediaItemID) {
        mediaItemService.removeMediaItem(mediaItemID);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/media_items/update/{id}")
    public ResponseEntity<MediaItemResponseDTO> updateMediaItem(@PathVariable Long id,
            @RequestBody @Valid MediaItemRequestDTO request) {
        return ResponseEntity.ok(mediaItemService.updateMediaItem(id, request));
    }

    @GetMapping("/media_items/get/{id}")
    public ResponseEntity<MediaItemResponseDTO> getOneMediaItem(@PathVariable Long id) {
        return ResponseEntity.ok(mediaItemService.getMediaItemById(id));
    }
}