/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { Transferencia.serviceService } from './transferencia.service.service';

describe('Service: Transferencia.service', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Transferencia.serviceService]
    });
  });

  it('should ...', inject([Transferencia.serviceService], (service: Transferencia.serviceService) => {
    expect(service).toBeTruthy();
  }));
});
