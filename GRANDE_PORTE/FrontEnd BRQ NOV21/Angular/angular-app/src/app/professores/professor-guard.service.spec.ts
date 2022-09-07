import { TestBed } from '@angular/core/testing';

import { ProfessorGuardService } from './professor-guard.service';

describe('ProfessorGuardService', () => {
  let service: ProfessorGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfessorGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
