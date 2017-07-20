/*permet de faire naviguer les infos d'un composant vers un autre*/

import { Injectable } from "@angular/core";
//import { Observable } from "rxjs/Observable";
import { BehaviorSubject, Observable, Subject, Subscriber } from 'rxjs';
import { Client } from "app/models/client";


@Injectable()
export class CommonService {

    client: Client;


    public selectClient: BehaviorSubject<Client>
    = new BehaviorSubject(this.client);


    constructor() {
       
        

    }
}