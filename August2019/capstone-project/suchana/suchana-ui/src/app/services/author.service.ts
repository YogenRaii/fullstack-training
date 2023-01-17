import {Injectable} from '@angular/core';
import {Observable} from "rxjs/internal/Observable";
import {HttpClient} from "@angular/common/http";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  API_URL = Constants.API_BASE_URL + "/authors";

  constructor(private http: HttpClient) {
  }

  getAuthors(): Observable<any> {
    return this.http.get(this.API_URL);
  }

  getAuthorById(authorId): Observable<any> {
    return this.http.get(this.API_URL + "/" + authorId);
  }

  updateAuthor(author): Observable<any> {
    return this.http.put(this.API_URL + "/" + author.id, author);
  }

  deleteAuthor(authorId): Observable<any> {
    return this.http.delete(this.API_URL + "/" + authorId);
  }

  createAuthor(author): Observable<any> {
    return this.http.post(this.API_URL, author);
  }
}
