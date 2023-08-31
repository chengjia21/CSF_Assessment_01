import { ComponentFixture, TestBed } from '@angular/core/testing';

import { View0Component } from './view0.component';

describe('View0Component', () => {
  let component: View0Component;
  let fixture: ComponentFixture<View0Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [View0Component]
    });
    fixture = TestBed.createComponent(View0Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
