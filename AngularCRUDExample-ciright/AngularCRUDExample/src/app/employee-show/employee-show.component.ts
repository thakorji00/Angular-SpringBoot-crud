import { Component, OnInit } from '@angular/core';
import { ServiceService} from '../service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-employee-show',
  templateUrl: './employee-show.component.html',
  styleUrls: ['./employee-show.component.scss']
})
export class EmployeeShowComponent implements OnInit {

  public empList:any;
  constructor(private service:ServiceService,private router:Router) { }

  ngOnInit(): void {

    this.getemp();
  }



  public getemp(){

    this.service.getAllEmp().subscribe(data =>{

      if(data['status']=="success"){
        this.empList = data['data']
 }
     
    });

  }


  public delete(id){

    this.service.getDeleteEmp(id).subscribe(data =>{

      if(data['status']=="success"){
        alert("Employee Deleted Successfully")
      }
      else
      {
        alert(data['message'])
        
      }

    });


  }


  public edit(data){

    localStorage.setItem('empID',data.id);
    localStorage.setItem('empNAME',data.empName);
    localStorage.setItem('empCITY',data.empCity);
    localStorage.setItem('empDESIGNATION',data.empDesignation);
   this.router.navigate(['employee-add',data.id])


  }
}
