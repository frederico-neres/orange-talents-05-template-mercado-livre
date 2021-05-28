package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento;

import org.springframework.web.util.UriComponentsBuilder;

public enum GatewayType {
    PAYPAL {
        @Override
        public String getUrlRedirect(UriComponentsBuilder uriComponentsBuilder, Long idCompra) {
            String url = uriComponentsBuilder.path("/paypal/{id}").buildAndExpand(idCompra).toString();

            return "paypal.com?buyerId=" + idCompra
                    + "&redirectUrl=" + url;
        }
    },

    PAGSEGURO {
        @Override
        public String getUrlRedirect(UriComponentsBuilder uriComponentsBuilder, Long idCompra) {
            String url = uriComponentsBuilder.path("/pagseguro/{id}").buildAndExpand(idCompra).toString();

            return "pagseguro.com?returnId=" + idCompra
                    + "&redirectUrl=" + url;
        }
    };

    public abstract String getUrlRedirect(UriComponentsBuilder uriComponentsBuilder, Long idCompra);
}
