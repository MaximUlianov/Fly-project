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

const appRoutes: Routes = [
  {path: 'main', component: LandingComponent},
  {path:'flight-choose', component: FlightsComponent},
  {path:'registration', component: CustomerRegistrationComponent},
  {path:'extras', component: ExtrasComponent},
  {path:'review-order', component: ReviewOrderComponent},
  {path:'confirmation', component: ConfirmationComponent},
  {path:'main/flight-choose', redirectTo:'flight-choose', pathMatch:'full'}
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
    ReviewOrderComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
