import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Component({
  selector: 'app-modify-user',
  templateUrl: './modify-user.component.html',
  styleUrls: ['./modify-user.component.css']
})
export class ModifyUserComponent implements OnInit {

  service:UserService;
  foundUser: User;
  foundStatus: boolean;
  notFoundStatus: boolean;
  userId: any;
  user: User;
  addStatus: boolean;
  notAddedStatus: boolean;
  modifiedUser: User;
  constructor(service:UserService) { 
    this.service=service;
  }

  searchUser(modifyForm:any){
    let details=modifyForm.value;
    let userId=details.userId;
    let respose:Observable<User>=this.service.viewUser(userId);
    respose.subscribe(
      user=>{
        this.foundUser=user;
        this.foundStatus=true;
      },
      err=>{
        this.notFoundStatus=true;
        console.log("Error while fetching users="+err);
      }
    );
    modifyForm.reset();
  }

  modifyUser(modifyForm:any){
    let details=modifyForm.value;
    let userId=details.id;
    let userType=details.type;
    let userName=details.name;
    let userPassword=details.password;
    let userPhoneNo=details.phoneNo;
    let userEmail=details.email;
    this.user=new User(userId,userType,userName,userPassword,userPhoneNo,userEmail);
    let response:Observable<User> =this.service.modifyUser(this.user);
    response.subscribe(
      user=>{
      this.modifiedUser=user; 
      this.addStatus=true; 
      },
      err=>{
        this.notAddedStatus=true;
       console.log("Error while adding users= "+err);
       }
     ); 

     modifyForm.reset();
  }
  ngOnInit(): void {
    
  }

}
