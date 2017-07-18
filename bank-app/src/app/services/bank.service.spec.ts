

import { TestBed, inject } from "@angular/core/testing";
import { BankService } from "app/services/bank.service";
import { HttpModule } from "@angular/http";
import { Client } from "app/models/client";
import { Compte } from "app/models/compte";
import { ClientService } from "app/services/client.service";
import { Operation } from "app/models/operation";






describe('scenario description...', () => {

    let client:Client;
    let compte:Compte;
    let operation:Operation;

//setup
beforeEach(() => TestBed.configureTestingModule({
  imports: [ HttpModule ],
  providers: [ BankService, ClientService ]
}));
  


  // test consultation compte
  it('should return a valid compte', inject([BankService], (bankService) => {
                                     inject([ClientService], (clientService) => {

    clientService.connectClient(new Client(1,"","jmoulin@email.com","mdp",null)).subscribe(client => { 
    this.client = client;
    expect(this.client.password).toEqual("mdp");
  	expect(this.client.code).toEqual(1);

    });

    bankService.consultCompte(this.client.compte.codeCompte).subscribe(compte => { 
    this.compte = compte;
    expect(this.compte).not.toBeNull();
  	expect(this.compte.decouvert).toEqual(200);
    expect(this.compte.solde).toBeGreaterThanOrEqual(-200);

    });
})}));

  // test deposit amount
  it('test deposit of 400 € in the account', inject([BankService], (bankService) => {
                                     inject([ClientService], (clientService) => {


    //on recupere le client
    clientService.connectClient(new Client(1,"","jmoulin@email.com","mdp",null)).subscribe(client => { 
        this.client = client;
        expect(this.client.password).toEqual("mdp");
      	expect(this.client.code).toEqual(1);
    });

    let solde = this.compte.solde;console.log("SOLDE ============= " + solde);
    this.operation = new Operation(0, new Date(), 400, 'V', this.client.compte);

    //on fait un deposit de 400
    bankService.deposit(this.operation).subscribe(status => { 
        expect(status).toBeTruthy(); 
    });

    //on verifie que le solde a augmenter de 400
    bankService.consultCompte(this.client.compte.codeCompte).subscribe(compte => { 
        expect(compte.solde).toEqual(solde + 400);
    });

  })})); 



  // test withdrawal amount
  it('test withdrawal of 400 € in the account', inject([BankService], (bankService) => {
                                     inject([ClientService], (clientService) => {

    
    //on recupere le client
    clientService.selectClientById(1).subscribe(client => { 
    this.client = client;
    expect(this.client.password).toEqual("mdp");
  	expect(this.client.code).toEqual(1);

    });

    let solde = this.compte.solde;
    this.operation = new Operation(0, new Date(), 400, 'R', this.client.compte);

     //on fait un deposit de 400
    bankService.withdrawal(this.operation).subscribe(status => { 
        expect(status).toBeTruthy(); 
    });

    //on verifie que le solde a augmenter de 400
    bankService.consultCompte(this.client.compte.codeCompte).subscribe(compte => { 
        expect(compte.solde).toEqual(solde - 400);
    });

})}));

})


  


