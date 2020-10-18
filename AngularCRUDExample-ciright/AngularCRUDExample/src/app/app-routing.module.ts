import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeShowComponent} from '../app/employee-show/employee-show.component';
import { EmployeeAddComponent} from '../app/employee-add/employee-add.component';
const routes: Routes = [
{

  path : 'employee-show',
  component : EmployeeShowComponent
},
{

  path : 'employee-add',
  component : EmployeeAddComponent
},
{

  path : 'employee-add/:id',
  component : EmployeeAddComponent
}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
