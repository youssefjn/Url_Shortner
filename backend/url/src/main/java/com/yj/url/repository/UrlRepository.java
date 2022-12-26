package com.yj.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yj.url.model.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {
 
    Url findTopByShortUrl(String id);
}
