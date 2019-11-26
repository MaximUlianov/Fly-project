import { Component, OnInit } from '@angular/core';
import {SalesService} from "../../services/sales.service";

@Component({
  selector: 'fly-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent implements OnInit {

  ip: boolean = false;
  constructor(private salesService: SalesService) { }

  ngOnInit() {
    this.salesService.clearAll().subscribe((data) => {
      this.ip = true;
    });
  }

}
