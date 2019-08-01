import {Component, OnInit} from '@angular/core';
import {NewsService} from "../services/news.service";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  /*allNews = [
    {
      title: "1. Test Newssss",
      content: "1. Test Conteessssss",
      author: {
        firstName: "Yogen",
        lastName: "Rai"
      },
      category: {
        id: 1,
        name: "Sports"
      }
    },
    {
      title: "2. Test Newssss",
      content: "2. Test Conteessssss",
      author: {
        firstName: "Dheeraj",
        lastName: "Rai"
      },
      category: {
        id: 1,
        name: "Politics"
      }
    }
  ];*/

  allNews = [];

  constructor(private newsService: NewsService) {
  }

  ngOnInit() {
    this.newsService.getNews().subscribe((data) => this.allNews = data);
  }

}
