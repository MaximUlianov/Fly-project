import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'fly-error-field',
  templateUrl: './error-field.component.html',
  styleUrls: ['./error-field.component.css']
})
export class ErrorFieldComponent implements OnInit {

  @Input()
  public errorMsg: string;

  @Input()
  public displayError: boolean;

  constructor() { }

  ngOnInit() {
  }

}
