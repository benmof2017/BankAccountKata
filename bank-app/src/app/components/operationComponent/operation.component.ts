import { Component, OnInit } from '@angular/core';
import { CommonService } from "app/services/common.service";
import { BankService } from "app/services/bank.service";
import { Client } from "app/models/client";
import { Operation } from "app/models/operation";

@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css']
})
export class OperationComponent  implements OnInit{
  
 private client:Client;
 private operation : Operation;
 private errors: string;
 private validation: string;


  constructor(private bankService : BankService, private commonService :CommonService) { 
    
  }


  ngOnInit() {

        this.commonService.selectClient.subscribe(client => this.client=client);
        this.operation = new Operation(0, new Date(), 0, 'V', this.client.compte);//par defaut
        this.errors = "";
        this.validation = "";

  }//fin ngOnINit



  toDoDeposit(){
    console.log("deposit");
    console.log("deposit : "+ this.operation.montant);

    this.bankService.deposit(this.operation)
    .subscribe( status => {
                   this.validation = "deposit OK" ;
                   this.errors ="";
                   this.client.compte.solde += this.operation.montant;
                      new Promise(resolve => {
                      // Simulate server latency with 1 second delay
                      setTimeout(() => resolve( this.validation="" ), 1000);
                      });
                  }, 
                    e => {
                      console.log(e.message)
                      this.validation = "" ;
                      this.errors = "Error during validation" ;
                       new Promise(resolve => {
                        // Simulate server latency with 1 second delay
                        setTimeout(() => resolve( this.errors="" ), 1000);
                        });
                  }
    );
  }
  

  
  toDoWithdrawal(){

    console.log("withdrawal");

      this.bankService.withdrawal(this.operation)
    .subscribe( status => {
                   this.validation = "withdrawal OK" ;
                   this.errors ="";
                   this.client.compte.solde -= this.operation.montant;
                    new Promise(resolve => {
                      // Simulate server latency with 1 second delay
                      setTimeout(() => resolve( this.validation="" ), 1000);
                      });
                  }, 
                    e => {
                      console.log(e.message)
                      this.validation = "" ;
                      this.errors = "Error, check if you have enough money in your account please !" ;
                        new Promise(resolve => {
                        // Simulate server latency with 2 second delay
                        setTimeout(() => resolve( this.errors="" ), 2000);
                        });
                  }
    );
    
  }

}
