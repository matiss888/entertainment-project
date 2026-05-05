package com.matiss.entertainment_storage.service;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.stereotype.Service;

import com.matiss.entertainment_storage.exception.MediaItemNotFoundException;
import com.matiss.entertainment_storage.model.MediaItem;
import com.matiss.entertainment_storage.repository.MediaItemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class MediaItemService {

    private final MediaItemRepository mediaItemRepository;

    public List<MediaItem> getAllMediaItems() {
        return mediaItemRepository.findAll();
    }

    public MediaItem postNewMediaItem(MediaItem newMediaItem) {
        MediaItem saveMediaItem = mediaItemRepository.save(newMediaItem);
        return saveMediaItem;
    }

    public void removeMediaItem(Long id) {
        mediaItemRepository.deleteById(id);
    }

    public MediaItem updateMediaItem(Long id, MediaItem mediaItem) {
        MediaItem foundMediaItem = mediaItemRepository.findById(id)
                .orElseThrow(() -> new MediaItemNotFoundException("No media item was found with this id."));
        MediaItem updatedMediaItem = foundMediaItem;
        updatedMediaItem.setGenre(mediaItem.getGenre());
        updatedMediaItem.setRating(mediaItem.getRating());
        updatedMediaItem.setStatus(mediaItem.getStatus());
        updatedMediaItem.setTitle(mediaItem.getTitle());
        updatedMediaItem.setType(mediaItem.getType());
        mediaItemRepository.save(updatedMediaItem);
        return updatedMediaItem;

    }

}
