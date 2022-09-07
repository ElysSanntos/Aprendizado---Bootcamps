import { AuthService } from './../shared/services/auth.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProfessorGuardService implements CanActivate {
  constructor(private authService: AuthService) {}

  canActivate(): boolean {
    //let isAutenticado = localStorage.getItem('autenticado');

    return this.authService.isAutenticado();
  }
}
