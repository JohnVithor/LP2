/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

/**
 *
 * @author johnvithor
 */
public class Livro extends ProdutoDuravel {
    /** titulo.
     *
     */
    private String titulo;
    /** autor.
     *
     */
    private String autor;
    /** construtor vazio.
     *
     */
    public Livro() {
    }
    /**
     *
     * @param paramTitulo paramTitulo
     * @param paramAutor paramAutor
     */
    public Livro(final String paramTitulo, final String paramAutor) {
        this.titulo = paramTitulo;
        this.autor = paramAutor;
    }
    /**
     *
     * @param paramTitulo paramTitulo
     * @param paramAutor paramAutor
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     */
    public Livro(final String paramTitulo, final String paramAutor,
                 final String paramMaterialPredominante,
                 final String paramDurabilidade) {
        super(paramMaterialPredominante, paramDurabilidade);
        this.titulo = paramTitulo;
        this.autor = paramAutor;
    }
    /**
     *
     * @param paramTitulo paramTitulo
     * @param paramAutor paramAutor
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public Livro(final String paramTitulo, final String paramAutor,
                 final String paramMaterialPredominante,
                 final String paramDurabilidade,
                 final String paramNovoNome, final Double paramNovoPreco,
                 final String paramNovaMarca, final String paramNovaDescricao,
                 final String paramNovaDataDeFabricacao) {
        super(paramMaterialPredominante, paramDurabilidade, paramNovoNome,
              paramNovoPreco, paramNovaMarca, paramNovaDescricao,
              paramNovaDataDeFabricacao);
        this.titulo = paramTitulo;
        this.autor = paramAutor;
    }

    /**
     * @return the titulo
     */
    public final String getTitulo() {
        return titulo;
    }

    /**
     * @param paramTitulo the titulo to set
     */
    public final void setTitulo(final String paramTitulo) {
        this.titulo = paramTitulo;
    }

    /**
     * @return the autor
     */
    public final String getAutor() {
        return autor;
    }

    /**
     * @param paramAutor the autor to set
     */
    public final void setAutor(final String paramAutor) {
        this.autor = paramAutor;
    }
}
