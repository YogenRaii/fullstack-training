import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {AuthService} from "../services/auth.service";

@Injectable()
export class ApiService implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const loggedInUser = this.authService.loggedInUser();
    if (loggedInUser != null) {
      const authReq = req.clone({
        headers: new HttpHeaders({
          'Content-Type':  'application/json',
          'Authorization': 'Bearer ' + loggedInUser.token
        })
      });

      console.log('Intercepted HTTP call', authReq);
      return next.handle(authReq);
    }
    return next.handle(req);
  }
}
