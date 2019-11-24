import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'fly-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {

  public formGroup: FormGroup

  constructor() { }

  ngOnInit() {
    this.formGroup = new FormGroup({
      'firstName':new FormControl(''),
      'lastName': new FormControl(''),
      'birthday': new FormControl(''),
      'passportId': new FormControl(''),
      'email': new FormControl('')
    })
  }

}
