import { Component, OnInit } from '@angular/core';
import { ServiceService} from '../service.service';
import { ActivatedRoute, Params } from '@angular/router';
@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.scss']
})
export class EmployeeAddComponent implements OnInit {

  public id:any;
  formInput: FormData;
  isSubmit = false;
  constructor(private service:ServiceService,private activeRout:ActivatedRoute) {

    this.activeRout.params.subscribe((params: Params) => {
      this.id = params['id'];
      });


   }

  ngOnInit(): void {

    if(this.id!=undefined){

      this.formInput ={
        empCity :localStorage.getItem('empNAME'),
        empDesination :localStorage.getItem('empDESIGNATION'),
        empName:localStorage.getItem('empNAME'),
        id : localStorage.getItem('empID')
        }
        localStorage.removeItem('empID');
        localStorage.removeItem('empNAME');
        localStorage.removeItem('empCITY');
        localStorage.removeItem('empDESIGNATION');
    }
    else{
      this.formInput ={
      empCity :'',
      empDesination :'',
      empName:'',
      id : 0
      }
    }

  }



  public save(form: any){
    if (!form.valid) {
      this.isSubmit = true;
      return;
    }
    let body = JSON.stringify({
      'empName':form.empName,
      'empDesignation': form.empDesination,
    'empCity':form.empCity,
    'id':form.id
    })

    this.service.getAddEmp(body).subscribe(data =>{
    alert(data['message'])
    })

  }




}




export class FormData{

  public id:any;
  public empName:any;
	public empCity:any;
	public empDesination:any;
}