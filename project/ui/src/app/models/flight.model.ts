import {QouteModel} from "./qoute.model";

export class FlightModel {
  quotes: QouteModel[];
  originCity: string;
  originCode: string;
  destinationCity: string;
  destinationCode: string;
  back: boolean;
}
