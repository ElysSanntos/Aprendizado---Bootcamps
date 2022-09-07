import { CategoriaModel } from "./categoria.model";
import { ImagemModel } from "./imagem.model";

export class ProdutoModel {

    idProduto : number;
    nome : string;
    preco : number;
    descricao : string;
    categorias : Array<CategoriaModel>
    imagens : Array<ImagemModel>;

}