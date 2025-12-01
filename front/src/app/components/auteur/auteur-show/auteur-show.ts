import {Component, inject, OnInit} from '@angular/core';
import {AuteurService} from '../../../services/auteur.service';
import {AuteurModel} from '../../../models/auteur.model';

@Component({
  selector: 'app-auteur-show',
  imports: [],
  templateUrl: './auteur-show.html',
  styleUrl: './auteur-show.css'
})
export class AuteurShow implements OnInit{
  auteurService: AuteurService = inject(AuteurService);
  auteurList: AuteurModel[] = [];

  ngOnInit() {
    this.auteurService.getAllAuteurs().subscribe((auteurList: AuteurModel[])=> {
        this.auteurList = auteurList;
      }
    )
  }
}
