import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormPostsComponent } from '../form-posts/form-posts.component';

import { ListPostsComponent } from './list-posts.component';

import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PostModel } from '../../models/post.model';
import { PostService } from '../../services/post.service';
import { of } from 'rxjs';


describe('ListPostsComponent', () => {
  let component: ListPostsComponent;
  let fixture: ComponentFixture<ListPostsComponent>;
  let postService: PostService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListPostsComponent, FormPostsComponent],
      imports: [
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,

        MatCardModule,
        MatButtonModule,
        MatSidenavModule,

        MatInputModule,
        MatTableModule,
      ],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('delete test when found element', () => {
    // cenário

    //criando obj post
    let post = new PostModel();
    post.body = 'body';
    post.title = 'title';
    post.userId = 1;
    post.id = 1;

    // adicionei o obj Post no final do array
    component.dataSource.push(post);

    //tamanho do array antes de deletar
    let lengthOld = component.dataSource.length;

    // execução
    component.onDelete(post);

    // validação
    expect(component.dataSource.length).toBe(lengthOld - 1);
  });

  it('delete test when not found element', () => {
    // cenário

    //criando obj post
    let post = new PostModel();
    post.body = 'body';
    post.title = 'title';
    post.userId = 1;
    post.id = 1;

    // adicionei o obj Post no final do array
    component.dataSource.push(post);

    //tamanho do array antes de deletar
    let lengthOld = component.dataSource.length;

    // clonar variável post para a variável postDelete
    let postDelete = Object.assign({}, post);
    postDelete.id = 2;

    // execução
    component.onDelete(postDelete);

    // validação
    expect(component.dataSource.length).toBe(lengthOld);
  });

  it('when saveOrUpdatePost receive a new post model and dataSource is Empty', () => {
    // cenário
    let post = {
      title: 'title',
      body: 'body',
      userId: 1,
    };

    //tamanho do array antes de inserir
    let lengthOld = component.dataSource.length;

    // execução
    component.saveOrUpdatePost(post);

    // validação
    expect(component.dataSource.length).toBe(lengthOld + 1);
  });

  it('when saveOrUpdatePost receive a new post model and dataSource is not Empty', () => {
    // cenário

    //criando obj post
    let post = new PostModel();
    post.body = 'body';
    post.title = 'title';
    post.userId = 1;
    post.id = 1;

    // adicionei o obj Post no final do array
    component.dataSource.push(post);

    let postNew = {
      title: 'title',
      body: 'body',
      userId: 1,
    };

    //tamanho do array antes de inserir
    let lengthOld = component.dataSource.length;

    // execução
    component.saveOrUpdatePost(postNew);

    // validação
    expect(component.dataSource.length).toBe(lengthOld + 1);
  })
   it('when saveOrUpdatePost receive a post model exists in dataSource', () => {
     // cenário

     //criando obj post
     let post = new PostModel();
     post.body = 'body';
     post.title = 'title';
     post.userId = 1;
     post.id = 1;

     // adicionei o obj Post no final do array
     component.dataSource.push(post);

     // deve possuir o mesmo id de post para sinalizar uma edição
     let postEdit = {
       title: 'title 2',
       body: 'body 2',
       userId: 1,
       id: 1,
     };

     //tamanho do array antes de inserir
     let lengthOld = component.dataSource.length;

     // execução
     component.saveOrUpdatePost(postEdit);

     // validação
     expect(component.dataSource.length).toBe(lengthOld);
   })

   it('getAll', ()=>{
     //cenario
     postService = TestBed.inject(PostService);
     let postResponse: PostModel[] = [{
       title: 'tile',
       body: 'body',
       id: 1,
       userId: 1
     }];
      spyOn(postService, 'getAll').and.returnValue( of(postResponse));

      //execução
      component.ngOnInit();

      //validação
      //Se o dataSource for igual ao postResponse, então o getAll do componente foi executado com sucesso.
      expect(component.dataSource).toBe(postResponse)
   })
});
