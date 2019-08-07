import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthorComponent} from "./author.component";
import {ArticlesComponent} from "./articles/articles.component";
import {AuthorCanActivateGuard} from "../services/author-can-activate.guard";

const routes: Routes = [
  {
    path: 'author',
    component: AuthorComponent,
    canActivate: [AuthorCanActivateGuard],
    children: [
      {
        path: 'articles',
        component: ArticlesComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AuthorRoutingModule { }
