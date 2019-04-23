import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { HippsterhouseSharedModule } from 'app/shared';
import {
    ArtikelComponent,
    ArtikelDetailComponent,
    ArtikelUpdateComponent,
    ArtikelDeletePopupComponent,
    ArtikelDeleteDialogComponent,
    artikelRoute,
    artikelPopupRoute
} from './';

const ENTITY_STATES = [...artikelRoute, ...artikelPopupRoute];

@NgModule({
    imports: [HippsterhouseSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        ArtikelComponent,
        ArtikelDetailComponent,
        ArtikelUpdateComponent,
        ArtikelDeleteDialogComponent,
        ArtikelDeletePopupComponent
    ],
    entryComponents: [ArtikelComponent, ArtikelUpdateComponent, ArtikelDeleteDialogComponent, ArtikelDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HippsterhouseArtikelModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
