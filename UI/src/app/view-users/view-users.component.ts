import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {
  
  foundUser=null;
  foundStatus: boolean;
  notFoundStatus=null;
  userId:number;
  service:UserService;
  notFoudStatus: boolean;
  constructor(service:UserService) {
    this.service=service;
   }

   viewUser(viewForm :any){
    let details=viewForm.value;
    let userId=details.userId;
    let respose:Observable<User>=this.service.viewUser(userId);
    respose.subscribe(
      user=>{
        this.foundUser=user;
        this.foundStatus=true;
      },
      err=>{
        this.notFoundStatus=true;
        this.userId= userId;
        console.log("Error while fetching users="+err);
      }
    );
     viewForm.reset();
   }

   
  ngOnInit(): void {
  }

}
