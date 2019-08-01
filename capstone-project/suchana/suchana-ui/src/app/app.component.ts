import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CategoryService} from "./services/category.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Suchana';
  name = "Yogen";

  categories = [];

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe((data) => {
      console.log(data);
      this.categories = data;
    } );
  }
}
