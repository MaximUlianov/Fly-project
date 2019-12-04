import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerModel} from "../models/customer.model";

const API_URL = '/api/v1/customer';

@Injectable()
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  registeCustomer(customer: CustomerModel): Observable<CustomerModel> {
    let body = JSON.stringify(customer);
    let headers = new HttpHeaders({
      'Content-Type': 'application/json'});
    let options = { headers: headers };
    return this.http.post<CustomerModel>(API_URL + '/register', body, options);
  }

  getActiveCustomer():Observable<CustomerModel> {
    return this.http.get<CustomerModel>(API_URL + '/getActive');
  }

}
