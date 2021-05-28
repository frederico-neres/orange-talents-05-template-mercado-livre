package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento;

public enum PagseguroStatus {
    ERRO,
    SUCESSO;

    public StatusTransacao parse(){
        return this.equals(SUCESSO)? StatusTransacao.SUCESSO : StatusTransacao.ERRO;
    }
}
