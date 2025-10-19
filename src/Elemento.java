public class Elemento {
    private String idSolicitacao;
    private String descricaoSolicitacao;
    private String dataHora;

    private String nomeCliente;
    private String idCliente;
    private String motivoAtendimento;

    public Elemento(String idSolicitacao, String descricaoSolicitacao, String dataHora){
        this.idSolicitacao = idSolicitacao;
        this.descricaoSolicitacao = descricaoSolicitacao;
        this.dataHora = dataHora;
    }

    public Elemento(String nomeCliente, String idCliente, String motivoAtendimento, int clienteFlag){
        this.nomeCliente = nomeCliente;
        this.idCliente = idCliente;
        this.motivoAtendimento = motivoAtendimento;
    }

    public String getIdSolicitacao() { return idSolicitacao; }
    public void setIdSolicitacao(String idSolicitacao) { this.idSolicitacao = idSolicitacao; }

    public String getDescricaoSolicitacao() { return descricaoSolicitacao; }
    public void setDescricaoSolicitacao(String descricaoSolicitacao) { this.descricaoSolicitacao = descricaoSolicitacao; }

    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }

    public String getMotivoAtendimento() { return motivoAtendimento; }
    public void setMotivoAtendimento(String motivoAtendimento) { this.motivoAtendimento = motivoAtendimento; }
}
