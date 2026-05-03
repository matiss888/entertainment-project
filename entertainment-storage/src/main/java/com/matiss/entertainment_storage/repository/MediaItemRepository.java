package com.matiss.entertainment_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matiss.entertainment_storage.model.MediaItem;

@Repository
public interface MediaItemRepository extends JpaRepository<MediaItem, Long> {

}
