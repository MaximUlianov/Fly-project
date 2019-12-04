import {FlightModel} from "./flight.model";
import {CustomerModel} from "./customer.model";
import {ExtrasModel} from "./extras.model";

export class SalesOrderModel {
  ticketThere: FlightModel;
  ticketBack: FlightModel;
  customer: CustomerModel;
  extras: ExtrasModel;
  totalPrice: number;

}
