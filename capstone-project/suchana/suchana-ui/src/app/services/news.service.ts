import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  API_BASE_URL = "http://localhost:8080";

  // inject httpClient into service
  constructor(private http: HttpClient) { }

  getAllNews(): Observable<any> {
    return this.http.get(this.API_BASE_URL + "/articles");
  }

}
