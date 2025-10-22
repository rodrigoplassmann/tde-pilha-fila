public class FilaAtendimento {
    private No cabeca;
    private No cauda;

    public FilaAtendimento(){
        this.cabeca = null;
        this.cauda = null;
    }

    public void adicionarCliente(Elemento e){
        No n = new No();
        n.setElemento(e);
        if(cauda == null){
            cabeca = n;
            cauda = n;
        }
        else{
            cauda.setProx(n);
            cauda = n;
        }
    }

    public boolean vazia(){
        return cabeca == null;
    }

    public Elemento remove(){
        if(vazia()){
            System.out.println("Fila vazia!");
            return null;
        }
        else{
            Elemento e = cabeca.getElemento();
            cabeca = cabeca.getProx();

            if(cabeca == null){
                cauda = null;
            }
            return e;
        }
    }

    public void imprime(){
        for(No atual = cabeca; atual != null; atual = atual.getProx()){
            Elemento e = atual.getElemento();
            System.out.println(e.getIdCliente() + " - " + e.getNomeCliente() + " - " + e.getMotivoAtendimento());
        }
    }
}
