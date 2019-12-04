import {Component, OnInit} from '@angular/core';
import {SalesService} from "../../services/sales.service";
import {SalesOrderModel} from "../../models/sales.order.model";

@Component({
  selector: 'app-review-order',
  templateUrl: './review-order.component.html',
  styleUrls: ['./review-order.component.css']
})
export class ReviewOrderComponent implements OnInit {

  public salesOrder: SalesOrderModel;

  constructor(private salesOrderService: SalesService) {
  }

  ngOnInit() {
    this.salesOrderService.getSalesOrder().subscribe(data => {
      this.salesOrder = data;
    });
  }

}
