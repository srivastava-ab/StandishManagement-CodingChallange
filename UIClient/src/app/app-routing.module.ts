import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddNewComponent } from  './add-new/add-new.component'
import { ListComponent } from './list/list.component';
import {UpdateComponent} from './update/update.component'

const routes: Routes = [
  {path: 'addNew', component: AddNewComponent},
  {path: 'list', component: ListComponent},
  {path: 'update/:id', component: UpdateComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [UpdateComponent];
