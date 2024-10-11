import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';

import axios from 'axios';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  login() {

    axios.post('http://localhost:8080/login', {
      username: this.username,
      password: this.password
    }).then((response) => {
      console.log(response.data)
      localStorage.setItem('token', response.data.jwt)
      window.location.href = '/'
    }).catch((error) => {
      console.log(error)
      alert('username หรือ password ไม่ถูกต้อง')

      
    })
  }

}
