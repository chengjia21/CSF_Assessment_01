// import { PostPayload } from './../models/postpayload.model';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit, inject } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Tags } from '../models/tags.model';
import { PostServiceService } from '../post-service.service';
import { PostPayload } from '../models/postpayload.model';

@Component({
  selector: 'app-view2',
  templateUrl: './view2.component.html',
  styleUrls: ['./view2.component.css']
})
export class View2Component implements OnInit {

// http = createInjectableType(HttpClientModule);

  shareNewsForm!: FormGroup;
  formTags!: string[];

  tagForm!: FormGroup;
  private postService = inject(PostServiceService);

  postPayload !: PostPayload;

  constructor() { }



  ngOnInit() {
    this.shareNewsForm = new FormGroup({
      userData: new FormGroup({
        title: new FormControl(null, [
          Validators.required,
          Validators.minLength(5)

        ]),
        photo: new FormControl(
          null,
          [Validators.required],

        ),
      }),
      description: new FormControl(
        null,
        [Validators.required, Validators.minLength(5)],

      ),
      // tags: new FormArray([]),

    });

    this.tagForm= new FormGroup({"tags": new FormControl()});
  }


  postNewsfromView2(){

    this.postService.onCreateNewsPost(this.postPayload);
  }

  uploadPhoto(){}

  addTags(tagInput: string[]){

    this.formTags.concat(tagInput);
  }




}
