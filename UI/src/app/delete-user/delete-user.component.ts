import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {
  foundResult=null;
  deletedStatus=null;
  notDeletedStatus=null;
  service:UserService;
  constructor(service:UserService) { 
    this.service=service;
  }
  deleteUser(deleteForm:any){
  let detail=deleteForm.value;
  let userId=detail.userId;
  let respone:Observable<Boolean>=this.service.deleteUser(userId);
  respone.subscribe(
    result=>{
      this.foundResult=result;
      this.deletedStatus=true;
    },
    err=>{
      this.notDeletedStatus=true;
       console.log("Error while deleting users= "+err);
    }
  );
  deleteForm.reset();
  }

  ngOnInit(): void {
  }

}
