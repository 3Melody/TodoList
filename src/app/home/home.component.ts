import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import axios from 'axios';  // นำเข้า Axios
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';  // นำเข้า FormsModule เพื่อใช้ ngModel

interface Task {
  id: number;
  title: string;
  completed: boolean;
}

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NavbarComponent, CommonModule, FormsModule],  // เพิ่ม FormsModule ที่นี่
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']  // แก้ไขจาก 'styleUrl' เป็น 'styleUrls'
})

export class HomeComponent implements OnInit {

  tasks: Task[] = [];  // ตัวแปรเก็บข้อมูลที่ completed = false
  completedTasks: Task[] = [];  // ตัวแปรเก็บข้อมูลที่ completed = true
  newTaskTitle: string = '';  // ตัวแปรสำหรับเก็บค่า title ของ task ใหม่
  IdTask: number = 0;

  constructor() {}

  ngOnInit(): void {
    this.getTasks();
  }

  // ฟังก์ชันสำหรับเรียก API ด้วย Axios
  getTasks(): void {
    axios.get<Task[]>('http://localhost:8080/tasks')
      .then(response => {
        const allTasks = response.data;

        // แยกข้อมูล tasks ที่ completed = false
        this.tasks = allTasks.filter((task: Task) => !task.completed);

        // แยกข้อมูล tasks ที่ completed = true
        this.completedTasks = allTasks.filter((task: Task) => task.completed);

      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  }

  // ฟังก์ชันสำหรับลบ task ตาม id
  deleteTask(id: number): void {
    axios.delete(`http://localhost:8080/tasks/${id}`)
      .then(() => {
        // อัพเดตข้อมูลใหม่หลังจากลบเสร็จ
        this.getTasks();
      })
      .catch(error => {
        console.error('There was an error deleting the task!', error);
      });
  }

  // ฟังก์ชันสำหรับเพิ่ม task ใหม่
  addTask(): void {
    if (this.newTaskTitle.trim() === '') {
      alert('Task title cannot be empty');
      return;
    }

    const newTask: Partial<Task> = { title: this.newTaskTitle, completed: false };

    axios.post('http://localhost:8080/tasks', newTask)
      .then(() => {
        this.newTaskTitle = '';  // ล้างฟอร์มหลังจากเพิ่มสำเร็จ
        this.getTasks();  // อัพเดตข้อมูลใหม่
      })
      .catch(error => {
        console.error('There was an error adding the task!', error);
      });
  }

  editTask(id: number): void {
    this.IdTask = id;

    axios.get<Task>(`http://localhost:8080/tasks/${id}`)
      .then(response => {
        const task = response.data;
        this.newTaskTitle = task.title;
      })
      .catch(error => {
        console.error('There was an error getting the task!', error);
      });

    
  }


  updateTask(): void {
    if ( this.newTaskTitle.trim() === '') {
      alert('Task title cannot be empty');
      return;
    }

    const updateTask: Partial<Task> = { title: this.newTaskTitle };

    axios.put(`http://localhost:8080/tasks/${this.IdTask}`, updateTask)
    .then(() => {
      this.newTaskTitle = '';  // ล้างฟอร์มหลังจากแก้ไขสำเร็จ
      const modal: any = document.getElementById('my_modal_5');
      modal.close();  // ปิด modal
      this.getTasks();  // อัพเดตข้อมูลใหม่
    })
    .catch(error => {
      console.error('There was an error updating the task!', error);
    });
}



  completeTask(id: number,title: string): void {
    axios.put(`http://localhost:8080/tasks/${id}`, { title: title, completed: true })
      .then(() => {
        this.getTasks();  // อัพเดตข้อมูลใหม่
      })
      .catch(error => {
        console.error('There was an error completing the task!', error);
      });
  }

  

  todoTask(id: number, title: string): void {
    axios.put(`http://localhost:8080/tasks/${id}`, { title: title, completed: false })
      .then(() => {
        this.getTasks();  // อัพเดตข้อมูลใหม่
      })
      .catch(error => {
        console.error('There was an error completing the task!', error);
      });
  }
}
