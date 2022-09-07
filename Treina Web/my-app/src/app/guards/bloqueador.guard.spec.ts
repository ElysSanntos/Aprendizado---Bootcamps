import { TestBed } from '@angular/core/testing';

import { BloqueadorGuard } from './bloqueador.guard';

describe('BloqueadorGuard', () => {
  let guard: BloqueadorGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(BloqueadorGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
