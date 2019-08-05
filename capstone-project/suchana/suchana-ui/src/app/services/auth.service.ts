import { Injectable } from '@angular/core';
import {LoginRequest} from "../models/LoginRequest";
import {Observable} from "rxjs/internal/Observable";
import {HttpClient} from "@angular/common/http";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(user: LoginRequest): Observable<any> {
    return this.http.post(Constants.API_BASE_URL + "/user/login", user);
  }
}
