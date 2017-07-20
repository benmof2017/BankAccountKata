
export class Client {

    code: number;
    name: string;
    email: string;
    password: string;
    amount: number;

    constructor(code : number = 0, 
                name:string = "",
                email: string = "",
                password: string = "",
                amount: number = 1000
                ){ 
        this.code = code;
        this.name = name;
        this.email = email;
        this.password = password;
        this.amount = amount;

     } 
} 