package com.restws.ws.restfullws.repo;

import com.restws.ws.restfullws.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Integer> {
}
