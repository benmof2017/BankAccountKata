import { Component, OnInit } from '@angular/core';
import { CommonService } from "app/services/common.service";
import { Client } from "app/models/client";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{
  
  private client:Client;

  constructor( private commonService :CommonService) { 
    
  }

  ngOnInit() {

        this.commonService.selectClient.subscribe(client => this.client=client);

  }//fin ngOnINit

}
