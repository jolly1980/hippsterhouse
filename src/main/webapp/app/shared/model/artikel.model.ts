import { ILieferant } from 'app/shared/model/lieferant.model';

export interface IArtikel {
    id?: number;
    artikelbezeichnung?: string;
    preis?: number;
    lieferant?: ILieferant;
}

export class Artikel implements IArtikel {
    constructor(public id?: number, public artikelbezeichnung?: string, public preis?: number, public lieferant?: ILieferant) {}
}
