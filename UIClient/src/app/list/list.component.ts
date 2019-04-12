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
  h1Style: Boolean;
  listOfObjects = [];
  funds: Object;

  constructor(private data: DataService, private route: Router) { }

  // Gets the list of clients on nav button click
  ngOnInit() {
    this.data.getUsers().subscribe(data => {
      this.users = data
      console.log(this.users);

    }
    );
  }


  // Make a service call to get UsersById
  getClientById(id: String) {
    this.h1Style = true;
    this.data.getUserById(id).subscribe(data => {
      this.client = data
      console.log(this.client);
    }
    );



  }

  // Makes a service call to get InvestorById
  getInvestorsById(id: String) {
    var array = JSON.parse("[" + id + "]");
    this.data.getInvestorById(array).subscribe(data => {
      this.investors = data
      console.log(this.investors);

    }
    );
    this.listOfObjects = [];

  }


  // Makes a service call to get FundsById
  getFundsById(id: String) {
    var array = JSON.parse("[" + id + "]");
    this.data.getFundsById(array).subscribe(data => {
      this.funds = data
    }
    );
    this.listOfObjects = [];
  }

  // Function to show/hide funds column
  resetCol(flag1: boolean) {
    this.flag = flag1;
  }

  // Update service call on edit button click
  edit(user) {
    console.log('test--> ' + user._id);
    this.route.navigate(['/update', user._id]);
    sessionStorage.setItem('updateID', JSON.stringify(user))

  }

}
