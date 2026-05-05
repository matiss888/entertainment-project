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

import com.matiss.entertainment_storage.model.MediaItem;
import com.matiss.entertainment_storage.service.MediaItemService;

import lombok.AllArgsConstructor;

@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor

public class MediaItemController {

    private final MediaItemService mediaItemService;

    @GetMapping("/media_items")
    public ResponseEntity<List<MediaItem>> getAllMediaItems() {
        List<MediaItem> allMediaItems = mediaItemService.getAllMediaItems();
        return new ResponseEntity<>(allMediaItems, HttpStatus.OK);
    }

    @PostMapping("/media_item")
    public ResponseEntity<MediaItem> postMediaItem(@RequestBody @Valid MediaItem mediaItem) {
        MediaItem newMediaItem = mediaItemService.postNewMediaItem(mediaItem);
        return new ResponseEntity<>(newMediaItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/media_items/{mediaItemID}")
    public ResponseEntity<?> removeMediaItem(@PathVariable Long mediaItemID) {
        mediaItemService.removeMediaItem(mediaItemID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/media_items/update/{id}")
    public ResponseEntity<MediaItem> updateMediaItem(@PathVariable Long id, @RequestBody @Valid MediaItem mediaItem) {
        MediaItem updatedMediaItem = mediaItemService.updateMediaItem(id, mediaItem);
        return new ResponseEntity<MediaItem>(updatedMediaItem, HttpStatus.OK);
    }

    @GetMapping("/media_items/get/{id}")
    public ResponseEntity<MediaItem> getOneMediaItem(@PathVariable Long id) {
        MediaItem oneMediaItem = mediaItemService.getMediaItemById(id);
        return new ResponseEntity<MediaItem>(oneMediaItem, HttpStatus.OK);
    }

}
