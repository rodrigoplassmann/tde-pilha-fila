public class No {
    private Elemento elemento;
    private No prox;

    public No(){
        this.elemento = null;
        this.prox = null;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
