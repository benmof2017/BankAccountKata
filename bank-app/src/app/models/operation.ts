import { Compte } from "app/models/compte";

export class Operation {

    numero: number;
    dateOperation: Date;
    montant: number;
    type_op: string;
    compte: Compte;

    constructor( numero: number=0,
    dateOperation: Date = new Date(),
    montant: number=1000,
    type_op: string='V',//'V' ou 'R'
    compte: Compte=new Compte() ){ 
        this.numero = numero;
        this.dateOperation = dateOperation;
        this.type_op = type_op;
        this.compte = compte;
     } 
} 