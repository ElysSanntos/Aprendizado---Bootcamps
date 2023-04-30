/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ServicesService } from './services.service';

describe('Service: Services', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicesService]
    });
  });

  it('should ...', inject([ServicesService], (service: ServicesService) => {
    expect(service).toBeTruthy();
  }));
});
