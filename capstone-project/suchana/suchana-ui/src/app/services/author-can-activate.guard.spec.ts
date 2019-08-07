import { TestBed, async, inject } from '@angular/core/testing';

import { AuthorCanActivateGuard } from './author-can-activate.guard';

describe('AuthorCanActivateGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthorCanActivateGuard]
    });
  });

  it('should ...', inject([AuthorCanActivateGuard], (guard: AuthorCanActivateGuard) => {
    expect(guard).toBeTruthy();
  }));
});
