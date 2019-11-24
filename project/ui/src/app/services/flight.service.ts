import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {AirportSuggestion} from "../models/airport.suggestion";

const API_URL = '/api/v1/flights';

@Injectable()
export class FlightService {

  constructor(private http: HttpClient) {
  }

  getAirportsSuggestions(searchValue: string): Observable<AirportSuggestion[]> {
    return this.http.get<AirportSuggestion[]>(API_URL + '/getAirports/' + searchValue);
  }

  searchFlights():void {

  }

}
