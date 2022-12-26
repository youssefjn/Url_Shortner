import { Component, OnInit } from '@angular/core';
import { UrlShortnerService } from './service/url-shortner.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'urlShortner';
  url: any;
  originalUrl: string = "";
  isUrlGenerated: boolean = false;
  isErrorGenerated: boolean = false;
  shortUrl: string = "";

  constructor(private urlShortnerService: UrlShortnerService) { }

  ngOnInit(): void {
    this.isUrlGenerated = false;
  }

  generateShortUrl() {
    this.urlShortnerService.getShortUrl(this.url).subscribe({
      next: res => {
        if (res == null) {
          this.isErrorGenerated = true;
        }
        else {
          this.isUrlGenerated = true;
          this.isErrorGenerated = false;
      
          this.shortUrl = res.shortUrl;
          this.originalUrl = res.originalUrl;
          console.log(this.url);
          console.log(this.shortUrl);
          console.log(this.originalUrl);
          console.log(this.url.shortUrl);

        }
      },
      error: err => {
        this.isUrlGenerated = false;
        this.isErrorGenerated = true;
      }
    })
  }
}

