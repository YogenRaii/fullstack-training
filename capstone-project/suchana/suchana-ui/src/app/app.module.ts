import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsComponent } from './news/news.component';
import { SportsComponent } from './sports/sports.component';
import { PoliticsComponent } from './politics/politics.component';
import {HttpClientModule} from "@angular/common/http";
import { ScienceComponent } from './science/science.component';
import { CategoriesComponent } from './category/categories/categories.component';
import { EditCategoryComponent } from './category/edit-category/edit-category.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    SportsComponent,
    PoliticsComponent,
    ScienceComponent,
    CategoriesComponent,
    EditCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
