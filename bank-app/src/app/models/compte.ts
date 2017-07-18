import { Client } from "app/models/client";

export class Compte {

    codeCompte: string;
    dateCreation: Date;
    solde: number;
    decouvert: number;
    client: Client;

    constructor( codeCompte: string='',
    dateCreation: Date = new Date(),
    solde: number=1000,
    decouvert: number=200,
    client: Client=new Client() ){ 
        this.codeCompte = codeCompte,
        this.dateCreation = dateCreation,
        this.solde = solde,
        this.decouvert = decouvert,
        this.client = client
     } 
} 