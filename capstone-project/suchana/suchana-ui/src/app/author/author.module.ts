import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthorComponent } from './author.component';
import {AuthorRoutingModule} from "./author-routing.module";
import { ArticlesComponent } from './articles/articles.component';

@NgModule({
  declarations: [AuthorComponent, ArticlesComponent],
  imports: [
    CommonModule,
    AuthorRoutingModule
  ]
})
export class AuthorModule { }
