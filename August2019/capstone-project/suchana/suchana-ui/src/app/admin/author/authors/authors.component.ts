import { Component, OnInit } from '@angular/core';
import {AuthorService} from "../../../services/author.service";
import {CategoryService} from "../../../services/category.service";
import {Author} from "../../../models/Author";

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {
  authors = [];
  categories = [];

  author: Author;

  constructor(private authorService: AuthorService, private categoryService: CategoryService) { }

  ngOnInit() {
    this.getAuthors();
    this.getCategories();
  }

  getCategories(){
    this.categoryService.getCategories().subscribe(data => {
      this.categories = data;
    })
  }

  getAuthors(){
    this.authorService.getAuthors().subscribe(data => {
      this.authors = data;
    });
  }

  editAuthor(author) {
    this.author = author;
  }

  submitEditAuthor() {
    this.authorService.updateAuthor(this.author).subscribe(() => this.getAuthors());
    this.author = null;
  }

  createAuthor(author){
    this.authorService.createAuthor(author).subscribe( (data) =>
      this.authors.push(data));
  }

  cancel(){
    this.author = null;
  }

  createAuthorForm() {

  }

}
