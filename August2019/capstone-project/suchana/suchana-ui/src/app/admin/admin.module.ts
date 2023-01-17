import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TagsComponent } from './tag/tags/tags.component';
import { AdminComponent } from './admin.component';
import {AdminRoutingModule} from "./admin-routing.module";
import {FormsModule} from "@angular/forms";
import { AuthorsComponent } from './author/authors/authors.component';
import { EditAuthorComponent } from './author/edit-author/edit-author.component';
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {ApiService} from "../interceptors/api.service";
import {HTTP_INTERCEPTORS} from "@angular/common/http";

@NgModule({
  declarations: [TagsComponent, AdminComponent, AuthorsComponent, EditAuthorComponent],
  imports: [
    CommonModule,
    FormsModule,
    AdminRoutingModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS, useClass: ApiService, multi: true
  }]
})
export class AdminModule { }
