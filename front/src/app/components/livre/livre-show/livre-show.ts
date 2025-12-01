import {Component, inject, OnInit} from '@angular/core';
import { LivreService } from '../../../services/livre.service';
import { LivreModel } from '../../../models/livre.model';
import { TableModule } from 'primeng/table';

@Component({
  selector: 'app-livre',
  imports: [TableModule],
  templateUrl: './livre-show.html',
  styleUrl: './livre-show.css'
})
export class LivreShow implements OnInit {
  livreService: LivreService = inject(LivreService);
  livreList: LivreModel[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.livreService.getAllLivres().subscribe((livreList: LivreModel[])=> {
      this.livreList = livreList;
    })
  }
}
