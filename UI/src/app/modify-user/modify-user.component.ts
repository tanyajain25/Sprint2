import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-modify-user',
  templateUrl: './modify-user.component.html',
  styleUrls: ['./modify-user.component.css']
})
export class ModifyUserComponent implements OnInit {

  service:UserService;
  user: User;
  modifyStatus: boolean;
  notModifiedStatus: boolean;
  modifiedUser: User;
  userId: any;
  constructor(service:UserService) {
    this.service=service;
   }

   modifyUser(modifyForm){
     let details=modifyForm.value;
     let userId=details.userId;
     let userType=details.type;
    let userName=details.name;
    let userPassword=details.password;
    let userPhoneNo=details.phoneNo;
    let userEmail=details.email;
    this.user=new User(0,userType,userName,userPassword,userPhoneNo,userEmail);
    let response:Observable<User> =this.service.modifyUser(this.user,userId);
    response.subscribe(
      user=>{
      this.modifiedUser=user; 
      this.modifyStatus=true; 
      },
      err=>{
        this.notModifiedStatus=true;
        this.userId=userId;
        console.log(userId);
       console.log("Error while modifying user details !!- "+ err);
       }
     ); 

     modifyForm.reset();
   }
  ngOnInit(): void {
  }

}
