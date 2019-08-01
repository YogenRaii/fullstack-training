import { Component, OnInit } from '@angular/core';
import {NewsService} from "../services/news.service";

@Component({
  selector: 'app-science',
  templateUrl: './science.component.html',
  styleUrls: ['./science.component.css']
})
export class ScienceComponent implements OnInit {

  scienceNews = [];
  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsService.getNews('Science').subscribe((data) => this.scienceNews = data);
  }

}
