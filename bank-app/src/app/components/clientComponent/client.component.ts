import { Component, OnInit } from '@angular/core';
import { Client } from "app/models/client";
import { CommonService } from "app/services/common.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit{
  
    private client:Client;

  constructor(private commonService :CommonService) { }

  ngOnInit() {

    this.commonService.selectClient.subscribe(client => this.client=client);
    if(this.client == null) {    
      this.client = new Client(1,"Jean Moulin","jmoulin@email.com", "mdp",2000);
    }
    this.commonService.selectClient.next(this.client);

  }//fin ngOnINit


}
