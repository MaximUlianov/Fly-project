import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'fly-error-popup',
  templateUrl: './error-popup.component.html',
  styleUrls: ['./error-popup.component.css']
})
export class ErrorPopupComponent implements OnInit {

  @Input()
  public errorMessage: string;

  constructor() { }

  ngOnInit() {
  }

}
