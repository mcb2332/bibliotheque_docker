import {Component, inject, OnInit} from '@angular/core';
import {MaisonEditionService} from '../../../services/maisonEdition.service';
import {MaisonEditionModel} from '../../../models/maisonEdition.model';

@Component({
  selector: 'app-maison-edition-show',
  imports: [],
  templateUrl: './maison-edition-show.html',
  styleUrl: './maison-edition-show.css'
})
export class MaisonEditionShow implements OnInit{
  maisonEditionService: MaisonEditionService = inject(MaisonEditionService);
  maisonEditionList: MaisonEditionModel[] = [];

  ngOnInit() {
    this.maisonEditionService.getAllMaisonsEdition().subscribe((maisonEditionList: MaisonEditionModel[])=> {
      this.maisonEditionList = maisonEditionList;
    })
  }
}
