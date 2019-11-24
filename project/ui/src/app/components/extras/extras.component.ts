import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'fly-extras',
  templateUrl: './extras.component.html',
  styleUrls: ['./extras.component.css']
})
export class ExtrasComponent implements OnInit {

  public counter: number = 0;

  constructor() { }

  ngOnInit() {
  }

  increment(){
    this.counter++;
  }

  decrement(){
    if (this.counter > 0) {
      this.counter--;
    }
  }

}
