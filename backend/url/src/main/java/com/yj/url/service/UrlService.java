package com.yj.url.service;

import org.springframework.stereotype.Service;
import static com.yj.url.logic.GenerateShortUrl.isUrlValid;

import static com.yj.url.logic.GenerateShortUrl.HashUrl;

import com.yj.url.model.Url;
import com.yj.url.repository.UrlRepository;
@Service
public class UrlService {
private UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
    this.urlRepository = urlRepository;
}

public Url getOriginalUrl(String shortUrl) {
    return urlRepository.findTopByShortUrl(shortUrl);
}

public Url generateShortUrl(String url) {
    if(! isUrlValid(url)) {
        System.out.println("URL is not valid");
        return null;
    }

    Url urlObject = new Url();
    urlObject.setOriginalUrl(url);
    urlObject.setShortUrl(HashUrl(url));

    return urlRepository.save(urlObject);
}
}