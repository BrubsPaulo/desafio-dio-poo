package br.com.dio.desafio.poo;

public class Livro extends Autor {

    private int codigo;
    private String titulo;
    private int numPagina;
    private double valorCompra;

    public Livro(int codigo, String titulo, int numPagina, double valorCompra) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.numPagina = numPagina;
        this.valorCompra = valorCompra;
    }
    public Livro() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return  "\nCódigo: " + codigo +
                "\nTitulo: " + titulo +
                "\nNumero de Páginas: " + numPagina +
                "\nValor Compra: " + valorCompra +
                "\nNome Autor: " + getNomeAutor() +" \n";
    }
}
