import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {FlightModel} from "../models/flight.model";
import {ExtrasModel} from "../models/extras.model";
import {SalesOrderModel} from "../models/sales.order.model";

const API_URL = '/api/v1/salesOrder';

@Injectable()
export class SalesService {

  constructor(private http: HttpClient) {
  }

  buyTicket(flight: FlightModel): Observable<FlightModel> {
    let body = JSON.stringify(flight);
    let headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    let options = {headers: headers};
    return this.http.post<FlightModel>(API_URL + '/buyTicket', body, options);
  }

  buyExtras(extras: ExtrasModel): Observable<ExtrasModel> {
    let body = JSON.stringify(extras);
    let headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    let options = {headers: headers};
    return this.http.post<ExtrasModel>(API_URL + '/buyExtras', body, options);
  }

  getSalesOrder(): Observable<SalesOrderModel> {
    return this.http.get<SalesOrderModel>(API_URL + '/getSalesOrder');
  }

  clearAll(): Observable<any> {
    return this.http.get<any>(API_URL + '/clearAll');
  }

}
