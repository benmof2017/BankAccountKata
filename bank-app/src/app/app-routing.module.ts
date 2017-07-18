import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientComponent } from "app/components/clientComponent/client.component";
import { OperationComponent } from "app/components/operationComponent/operation.component";
import { HistoryComponent } from "app/components/historyComponent/history.component";



 
const routes: Routes = [
  { path: '', redirectTo: '/client', pathMatch: 'full' },
  { path: 'client',  component: ClientComponent },
  { path: 'operation',     component: OperationComponent },
  { path: 'history',     component: HistoryComponent}
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}