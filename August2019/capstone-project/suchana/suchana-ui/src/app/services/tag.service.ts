import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class TagService {

  API_BASE_URL = "http://localhost:8080";

  constructor(private http: HttpClient, private authService: AuthService) { }

  getTags(): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem('loggedInUser')).token
    });
    return this.http.get(this.API_BASE_URL + "/tags", {headers});
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
