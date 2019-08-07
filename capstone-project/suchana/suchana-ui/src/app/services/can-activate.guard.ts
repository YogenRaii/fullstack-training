import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class CanActivateGuard implements  CanActivate {
  constructor(private router: Router, private authService: AuthService) {
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const loggedInUser = this.authService.loggedInUser();
    if (loggedInUser != null && loggedInUser.role == 'ROLE_ADMIN') {
      return true;
    } else if (loggedInUser != null) {
      this.router.navigate(['/unauthorized'])
    } else {
      this.router.navigate(['/login']);
    }

    return false;
  }

}
