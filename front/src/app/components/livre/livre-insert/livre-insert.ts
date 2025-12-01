import {Component, inject, OnInit} from '@angular/core';
import {LivreService} from '../../../services/livre.service';
import {FormsModule, NgForm} from '@angular/forms';
import {LivreModel} from '../../../models/livre.model';
import {AuteurModel} from '../../../models/auteur.model';
import {MaisonEditionModel} from '../../../models/maisonEdition.model';
import {AuteurService} from '../../../services/auteur.service';
import {MaisonEditionService} from '../../../services/maisonEdition.service';

@Component({
  selector: 'app-insert-livre',
  imports: [
    FormsModule
  ],
  templateUrl: './livre-insert.html',
  styleUrl: './livre-insert.css'
})
export class LivreInsert implements OnInit {
  livreService: LivreService = inject(LivreService);
  auteurService: AuteurService = inject(AuteurService);
  maisonEditionService: MaisonEditionService = inject(MaisonEditionService);
  livre: LivreModel = new LivreModel();
  auteurs: AuteurModel[] = [];
  maisonsEdition: MaisonEditionModel[] = [];

  ngOnInit() {
    this.getAuteursAndMaisonsEdition();
    this.livre.auteur = null;
    this.livre.maisonEdition = null;
  }

  getAuteursAndMaisonsEdition() {
    this.auteurService.getAllAuteurs().subscribe((listAuteur: AuteurModel[]) => {
      this.auteurs = listAuteur;
    })
    this.maisonEditionService.getAllMaisonsEdition().subscribe((listMaisonsEdition: MaisonEditionModel[]) => {
      this.maisonsEdition = listMaisonsEdition;
    })
  }

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.livreService.insertLivre(this.livre).subscribe({
        next: () => {
          form.resetForm()
        },
        error: (err) => {
          console.log("There was an error : " + err);
        }
      })
    }
  }
}

