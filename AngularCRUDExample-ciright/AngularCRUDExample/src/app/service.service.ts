import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private WEBAPI :any = "http://localhost:8080/"
  constructor(private httpClient: HttpClient) { }


  public getAllEmp(){
   return this.httpClient.get(this.WEBAPI+"get_all_emp")
  }

  public getAddEmp(body){
    return this.httpClient.post(this.WEBAPI+"get_all_emp",body)
   }

   public getDeleteEmp(id){
    return this.httpClient.get(this.WEBAPI+"get_all_emp/"+id)
   }

}
