public class PilhaSolicitacoes {
    private No topo;

    public PilhaSolicitacoes(){
        this.topo = null;
    }

    public void adicionaSolicitacao(Elemento e){
        No n = new No();
        n.setElemento(e);
        if(topo == null){
            topo = n;
        }
        else{
            n.setProx(topo);
            topo = n;
        }
    }

    public boolean vazia(){
        return topo == null;
    }

    public Elemento removeSolicitacao(){
        if(vazia()){
            System.out.println("Pilha vazia");
            return null;
        }
        else{
            Elemento e = topo.getElemento();
            topo = topo.getProx();
            return e;
        }
    }

    public void exibeHistorico(){
        if(vazia()){
            System.out.println("Pilha vazia");
        }
        else{
            for(No atual = topo; atual != null; atual = atual.getProx()){
                Elemento e = atual.getElemento();
                System.out.println(e.getIdSolicitacao() + " - " + e.getDescricaoSolicitacao() + " - " + e.getDataHora());
            }
        }
    }
}
