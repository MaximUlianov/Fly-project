import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerModel} from "../../models/customer.model";
import {CustomerService} from "../../services/customer.service";
import {Router, RouterOutlet} from "@angular/router";

@Component({
  selector: 'fly-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {

  public customer: CustomerModel = new CustomerModel();

  public formGroup: FormGroup;

  public showErrorPopup: boolean = false;

  constructor(private service: CustomerService,
              private router: Router) { }

  ngOnInit() {
    this.formGroup = new FormGroup({
      'firstName':new FormControl('', Validators.required),
      'lastName': new FormControl('', Validators.required),
      'birthday': new FormControl('', Validators.required),
      'passportId': new FormControl('', Validators.required),
      'email': new FormControl('', [Validators.required,
        Validators.pattern(/^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/)])
    })
  }

  registerCustomer() {
    if(this.formGroup.valid) {
      this.customer.firstName = this.formGroup.get('firstName').value;
      this.customer.lastName = this.formGroup.get('lastName').value;
      this.customer.birthday = this.formGroup.get('birthday').value;
      this.customer.passportId = this.formGroup.get('passportId').value;
      this.customer.email = this.formGroup.get('email').value;
      this.service.registeCustomer(this.customer).subscribe(data => {
        if (data) {
          this.router.navigate(['extras']);
        }
      });
    } else {
      this.showErrorPopup = true;
      setTimeout(() =>{
        this.showErrorPopup = false;
      }, 3000);
    }
  }

  isFieldValid(field: string) {
    return this.formGroup.get(field).touched && !this.formGroup.get(field).valid;
  }

}
