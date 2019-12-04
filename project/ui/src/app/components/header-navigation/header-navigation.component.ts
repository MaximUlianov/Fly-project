import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'fly-header-navigation',
  templateUrl: './header-navigation.component.html',
  styleUrls: ['./header-navigation.component.css']
})
export class HeaderNavigationComponent implements OnInit {

  public selectFlight: boolean;
  public registration: boolean;
  public extras: boolean;
  public reviewCart: boolean;
  public confirmation: boolean;

  constructor(private route: Router) { }

  ngOnInit() {
    let href = window.location.href.split('/')[3];
    if (href.includes('flight-choose')){
      href = 'flight-choose';
    }
    this.chooseActiveLocation(href);
  }

  chooseActiveLocation(href: string): void {
    switch (href) {
      case 'flight-choose': {
        this.selectFlight = true;
        this.registration = false;
        this.extras = false;
        this.reviewCart = false;
        this.confirmation = false;
      }break;
      case 'registration':{
        this.selectFlight = false;
        this.registration = true;
        this.extras = false;
        this.reviewCart = false;
        this.confirmation = false;
      }break;
      case 'extras':{
        this.selectFlight = false;
        this.registration = false;
        this.extras = true;
        this.reviewCart = false;
        this.confirmation = false;
      }break;
      case 'review-order':{
        this.selectFlight = false;
        this.registration = false;
        this.extras = false;
        this.reviewCart = true;
        this.confirmation = false;
      }break;
      case 'confirmation':{
        this.selectFlight = false;
        this.registration = false;
        this.extras = false;
        this.reviewCart = false;
        this.confirmation = true;
      }break;

    }
  }

}
