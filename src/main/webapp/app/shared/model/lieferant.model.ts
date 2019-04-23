import { IArtikel } from 'app/shared/model/artikel.model';

export interface ILieferant {
    id?: number;
    lname?: string;
    lnames?: IArtikel[];
}

export class Lieferant implements ILieferant {
    constructor(public id?: number, public lname?: string, public lnames?: IArtikel[]) {}
}
