import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhesPokemonsComponent } from './detalhes-pokemons.component';

describe('DetalhesPokemonsComponent', () => {
  let component: DetalhesPokemonsComponent;
  let fixture: ComponentFixture<DetalhesPokemonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalhesPokemonsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalhesPokemonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
