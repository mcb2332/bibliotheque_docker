import {Routes} from '@angular/router';
import {LivreShow} from './components/livre/livre-show/livre-show';
import {AuteurShow} from './components/auteur/auteur-show/auteur-show';
import {MaisonEditionShow} from './components/maisonEdition/maison-edition-show/maison-edition-show';
import {AuteurInsert} from './components/auteur/auteur-insert/auteur-insert';
import {MaisonEditionInsert} from './components/maisonEdition/maison-edition-insert/maison-edition-insert';
import {LivreInsert} from './components/livre/livre-insert/livre-insert';
import {Accueil} from './components/accueil/accueil';

export const routes: Routes = [
  {
    path: '',
    title: 'ACCUEIL',
    component: Accueil
  },
  {
    path: 'livre',
    children: [{
      path: 'allLivres',
      title: 'Tous les livres',
      component: LivreShow
    },
      {
        path: 'insertLivre',
        title: "Ajout d'un livre",
        component: LivreInsert
      }
    ]
  },
  {
    path: 'auteur',
    children: [{
      path: 'allAuteurs',
      title: 'Tous les acteurs',
      component: AuteurShow
    },
      {
        path: 'insertAuteur',
        title: "Ajout d'un auteur",
        component: AuteurInsert
      }
    ]
  },
  {
    path: 'maisonEdition',
    children: [{
      path: 'allMaisonsEdition',
      title: "Toutes les maisons",
      component: MaisonEditionShow
    },
      {
        path: 'insertMaisonEdition',
        title: "Ajout d'une maison",
        component: MaisonEditionInsert
      }
    ]
  }
];
