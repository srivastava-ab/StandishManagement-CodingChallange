import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  users: Object;
  client: Object;
  investors: Object;
  flag: Boolean;
  h1Style:Boolean;
  listOfObjects = [];
  funds:Object;
  
  constructor(private data: DataService,   private route: Router) { }

  ngOnInit() {
    this.data.getUsers().subscribe(data => {
      this.users = data
      console.log(this.users);
      
    }
    );
  }

  getClientById(id: String) {
    this.h1Style = true;
    //console.log("Clicked 123 -->" + id)
    this.data.getUserById(id).subscribe(data => {
      this.client = data
      console.log(this.client);
    }
    );



  }

  getInvestorsById(id: String) {
    console.log("Clicked 12333 -->" + id)
    var array = JSON.parse("[" + id + "]");
    this.data.getInvestorById(array).subscribe(data => {
      this.investors = data
      console.log(this.investors);
      
    }
    );
    console.log("*&> "+this.listOfObjects.length)
    this.listOfObjects =[];
    
  }



  getFundsById(id: String){
    console.log("Clicked ZZ -->" + id)
    var array = JSON.parse("[" + id + "]");
    console.log(array);
    this.data.getFundsById(array).subscribe(data => {
      this.funds = data
      console.log(this.funds);
      
    }
    );
    console.log("*&> "+this.listOfObjects.length)
    this.listOfObjects =[];
  }

  test(flag1: boolean) {
    this.flag = flag1;
  }

  test1(user){
    console.log('test--> '+user._id);
    this.route.navigate(['/update',user._id]);
    sessionStorage.setItem('updateID', JSON.stringify(user))

  }

  sleep(miliseconds) {
    var currentTime = new Date().getTime();
 
    while (currentTime + miliseconds >= new Date().getTime()) {
    }
 }

}
