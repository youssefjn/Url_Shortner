package com.yj.url.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yj.url.model.Url;
import com.yj.url.service.UrlService;

@RestController
@RequestMapping("/url/shortner")
@CrossOrigin (origins = "*")
public class UrlController {

    private UrlService urlService;
    
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{shortUrl}")
public Url getOriginalUrl(@PathVariable String shortUrl ){
return urlService.getOriginalUrl( shortUrl);

}
@PostMapping
public Url generateShortUrl(@RequestBody String url){
    return urlService.generateShortUrl(url);
}

}
