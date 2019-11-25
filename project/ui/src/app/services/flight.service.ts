import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {AirportSuggestion} from "../models/airport.suggestion";
import {FlightModel} from "../models/flight.model";

const API_URL = '/api/v1/flights';

@Injectable()
export class FlightService {

  constructor(private http: HttpClient) {
  }

  getAirportsSuggestions(searchValue: string): Observable<AirportSuggestion[]> {
    return this.http.get<AirportSuggestion[]>(API_URL + '/getAirports/' + searchValue);
  }

  searchFlights(origin: string, destination: string, outboundDate: string): Observable<any> {
    return this.http.get<any>(API_URL + '/getAvailableFlights/' +
      origin + '/' + destination + '/' + outboundDate);

  }

  buyTicket(flight: FlightModel): Observable<FlightModel> {
    let body = JSON.stringify(flight);
    let headers = new HttpHeaders({
      'Content-Type': 'application/json'});
    let options = { headers: headers };
    return this.http.post<FlightModel>(API_URL + '/buy', body, options);
  }

}
