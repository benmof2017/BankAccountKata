import { Component, OnInit } from '@angular/core';
import { ClientService } from "app/services/client.service";
import { Client } from "app/models/client";
import { CommonService } from "app/services/common.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit{
  
    private client:Client;

  constructor(private clientService : ClientService, private commonService :CommonService) { }

  ngOnInit() {


    console.log("test client");
    
    this.commonService.selectClient.subscribe(
          client => this.client=client);

    //on charge le client
    this.clientService.connectClient(new Client(1,"","jmoulin@email.com","mdp",null))//on cherche le client par defaut dans la BD
        .subscribe( client => {this.client = client;
                               this.commonService.selectClient.next(this.client);//indispensable, on met la nouvelle valeur a partager
                                console.log("client : " + this.client.nom);
                                }, 
                    e => console.log(e.message));

    

  }//fin ngOnINit


}
