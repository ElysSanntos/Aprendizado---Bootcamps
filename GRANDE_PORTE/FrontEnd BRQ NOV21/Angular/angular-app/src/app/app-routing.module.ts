import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MeuPrimeiroComponent } from './meu-primeiro/meu-primeiro.component';
import { ProfessorGuardService } from './professores/professor-guard.service';
//import { ListarPokemonsComponent } from './pokemons/listar-pokemons/listar-pokemons.component';
// import { ListarProfessoresComponent } from './professores/listar-professores/listar-professores.component';

const routes: Routes = [
  { path: 'primeiro-componente', component: MeuPrimeiroComponent },
  {
    path: 'professores',
    loadChildren: () =>
      import('./professores/professores.module').then(
        (m) => m.ProfessoresModule
      ),
    canActivate: [ProfessorGuardService],
  },
  {
    path: 'alunos',
    loadChildren: () =>
      import('./alunos/alunos.module').then((m) => m.AlunosModule),
  },
  {
    path: 'formularios',
    loadChildren: () =>
      import('./formularios/formularios.module').then(
        (m) => m.FormulariosModule
      ),
  },
  {
    path: 'usuarios',
    loadChildren: () =>
      import('./usuarios/usuarios.module').then((m) => m.UsuariosModule),
  },

  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then((m) => m.AuthModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
function canActivate(arg0: (m: typeof import("./professores/professores.module")) => typeof import("./professores/professores.module").ProfessoresModule, canActivate: any, arg2: never[]): import("@angular/core").Type<any> | import("@angular/core").NgModuleFactory<any> | import("rxjs").Observable<import("@angular/core").Type<any>> | Promise<any> {
  throw new Error('Function not implemented.');
}

