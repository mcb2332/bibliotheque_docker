import {Component, inject, OnInit} from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms';
import {MaisonEditionService} from '../../../services/maisonEdition.service';
import {MaisonEditionModel} from '../../../models/maisonEdition.model';

@Component({
  selector: 'app-maison-edition-insert',
  imports: [FormsModule],
  standalone: true,
  templateUrl: './maison-edition-insert.html',
  styleUrl: './maison-edition-insert.css'
})
export class MaisonEditionInsert implements OnInit{

  maisonEditionService: MaisonEditionService = inject(MaisonEditionService);
  maisonEdition: MaisonEditionModel = new MaisonEditionModel();
  ngOnInit() {}

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.maisonEditionService.insertMaisonEdition(this.maisonEdition).subscribe({
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
