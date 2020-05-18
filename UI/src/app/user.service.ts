import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  client: HttpClient;
  constructor(client: HttpClient) {
    this.client = client;
  }

  baseUserUrl = "http://localhost:8087/users";

  addUser(user: User): Observable<User> {
    let url = this.baseUserUrl + '/add/';
    let observable: Observable<User> = this.client.post<User>(url, user);
    return observable;
  }

  deleteUser(userId: number): Observable<Boolean> {
    let url = this.baseUserUrl + '/deletebyuserid/' + userId;
    let observable: Observable<Boolean> = this.client.delete<Boolean>(url);
    return observable;
  }

  viewUser(userId: number): Observable<User> {
    let url = this.baseUserUrl + '/getbyuserid/' + userId;
    let observable: Observable<User> = this.client.get<User>(url);
    return observable;
  }

  viewAllUsers(): Observable<Array<User>> {
    let url = this.baseUserUrl + '/getall/';
    let observable: Observable<Array<User>> = this.client.get<Array<User>>(url);
    return observable;
  }

  modifyUser(user:User): Observable<User> {
    let url = this.baseUserUrl + '/update/';
    let observable: Observable<User> = this.client.put<User>(url,user);
    return observable;
  }

}  
