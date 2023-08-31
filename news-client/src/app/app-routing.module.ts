import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { View2Component } from './view2/view2.component';
import { View1Component } from './view1/view1.component';
import { View0Component } from './view0/view0.component';

const routes: Routes = [
  { path: 'view0', component: View0Component },
  { path: 'view1', component: View1Component },
  { path: 'view2', component: View2Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
