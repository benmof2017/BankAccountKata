import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import {Ng2PaginationModule} from 'ng2-pagination'; //importing ng2-pagination

import { AppComponent } from './app.component';
import { OperationComponent } from "app/components/operationComponent/operation.component";
import { ClientComponent } from "app/components/clientComponent/client.component";
import { HistoryComponent } from "app/components/historyComponent/history.component";
import { BankService } from "app/services/bank.service";
import { CommonService } from "app/services/common.service";
import { MenuComponent } from "app/components/menuComponent/menu.component";


@NgModule({
  declarations: [
    AppComponent, ClientComponent, HistoryComponent, OperationComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,AppRoutingModule,HttpModule,FormsModule,Ng2PaginationModule 
  ],
  providers: [BankService,CommonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
