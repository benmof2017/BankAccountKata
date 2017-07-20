import { Component, OnInit } from '@angular/core';
import { CommonService } from "app/services/common.service";
import { BankService } from "app/services/bank.service";
import { Client } from "app/models/client";
import { Operation } from "app/models/operation";
import { Router } from "@angular/router";

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
 private amount:number=0;


  constructor(private bankService : BankService, private commonService :CommonService, private _router: Router) { 
    
  }


  ngOnInit() {

        this.commonService.selectClient.subscribe(client => this.client=client);

        //automatic redirection 
        if(this.client == null) {
          let link=['/client'];
          this._router.navigate(link);
        }
       
        this.errors = "";
        this.validation = "";

  }//fin ngOnINit



  toDoDeposit(){

    this.operation = new Operation(0, new Date(), 0, 'D');//par defaut
    this.operation.amount = this.amount;
    this.bankService.deposit(this.operation)
    .subscribe( status => {
                   this.validation = "deposit OK" ;
                   this.errors ="";
                   this.client.amount += this.operation.amount;
                      new Promise(resolve => {
                      // Simulate server latency with 1 second delay
                      setTimeout(() => resolve( this.validation="" ), 1000);
                      });
                  }, 
                    e => {
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

    this.operation = new Operation(0, new Date(), 0, 'W');//par defaut
    this.operation.amount = this.amount;
    this.bankService.withdrawal(this.operation)
          .subscribe( status => {
                   this.validation = "withdrawal OK" ;
                   this.errors ="";
                   this.client.amount -= this.operation.amount;
                    new Promise(resolve => {
                      // Simulate server latency with 1 second delay
                      setTimeout(() => resolve( this.validation="" ), 1000);
                      });
                  }, 
                    e => {
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
