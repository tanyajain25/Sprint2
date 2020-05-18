import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-all-users',
  templateUrl: './view-all-users.component.html',
  styleUrls: ['./view-all-users.component.css']
})
export class ViewAllUsersComponent implements OnInit {
  viewStatus=null;
  foundUsers = [];
  service: UserService;
  constructor(service:UserService) {
    this.service=service;
   }

  viewAllUsers(){
   }
  ngOnInit(): void {
    let response:Observable<Array<User>>=this.service.viewAllUsers();
    response.subscribe(
      arrayOfUsers=>{
        this.foundUsers=arrayOfUsers;
        this.viewStatus=true;        
      }
    );
  }

}
