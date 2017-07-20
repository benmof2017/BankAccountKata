import { Client } from "../models/client";
import { Headers, Http, Response } from "@angular/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Operation } from "app/models/operation";
import { AppUrlConfig } from "app/app.url-config";


@Injectable()
export class BankService {

    private _headers = new Headers({ 'Content-Type': 'application/json' });
        private urlWebService_begin : string = AppUrlConfig.URL_WEBSERVICE_BEGIN;
        //'http://localhost:8080/services/' ou 'http://localhost:8080/BankAccountKata/services/'



    constructor(private _http: Http) {
        // _http injecté ici servira a appeler des WS REST
    }


    //Retrait
    public withdrawal(operation:Operation): Observable<Boolean> {
              
           let urlWS: string = this.urlWebService_begin + "withdrawal";
           return this._http.put(urlWS, JSON.stringify(operation), { headers: this._headers })
             .map(response => response.json())
             .catch(e => Observable.throw('error: ' + e));

    }


    //Faire un depot
    public deposit(operation:Operation): Observable<Boolean> {
              
           let urlWS: string = this.urlWebService_begin + "deposit";
           return this._http.put(urlWS, JSON.stringify(operation), { headers: this._headers })
             .map(response => response.json())
             .catch(e => Observable.throw('error: ' + e));

    }


    //list all  operations
    public listOperation(): Observable<Operation[]> {

        let urlWS: string = this.urlWebService_begin + "operations";
        return this._http.get(urlWS)
            .map(response => response.json())
            .catch(e => Observable.throw("error : " + e));

    }

    //delete all Operations
    public deleteAllOperations(): Observable<Boolean> {

        let urlWS: string = this.urlWebService_begin + "operations";
        return this._http.delete(urlWS)
            .map(response => response.json())
            .catch(e => Observable.throw("error : " + e));

    }


}