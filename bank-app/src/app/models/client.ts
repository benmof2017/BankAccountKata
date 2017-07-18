import { Compte } from "app/models/compte";

export class Client {

    code: number;
    nom: string;
    email: string;
    password: string;
    compte: Compte;

    constructor(code : number = 0, 
                nom:string = "",
                email: string = "",
                password: string = "",
                compte: Compte = new Compte()){ 
        this.code = code;
        this.nom = nom;
        this.email = email;;
        this.password = password;
        this.compte = compte
     } 
} 