

import { TestBed, inject } from "@angular/core/testing";
import { BankService } from "app/services/bank.service";
import { HttpModule } from "@angular/http";
import { Client } from "app/models/client";
import { Operation } from "app/models/operation";






describe('scenario description...', () => {

    let client:Client;
    let compte:Account;
    let operation:Operation;

//setup
beforeEach(() => TestBed.configureTestingModule({
  imports: [ HttpModule ],
  providers: [ BankService ]
}));
  



  // test deposit amount
  it('test deposit of 400 € in the account', inject([BankService], (bankService) => {




    let solde = this.compte.solde;console.log("SOLDE ============= " + solde);
    this.operation = new Operation(0, new Date(), 400, 'V', this.client.account);

    //on fait un deposit de 400
    bankService.deposit(this.operation).subscribe(status => { 
        expect(status).toBeTruthy(); 
    });

    //on verifie que le solde a augmenter de 400
    bankService.consultCompte(this.client.account.codeCompte).subscribe(compte => { 
        expect(compte.solde).toEqual(solde + 400);
    });

 })); 



  // test withdrawal amount
  it('test withdrawal of 400 € in the account', inject([BankService], (bankService) => {
                               

    let solde = this.compte.solde;
    this.operation = new Operation(0, new Date(), 400, 'R', this.client.account);

     //on fait un deposit de 400
    bankService.withdrawal(this.operation).subscribe(status => { 
        expect(status).toBeTruthy(); 
    });

    //on verifie que le solde a augmenter de 400
    bankService.consultCompte(this.client.account.codeCompte).subscribe(compte => { 
        expect(compte.solde).toEqual(solde - 400);
    });

}));

})


  


