import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {SearchBarComponent} from './components/search-bar/search-bar.component';
import {CustomerRegistrationComponent} from './components/customer-registration/customer-registration.component';
import {FlightsComponent} from './components/flights/flights.component';
import {LandingComponent} from './components/landing/landing.component';
import {ExtrasComponent} from './components/extras/extras.component';
import {ConfirmationComponent} from './components/confirmation/confirmation.component';
import {RouterModule, Routes} from "@angular/router";
import { ReviewOrderComponent } from './components/review-order/review-order.component';
import {ReactiveFormsModule} from "@angular/forms";
import {FlightService} from "./services/flight.service";
import {HttpClientModule} from "@angular/common/http";
import {HeaderNavigationComponent} from './components/header-navigation/header-navigation.component';
import {CustomerService} from "./services/customer.service";
import { ErrorFieldComponent } from './components/error-field/error-field.component';
import { ErrorPopupComponent } from './components/error-popup/error-popup.component';

const appRoutes: Routes = [
  {path: 'main', component: LandingComponent},
  {path:'flight-choose', component: FlightsComponent},
  {path:'registration', component: CustomerRegistrationComponent},
  {path:'extras', component: ExtrasComponent},
  {path:'review-order', component: ReviewOrderComponent},
  {path:'confirmation', component: ConfirmationComponent},

  {path:'', redirectTo:'/main', pathMatch:'full'},
  {path:'main/flight-choose', redirectTo:'flight-choose', pathMatch:'full'},
  {path:'flight-choose/registration', redirectTo:'registration', pathMatch:'full'},
  {path:'registration/flight-choose', redirectTo:'flight-choose', pathMatch:'full'},
  {path:'registration/extras', redirectTo:'extras', pathMatch:'full'},
  {path:'extras/registration', redirectTo:'registration', pathMatch:'full'},
  {path:'extras/flight-choose', redirectTo:'flight-choose', pathMatch:'full'},
  {path:'extras/review-order', redirectTo:'review-order', pathMatch:'full'},
  {path:'review-order/extras', redirectTo:'extras', pathMatch:'full'},
  {path:'review-order/confirmation', redirectTo:'confirmation', pathMatch:'full'},
  {path:'confirmation/main', redirectTo:'main', pathMatch:'full'},
];


@NgModule({
  declarations: [
    AppComponent,
    SearchBarComponent,
    CustomerRegistrationComponent,
    FlightsComponent,
    LandingComponent,
    ExtrasComponent,
    ConfirmationComponent,
    ReviewOrderComponent,
    HeaderNavigationComponent,
    ErrorFieldComponent,
    ErrorPopupComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [FlightService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
