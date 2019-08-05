import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Suchana';

  isLoggedIn = false;

  constructor() { }

  ngOnInit() {
    // TODO change this to obserable
    if (localStorage.getItem('loggedInUser') != null) {
      this.isLoggedIn = true;
    }
  }

}
