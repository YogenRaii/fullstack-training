import { Component, OnInit } from '@angular/core';
import {TagService} from "../../../services/tag.service";
import {Tag} from "../../../models/Tag";

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {

  tags = [];

  editingTag = false;
  tagToEdit;

  // to create tag
  creatingTag = false;
  tagToCreate;

  constructor(private tagService: TagService) { }

  ngOnInit() {
    this.getTags();
  }

  getTags() {
    this.tagService.getTags().subscribe(data => this.tags = data);
  }

  editTag(tag) {
    this.editingTag = true;
    this.tagToEdit = tag;
  }

  submitTagEdit(tag) {
    this.editingTag = false;
    this.tagService.updateTag(tag).subscribe((data) => this.tagToEdit = data);
  }

  deleteTag(tag) {
    this.tagService.deleteTag(tag.id).subscribe(() => this.getTags());
  }

  createTagForm() {
    this.creatingTag = true;
    this.tagToCreate = new Tag();
  }

  createTag(tag) {
    this.tagService.createTag(tag).subscribe((data) => this.tags.push(data));
    this.creatingTag = false;
  }

  cancel() {
    this.editingTag = false;
    this.creatingTag = false;
  }
}
