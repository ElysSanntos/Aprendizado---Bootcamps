import { Component, OnInit } from '@angular/core';
import { PostModel } from '../../models/post.model';
import { PostService } from '../../services/post.service';

@Component({
  selector: 'app-list-posts',
  templateUrl: './list-posts.component.html',
  styleUrls: ['./list-posts.component.less'],
})
export class ListPostsComponent implements OnInit {
  displayedColumns: string[] = ['userId', 'id', 'title', 'body'];
  dataSource: PostModel[] = [];

  constructor(private postService: PostService) {}

  ngOnInit(): void {
    this.getAll();
  }

  saveOrUpdatePost(event: any) {
    // se não há valor no atributo id (caso de inserção)
    if (!event.id) {
      // id (do event) é igual a ao id do último item do array somado de uma unidade

      // não há nenhum elemento no array
      if (this.dataSource.length == 0) {
        event.id = 0;
      } else {
        event.id = this.dataSource[this.dataSource.length - 1].id + 1;
      }

      this.dataSource.push(event);
    } else {
      //edição
      let index = this.dataSource.findIndex((x: PostModel) => event.id == x.id);
      this.dataSource[index] = event;
    }
  }

  onDelete(c: PostModel) {
    let index = this.dataSource.findIndex((x: PostModel) => c.id == x.id);
    //console.log('index', index);
    if (index >= 0) this.dataSource.splice(index, 1);
  }

  private getAll() {
    this.postService.getAll().subscribe({
      next: (data: any) => {
        //console.log(data)
        this.dataSource = data;
      },
    });
  }
}
