/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TransferenciasService } from './transferencias.service';

describe('Service: Transferencias', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TransferenciasService]
    });
  });

  it('should ...', inject([TransferenciasService], (service: TransferenciasService) => {
    expect(service).toBeTruthy();
  }));
});
