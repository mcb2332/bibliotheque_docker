import {Component, inject, OnInit} from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms';
import {AuteurService} from '../../../services/auteur.service';
import {AuteurModel} from '../../../models/auteur.model';

@Component({
  selector: 'app-auteur-insert',
  imports: [FormsModule],
  templateUrl: './auteur-insert.html',
  standalone: true,
  styleUrl: './auteur-insert.css'
})
export class AuteurInsert implements OnInit {

  auteurService: AuteurService = inject(AuteurService);
  auteur: AuteurModel = new AuteurModel();

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.auteurService.insertAuteur(this.auteur).subscribe({
        next: () => {
          form.resetForm();
        },
        error: (err) => console.error('Erreur', err)
      });
    }
  }
}
