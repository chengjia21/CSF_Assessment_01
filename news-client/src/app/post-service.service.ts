import { PostPayload } from './models/postpayload.model';
import { Injectable, inject } from '@angular/core';
import {
  HttpClient,
  // HttpHeaders,
  // HttpParams,
  // HttpEventType
} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PostServiceService {
  http = inject(HttpClient)


  onCreateNewsPost(postData: PostPayload) {
    // Send HTTP POST Request
    this.http.post('/view0/post', postData)
      .subscribe(responseData => {
        console.log(responseData);
      });
  }
  constructor() { }
}
