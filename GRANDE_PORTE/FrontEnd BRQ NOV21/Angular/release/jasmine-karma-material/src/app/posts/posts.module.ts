import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PostsRoutingModule } from './posts-routing.module';
import { FormPostsComponent } from './components/form-posts/form-posts.component';
import { SharedModule } from '../shared/shared.module';
import { ListPostsComponent } from './components/list-posts/list-posts.component';


@NgModule({
  declarations: [
    ListPostsComponent,
    FormPostsComponent
  ],
  imports: [
    CommonModule,
    PostsRoutingModule,
    SharedModule
  ]
})
export class PostsModule { }
