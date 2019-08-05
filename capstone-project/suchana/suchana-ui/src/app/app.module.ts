import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsComponent } from './news/news.component';
import { SportsComponent } from './sports/sports.component';
import { PoliticsComponent } from './politics/politics.component';
import {HttpClientModule} from "@angular/common/http";
import { ScienceComponent } from './science/science.component';
import {AdminModule} from "./admin/admin.module";
import { HeaderComponent } from './header/header.component';
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {AuthModule} from "./auth/auth.module";

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    SportsComponent,
    PoliticsComponent,
    ScienceComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AdminModule,
    AuthModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
