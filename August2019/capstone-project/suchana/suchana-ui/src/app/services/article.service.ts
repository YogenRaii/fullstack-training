import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient) { }

  getArticles(authorId): Observable<any> {
    return this.http.get(Constants.API_BASE_URL + "/authors/" + authorId + "/articles");
  }
}
