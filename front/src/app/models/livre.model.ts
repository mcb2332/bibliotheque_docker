import {AuteurModel} from './auteur.model';
import {MaisonEditionModel} from './maisonEdition.model';

export class LivreModel {
  id: number;
  titre: string;
  anneePublication: number | null;
  isbn: number | null;
  auteur: AuteurModel | null = null;
  maisonEdition: MaisonEditionModel | null = null;

  constructor() {
    this.id = 0;
    this.titre = '';
    this.anneePublication = null;
    this.isbn = null;
    this.auteur = {} as AuteurModel;
    this.maisonEdition = {} as MaisonEditionModel;
  }
}
