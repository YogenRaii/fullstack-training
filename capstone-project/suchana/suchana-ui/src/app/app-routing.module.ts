import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NewsComponent} from "./news/news.component";
import {SportsComponent} from "./sports/sports.component";
import {PoliticsComponent} from "./politics/politics.component";
import {ScienceComponent} from "./science/science.component";

const routes: Routes = [
  {
    path: "news",
    component: NewsComponent
  },
  {
    path: "Sports",
    component: SportsComponent
  },
  {
    path: "Politics",
    component: PoliticsComponent
  },
  {
    path: 'Science',
    component: ScienceComponent
  },
  {
    path: '',
    redirectTo: 'news',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
