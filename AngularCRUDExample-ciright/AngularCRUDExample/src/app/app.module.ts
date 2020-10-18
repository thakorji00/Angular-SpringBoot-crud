import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeShowComponent } from './employee-show/employee-show.component';
import { EmployeeAddComponent } from './employee-add/employee-add.component';
import { ServiceService} from '../app/service.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {DataTablesModule} from 'angular-datatables';
@NgModule({
  declarations: [
    AppComponent,
    EmployeeShowComponent,
    EmployeeAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DataTablesModule,
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
