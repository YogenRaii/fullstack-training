import { Component, OnInit } from '@angular/core';
import {NewsService} from "../services/news.service";

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent implements OnInit {
  sportsNews = [];
  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsService.getNews('Sports').subscribe((data) => this.sportsNews = data);
  }

}
