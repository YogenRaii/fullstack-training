import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class TagService {

  API_BASE_URL = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  getTags(): Observable<any> {
    return this.http.get(this.API_BASE_URL + "/tags");
  }

  updateTag(tag): Observable<any> {
    return this.http.put(this.API_BASE_URL + "/tags/" + tag.id, tag);
  }

  deleteTag(tagId: number): Observable<any> {
    return this.http.delete(this.API_BASE_URL + "/tags/" + tagId);
  }

  createTag(tag): Observable<any> {
    return this.http.post(this.API_BASE_URL + "/tags", tag);
  }
}
