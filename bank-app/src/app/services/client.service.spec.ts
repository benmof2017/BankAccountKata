

import { TestBed, inject } from "@angular/core/testing";
import { HttpModule } from "@angular/http";
import { Client } from "app/models/client";
import { ClientService } from "app/services/client.service";






describe('scenario description...', () => {

    let client:Client;

//setup
beforeEach(() => TestBed.configureTestingModule({
  imports: [ HttpModule ],
  providers: [ ClientService ]
}));
  
  // test consultation d'un client
  it('should return a valid client', inject([ClientService], (service) => {

  service.connectClient(new Client(1,"","jmoulin@email.com","mdp",null)).subscribe(client => { 
    this.client = client;
    expect(this.client.password).toEqual("mdp");
  	expect(this.client.code).toEqual(1);

  });

}));




})


  


