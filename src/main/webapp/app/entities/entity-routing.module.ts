import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'ang-bdg',
        data: { pageTitle: 'jhipsterTest002App.jhipsterTest002AngBdg.home.title' },
        loadChildren: () => import('./jhipsterTest002/ang-bdg/ang-bdg.module').then(m => m.JhipsterTest002AngBdgModule),
      },
      {
        path: 'ang-res',
        data: { pageTitle: 'jhipsterTest002App.jhipsterTest002AngRes.home.title' },
        loadChildren: () => import('./jhipsterTest002/ang-res/ang-res.module').then(m => m.JhipsterTest002AngResModule),
      },
      {
        path: 'ang-grp',
        data: { pageTitle: 'jhipsterTest002App.jhipsterTest002AngGrp.home.title' },
        loadChildren: () => import('./jhipsterTest002/ang-grp/ang-grp.module').then(m => m.JhipsterTest002AngGrpModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
