export class User {

    userId: number;

    userType: String;

    userName: String;

    userPassword: String;

    userPhone: number;

    userEmail: String;

    constructor(userId: number,userType: String, userName: String, userPassword: String, userPhone: number,  userEmail: String){
       
        this.userId=userId;
        this.userType=userType;
        this.userName=userName;
        this.userPassword=userPassword;
        this.userPhone=userPhone;
        this.userEmail=userEmail;
    }
}