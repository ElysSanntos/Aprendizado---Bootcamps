import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormPostsComponent } from '../form-posts/form-posts.component';

import { ListPostsComponent } from './list-posts.component';

import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { PostService } from '../../services/post.service';
import { PostModel } from '../../models/post.model';


import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSidenavModule } from '@angular/material/sidenav';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 
import { Observable } from 'rxjs';
import { of } from 'rxjs';

describe('ListPostsComponent', () => {
  let component: ListPostsComponent;
  let fixture: ComponentFixture<ListPostsComponent>;
  let postService : PostService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPostsComponent, FormPostsComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule, 
        FormsModule,

        MatButtonModule,
        MatSidenavModule,
        MatFormFieldModule,
        MatInputModule,

        BrowserAnimationsModule
      ],
      providers: [PostService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('saveOrUpdatePost test', ()=>{
    let lengthOld = component.dataSource.length;

    let post = new PostModel();
    post.body = 'body';
    post.title = 'title';
    post.userId = 1;
    post.id = 1;

    component.saveOrUpdatePost(post);

    expect(component.dataSource.length).toBe(lengthOld+1);
  })

  it('delete test', ()=>{

    //cenário
    let post = new PostModel();
    post.body = 'body';
    post.title = 'title';
    post.userId = 1;
    post.id = 1;

    //inserindo um post
    component.dataSource.push(post);

    // tamanho anterior a remoção
    let lengthOld = component.dataSource.length;

    //execução
    component.onDelete(post);

    //validação
    expect(component.dataSource.length).toBe(lengthOld-1);
  })

  it('getAll test', ()=>{
    postService = TestBed.inject(PostService);

    const postResponse : PostModel[] = [
      {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
      }
    ]

    spyOn(postService, 'getAll').and.returnValue( of(postResponse) );

    component.ngOnInit();
    
    
    expect(component.dataSource).toEqual(postResponse)
   
  })
});
