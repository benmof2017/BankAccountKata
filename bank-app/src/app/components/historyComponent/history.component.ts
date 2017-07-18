import { Component, OnInit } from '@angular/core';
import { BankService } from "app/services/bank.service";
import { Operation } from "app/models/operation";
import { Client } from "app/models/client";
import { CommonService } from "app/services/common.service";
import { DatePipe } from '@angular/common';




@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit{


 private client:Client;
 operations : Operation[];


  constructor(private bankService : BankService, private commonService :CommonService) { }


  ngOnInit() {


    this.commonService.selectClient.subscribe(
      client => this.client=client);


    //on recherche toutes les operations
    if(this.client != null) {
      this.bankService.listOperation(this.client.compte.codeCompte)
          .subscribe( listOperations => {this.operations = listOperations;}, 
                      e => console.log(e.message));
    }


  }//fin ngOnINit


}
