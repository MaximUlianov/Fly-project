import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'fly-flights',
  templateUrl: './flights.component.html',
  styleUrls: ['./flights.component.css']
})
export class FlightsComponent implements OnInit {

  public originPlace: string;
  public destinationPlace: string;
  public date: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParamMap.subscribe(params => {
      this.originPlace = params.get('origin');
      this.destinationPlace = params.get('destination');
      this.date = params.get('date');
    });
  }

}
