package com.matiss.entertainment_storage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matiss.entertainment_storage.dto.MediaItemRequestDTO;
import com.matiss.entertainment_storage.dto.MediaItemResponseDTO;
import com.matiss.entertainment_storage.exception.MediaItemNotFoundException;
import com.matiss.entertainment_storage.model.MediaItem;
import com.matiss.entertainment_storage.repository.MediaItemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MediaItemService {

    private final MediaItemRepository mediaItemRepository;

    public List<MediaItemResponseDTO> getAllMediaItems() {
        return mediaItemRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public MediaItemResponseDTO postNewMediaItem(MediaItemRequestDTO request) {
        return toResponse(mediaItemRepository.save(toEntity(request)));
    }

    public void removeMediaItem(Long id) {
        mediaItemRepository.deleteById(id);
    }

    public MediaItemResponseDTO updateMediaItem(Long id, MediaItemRequestDTO request) {
        MediaItem existingMediaItem = mediaItemRepository.findById(id)
                .orElseThrow(() -> new MediaItemNotFoundException("No media item was found with this id."));
        existingMediaItem.setTitle(request.getTitle());
        existingMediaItem.setType(request.getType());
        existingMediaItem.setGenre(request.getGenre());
        existingMediaItem.setRating(request.getRating());
        existingMediaItem.setStatus(request.getStatus());
        return toResponse(mediaItemRepository.save(existingMediaItem));
    }

    public MediaItemResponseDTO getMediaItemById(Long id) {
        return toResponse(mediaItemRepository.findById(id)
                .orElseThrow(() -> new MediaItemNotFoundException("No media item was found with this id.")));
    }

    private MediaItem toEntity(MediaItemRequestDTO mediaItemRequest) {
        MediaItem mediaItem = new MediaItem();
        mediaItem.setTitle(mediaItemRequest.getTitle());
        mediaItem.setType(mediaItemRequest.getType());
        mediaItem.setGenre(mediaItemRequest.getGenre());
        mediaItem.setRating(mediaItemRequest.getRating());
        mediaItem.setStatus(mediaItemRequest.getStatus());
        return mediaItem;
    }

    private MediaItemResponseDTO toResponse(MediaItem item) {
        return new MediaItemResponseDTO(
                item.getId(),
                item.getTitle(),
                item.getType(),
                item.getGenre(),
                item.getRating(),
                item.getStatus());
    }
}