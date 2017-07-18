import { Client } from "../models/client";
import { Headers, Http, Response } from "@angular/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { AppUrlConfig } from "app/app.url-config";


@Injectable()
export class ClientService {

    private _headers = new Headers({ 'Content-Type': 'application/json' });
    private urlWebService_begin : string = AppUrlConfig.URL_WEBSERVICE_BEGIN;
    //'http://localhost:8080/services/' ou 'http://localhost:8080/BankAccountKata/services/'



    constructor(private _http: Http) {
        // _http injecté ici servira a appeler des WS REST
    }

    public selectClientById(id: number): Observable<Client> {

        let urlWS: string = this.urlWebService_begin + "clients/" + id;
        return this._http.get(urlWS)
            .map(response => response.json())
            .catch(e => Observable.throw("error : " + e));

    }

    public saveClient(c: Client): Observable<Client> {
        // http://localhost:8080/services/clients
        let urlWS: string = this.urlWebService_begin + "clients";

        return this._http.post(urlWS, JSON.stringify(c), { headers: this._headers })
            .map(response => response.json())
            .catch(e => Observable.throw("error : " + e));
    }

    
    // on utilise l email et password pour se connecter
    public connectClient(client:Client): Observable<Client> {
              
           let urlWS: string = this.urlWebService_begin + "clientsConnect";
           return this._http.post(urlWS, JSON.stringify(client), { headers: this._headers })
             .map(response => response.json())
             .catch(e => Observable.throw('error: ' + e));

    }

    public deleteClient(id: number): Observable<Boolean> {
        // http://localhost:8080/services/clients
        let urlWS: string = this.urlWebService_begin + "clients";

        return this._http.delete(urlWS + "/" + id)
            .map(response => response.json())
            .catch(e => Observable.throw("error : " + e));
    }


}