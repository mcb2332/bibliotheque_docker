import { Component, signal } from '@angular/core';
import { LivreShow } from './components/livre/livre-show/livre-show';
import {RouterModule} from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

}
