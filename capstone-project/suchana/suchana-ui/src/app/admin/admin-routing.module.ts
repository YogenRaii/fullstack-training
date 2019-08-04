import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminComponent} from "./admin.component";
import {TagsComponent} from "./tag/tags/tags.component";
import {AuthorsComponent} from "./author/authors/authors.component";

const routes: Routes = [
  {
    path: 'admin',
    component: AdminComponent,
    children: [
      {
        path: 'tags',
        component: TagsComponent
      },
      {
        path: 'authors',
        component: AuthorsComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
