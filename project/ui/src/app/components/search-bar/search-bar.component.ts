import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import * as moment from 'moment';
import {FlightService} from "../../services/flight.service";
import {AirportSuggestion} from "../../models/airport.suggestion";


@Component({
  selector: 'fly-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  public formGroup: FormGroup;
  public currentDate: string;
  public needBackTicket: boolean = false;
  public originSuggestionFound: boolean = false;
  public destinationSuggestionFound: boolean = false;
  public originSuggestions: AirportSuggestion[] = [];
  public destinationSuggestions: AirportSuggestion[] = [];
  private originPlace: string;
  private destinationPlace: string;

  constructor(private flightService: FlightService) {
  }

  ngOnInit() {
    this.currentDate = moment(new Date()).format('YYYY-MM-DD');
    this.formGroup = new FormGroup({
      'origin': new FormControl(''),
      'destination': new FormControl(''),
      'dateThere': new FormControl(''),
      'dateBack': new FormControl(''),
      'needBack': new FormControl('')
    });
  }

  public changeValues() {
    const value = this.formGroup.get('origin').value;
    this.formGroup.get('origin').setValue(this.formGroup.get('destination').value);
    this.formGroup.get('destination').setValue(value);
  }

  setNeedBack(event: any) {
    this.needBackTicket = event.currentTarget.checked;
    this.formGroup.get('needBack').setValue(this.needBackTicket);
    this.needBackTicket ? this.formGroup.get('dateBack').enable()
      : this.formGroup.get('dateBack').disable();
  }

  getOriginSuggestions(): void {
    this.originSuggestionFound = false;
    this.originSuggestions = [];
    const value = this.formGroup.get("origin").value;
    if (value.length >= 3) {
      this.flightService.getAirportsSuggestions(value).subscribe(data => {
        if (data) {
          this.originSuggestions = data;
          this.originSuggestionFound = true;
        } else {
          this.originSuggestionFound = false;
        }
      });
    }
  }

  getDestinationSuggestions(): void {
    this.destinationSuggestionFound = false;
    this.destinationSuggestions = [];
    const value = this.formGroup.get("destination").value;
    if (value.length >= 3) {
      this.flightService.getAirportsSuggestions(value).subscribe(data => {
        if (data) {
          this.destinationSuggestions = data;
          this.destinationSuggestionFound = true;
        } else {
          this.destinationSuggestionFound = false;
        }
      });
    }
  }

  setOrigin(origin: AirportSuggestion): void {
    this.formGroup.get('origin').setValue(origin.name + ' ' + origin.code);
    this.originPlace = origin.code;
    this.originSuggestions = [];
    this.originSuggestionFound = false;
  }

  setDestination(destination: AirportSuggestion): void {
    this.formGroup.get('destination').setValue(destination.name + ' ' + destination.code);
    this.destinationPlace = destination.code;
    this.destinationSuggestions = [];
    this.destinationSuggestionFound = false;
  }

  searchFlights(): void {

  }


}
