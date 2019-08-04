import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  API_URL = Constants.API_BASE_URL + "/categories";

  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(this.API_URL);
  }
}
