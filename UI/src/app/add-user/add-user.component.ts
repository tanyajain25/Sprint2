import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  service:UserService;
  foundUser=null;
  user =null;
  addStatus=null;
  notAddedStatus=null;
  constructor(service:UserService) { 
    this.service=service;
  }

  addUser(addForm:any){
    let details=addForm.value;
    let userType=details.type;
    let userName=details.name;
    let userPassword=details.password;
    let userPhoneNo=details.phoneNo;
    let userEmail=details.email;
    this.user=new User(0,userType,userName,userPassword,userPhoneNo,userEmail);
    let response:Observable<User> =this.service.addUser(this.user);
    response.subscribe(
      user=>{
      this.foundUser=user; 
      this.addStatus=true; 
      },
      err=>{
        this.notAddedStatus=true;
       console.log("Error while adding users= "+err);
       }
     ); 

     addForm.reset();
  }
  ngOnInit(): void {
    
  }

}
