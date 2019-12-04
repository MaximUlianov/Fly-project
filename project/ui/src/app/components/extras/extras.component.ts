import {Component, OnInit} from '@angular/core';
import {CustomerModel} from "../../models/customer.model";
import {CustomerService} from "../../services/customer.service";
import {SalesService} from "../../services/sales.service";
import {ExtrasModel} from "../../models/extras.model";
import {Router} from "@angular/router";

@Component({
  selector: 'fly-extras',
  templateUrl: './extras.component.html',
  styleUrls: ['./extras.component.css']
})
export class ExtrasComponent implements OnInit {

  public counter: number = 0;
  public costPerOne: number = 15;
  public customer: CustomerModel;
  public extras: ExtrasModel;

  constructor(private customerService: CustomerService,
              private salesOrderService: SalesService,
              private router: Router) {
  }

  ngOnInit() {
    this.customerService.getActiveCustomer().subscribe(data => {
      if (data) {
        this.customer = data;
      }
    });
  }

  increment() {
    this.counter++;
  }

  decrement() {
    if (this.counter > 0) {
      this.counter--;
    }
  }

  saveExtras() {
    this.extras = new ExtrasModel();
    this.extras.amount = this.counter;
    this.extras.price = this.counter * this.costPerOne;
    this.salesOrderService.buyExtras(this.extras).subscribe(data => {
      if(data){
        this.router.navigate(['review-order']);
      }
    })
  }

}
