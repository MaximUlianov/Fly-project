import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'fly-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent implements OnInit {

  ip: boolean = false;
  constructor() { }

  ngOnInit() {
    setTimeout(()=>{
      this.ip = true;
    }, 2000);
  }

}
