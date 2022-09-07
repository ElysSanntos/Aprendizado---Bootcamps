import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursesListComponent } from './courses/courses-list/courses-list.component';
import { BloqueadorGuard } from './guards/bloqueador.guard';

const routes: Routes = [
  {path: 'cursos',
    children:[
      {path: ':nome',
      component: CoursesListComponent,
      canDeactivate: [BloqueadorGuard]},
      {path: 'novo',
      component: CoursesListComponent},
      {path: 'atualizar',
      component: CoursesListComponent}
    ]
  }
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
