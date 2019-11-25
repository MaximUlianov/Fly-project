import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FlightService} from "../../services/flight.service";
import {FlightModel} from "../../models/flight.model";
import {QouteModel} from "../../models/qoute.model";
import {SalesService} from "../../services/sales.service";

@Component({
  selector: 'fly-flights',
  templateUrl: './flights.component.html',
  styleUrls: ['./flights.component.css']
})
export class FlightsComponent implements OnInit {

  public originPlace: string;
  public destinationPlace: string;
  public dateThere: string;
  public dateBack: string;
  public back: string;
  public flights: FlightModel;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private flightService: FlightService,
              private salesOrderService: SalesService) {
  }

  ngOnInit() {
    this.route.queryParamMap.subscribe(params => {
      this.originPlace = params.get('origin');
      this.destinationPlace = params.get('destination');
      this.dateThere = params.get('dateThere');
      this.dateBack = params.get('dateBack');
      this.back = params.get('back');

      this.flightService.searchFlights(this.originPlace, this.destinationPlace,
        this.back && this.back === 'true' ? this.dateBack : this.dateThere).subscribe(data => {
        this.flights = data;
        if (this.flights) {
          this.flights.quotes.forEach(quote => {
            const date = quote.departureDate.split('-');
            quote.departureDate = date[2] + '.' + date[1] + '.' + date[0];
          })
        }
      })
    });
  }

  public buyTicket(quote: QouteModel): void {
    let flight = new FlightModel();
    flight.destinationCode = this.flights.destinationCode;
    flight.destinationCity = this.flights.destinationCity;
    flight.originCode = this.flights.originCode;
    flight.originCity = this.flights.originCity
    flight.quotes = [quote];
    flight.back = this.back === 'true';
    this.salesOrderService.buyTicket(flight).subscribe(data => {
      if (data) {
        if (this.back && this.back === 'false') {
          this.router.navigate(['flight-choose'], {
            queryParams: {
              origin: this.destinationPlace,
              destination: this.originPlace,
              dateThere: this.dateThere,
              dateBack: this.dateBack,
              back: 'true'
            }
          });
        } else {
          this.router.navigate(['registration']);
        }
      }
    });
  }

}
