import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getUsers() {
    return this.http.get('http://localhost:8080/clients')
  }

  getUserById(id:String){
    console.log("client id -->"+id)
    return this.http.get('http://localhost:8080/clients/'+id)

  }

  getInvestorById(id:String){
    console.log("investor id-->"+id)
    return this.http.get('http://localhost:8080/investors/'+id)

  }

  getFundsById(id:String){
    console.log("investor id-->"+id)
    return this.http.get('http://localhost:8080/funds/'+id)

  }

  addClients(obj:Object){
    console.log(obj);
    return this.http.post('http://localhost:8080/clients/',obj);
  }

  updateClient(obj:Object, id:String){
    console.log(obj);
    console.log('http://localhost:8080/clients/'+id);
    return this.http.put('http://localhost:8080/clients/'+id,obj);
  }
}
