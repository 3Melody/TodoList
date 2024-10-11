import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../app/home/home.component';
import { MyaboutComponent } from '../app/myabout/myabout.component';
import { NgModule } from '@angular/core';
import { LoginComponent } from "../app/login/login.component";

// Export ตัวแปร routes
export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: MyaboutComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
