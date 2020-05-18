import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddUserComponent } from './add-user/add-user.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { ViewUsersComponent } from './view-users/view-users.component';
import { ViewAllUsersComponent } from './view-all-users/view-all-users.component';
import { ModifyUserComponent } from './modify-user/modify-user.component';


const routes: Routes = [
  {
    path:'app-add-user',
    component:AddUserComponent
  },
  
  {
   path:'app-delete-user',
   component:DeleteUserComponent
  },

  {
    path:'app-view-users',
    component:ViewUsersComponent
  },

  {
    path:'app-view-all-users',
    component:ViewAllUsersComponent
  },

  {
    path:'app-modify-user',
    component:ModifyUserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
