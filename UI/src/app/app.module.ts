import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UserService } from './user.service';
import {FormsModule} from '@angular/forms';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { ViewUsersComponent } from './view-users/view-users.component';
import { ViewAllUsersComponent } from './view-all-users/view-all-users.component';
import { ModifyUserComponent } from './modify-user/modify-user.component';
@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    DeleteUserComponent,
    ViewUsersComponent,
    ViewAllUsersComponent,
    ModifyUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
