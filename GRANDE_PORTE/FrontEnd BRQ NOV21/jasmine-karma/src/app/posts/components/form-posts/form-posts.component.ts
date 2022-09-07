import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PostModel } from '../../models/post.model';

@Component({
  selector: 'app-form-posts',
  templateUrl: './form-posts.component.html',
  styleUrls: ['./form-posts.component.less']
})
export class FormPostsComponent implements OnInit {

  form : FormGroup;

  @Output()
  formEvent = new EventEmitter<PostModel>();


  constructor(private fb : FormBuilder) { }

  ngOnInit(): void {
    this.createForm();
  }

  submitForm(){
    let post = new PostModel();
    post.body = this.form.value.body;
    post.title = this.form.value.title;
    post.userId = this.getRandomInt();
    //console.log(post)

    this.formEvent.emit(post);
    this.createForm();

  }

  private getRandomInt(){
    return Math.floor(Math.random() * 100);
  }

  private createForm(){
    this.form = this.fb.group({
      title : [null, [Validators.required]],
      body : [null, [Validators.required]]
    });
  }

}
